import java.util.*;

public class BoxValidator implements Runnable {
    private final SudokuBoard board;
    private final int box;
    private final Validator parent;

    public BoxValidator(SudokuBoard board, int box, Validator parent) {
        this.board = board; this.box = box; this.parent = parent;
    }

    @Override
    public void run() {
        List<Integer>[] positions = new List[10];
        for (int d = 1; d <= 9; d++) positions[d] = new ArrayList<>();

        int sr = (box / 3) * 3;
        int sc = (box % 3) * 3;
        int pos = 1;
        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                int v = board.get(r, c);
                positions[v].add(pos);
                pos++;}
        }

        for (int d = 1; d <= 9; d++) {
            if (positions[d].size() > 1) {
                parent.addError("BOX " + (box+1) + ", #" + d + ", " + toListString(positions[d]));
            }
        }
    }

    private String toListString(List<Integer> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}


