import java.util.*;
public abstract class  Validator {
    protected final SudokuBoard board;
    protected volatile boolean valid = true;

    private final List<String> errors = Collections.synchronizedList(new ArrayList<>());

    public Validator(SudokuBoard b) { this.board = b; }

    public abstract void runValidation();

    public synchronized void addError(String s) {
        valid = false;
        errors.add(s);
    }

    public boolean isValid() {
        return valid;
    }

    public void printErrors() {
        synchronized (errors) {
            for (String e : errors) System.out.println(e);
        }
    }
}
