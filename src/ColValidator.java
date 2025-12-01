import java.util.*;

public class ColValidator implements Runnable {
    private final SudokuBoard board;
    private final int col;
    private final Validator parent;

    public ColValidator(SudokuBoard board, int col, Validator parent) {
        this.board = board; this.col = col; this.parent = parent;
    }

    @Override
    public void run() {
        List<Integer>[] positions = new List[10];
        for (int d = 1; d <= 9; d++) positions[d] = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            int val = board.get(r, col);
            positions[val].add(r + 1);
        }

        for (int d = 1; d <= 9; d++) {
            if (positions[d].size() > 1) {
                parent.addError("COL " + (col+1) + ", #" + d + ", " + toListString(positions[d]));
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
