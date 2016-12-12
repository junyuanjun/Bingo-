package exception;

public class FormatException extends Exception {
    private String message;

    public FormatException() {
        this.message = "Format error.";
    }

    public String getMessage() {
        return this.message;
    }
}
