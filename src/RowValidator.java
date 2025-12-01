import java.util.*;

public class RowValidator implements Runnable {
    private final SudokuBoard board;
    private final int row;
    private final Validator parent;

    public RowValidator(SudokuBoard board, int row, Validator parent) {
        this.board = board; this.row = row; this.parent = parent;
    }

    @Override
    public void run() {
        List<Integer>[] positions = new List[10];
        for (int d = 1; d <= 9; d++) positions[d] = new ArrayList<>();

        for (int c = 0; c < 9; c++) {
            int val = board.get(row, c);
            positions[val].add(c + 1);
        }

        for (int d = 1; d <= 9; d++) {
            if (positions[d].size() > 1) {
                parent.addError(format("ROW " + (row+1) + ", #" + d + ", " + toListString(positions[d])));
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

    private String format(String s) { return s; }
}

