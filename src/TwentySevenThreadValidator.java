public class TwentySevenThreadValidator extends Validator {
    public TwentySevenThreadValidator(SudokuBoard b) { super(b); }

    @Override
    public void runValidation() {
        Thread[] threads = new Thread[27];
        int idx = 0;

        for (int r = 0; r < 9; r++) threads[idx++] = new Thread(new RowValidator(board, r, this));

        for (int c = 0; c < 9; c++) threads[idx++] = new Thread(new ColValidator(board, c, this));

        for (int b = 0; b < 9; b++) threads[idx++] = new Thread(new BoxValidator(board, b, this));

        for (Thread t : threads) t.start();
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException ignored) {}
        }
    }
}
