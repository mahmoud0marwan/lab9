public class SequentialValidator extends Validator {
    public SequentialValidator(SudokuBoard b) { super(b); }

    @Override
    public void runValidation() {

        for (int r = 0; r < 9; r++) new RowValidator(board, r, this).run();

        for (int c = 0; c < 9; c++) new ColValidator(board, c, this).run();

        for (int b = 0; b < 9; b++) new BoxValidator(board, b, this).run();
    }
}
