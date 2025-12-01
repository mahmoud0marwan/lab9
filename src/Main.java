import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar app.jar <file.csv> <mode>");
            return;
        }

        String path = args[0];
        int mode;
        try {
            mode = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Mode must be 0, 3, or 27");
            return;
        }

        try {
            SudokuBoard board = new SudokuBoard(path);
            ValidatorFactory factory = new ValidatorFactory(board);
            Validator validator = factory.createValidator(mode);

            validator.runValidation();

            if (validator.isValid()) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
                validator.printErrors();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

