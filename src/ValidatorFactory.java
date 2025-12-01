public class ValidatorFactory {
    private final SudokuBoard board;
    public ValidatorFactory(SudokuBoard b) { this.board = b; }

    public Validator createValidator(int mode) {
        return switch (mode) {
            case 0 -> new SequentialValidator(board);
            case 3 -> new ThreeThreadValidator(board);
            case 27 -> new TwentySevenThreadValidator(board);
            default -> throw new IllegalArgumentException("Mode must be 0, 3, or 27");
        };
    }
}
