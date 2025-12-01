public class ThreeThreadValidator extends Validator {
    public ThreeThreadValidator(SudokuBoard b) { super(b); }

    @Override
    public void runValidation() {
        Thread rowThread = new Thread(() -> {
            for (int r = 0; r < 9; r++) new RowValidator(board, r, this).run();
        });

        Thread colThread = new Thread(() -> {
            for (int c = 0; c < 9; c++) new ColValidator(board, c, this).run();
        });

        Thread boxThread = new Thread(() -> {
            for (int b = 0; b < 9; b++) new BoxValidator(board, b, this).run();
        });

        rowThread.start();
        colThread.start();
        boxThread.start();

        try {
            rowThread.join();
            colThread.join();
            boxThread.join();
        } catch (InterruptedException ignored) {}
    }
}
