package exception;

public class NameFormatException extends FormatException {
    private String variable;
    private int index;

    public NameFormatException(String variable, int index) {
        this.variable = variable;
        this.index = index;
    }

    @Override
    public String getMessage() {
        return "The char: " + variable + "[" + index + "] is illegal.";
    }
}
