package exception;

public class NumberFormatException extends FormatException {
    private String field;
    private String number;

    public NumberFormatException(String field, String number) {
        this.field = field;
        this.number = number;
    }

    @Override
    public String getMessage() {
        return "The number: " + number + " is out of the " + field + " range";
    }
}
