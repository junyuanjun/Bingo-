import exception.FormatException;
import exception.NameFormatException;
import exception.NumberFormatException;

public class Controller
{
    private String lastName;
    private String firstName;
    private String year;
    private String month;
    private String day;

    private final int[] maxDay = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int[] meaningTable;

    public Controller(String firstName, String lastName, String year, String month, String day) {
        this.lastName = lastName.toUpperCase();
        this.firstName = firstName.toUpperCase();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void initialize() {
        meaningTable = new int[26];
        for (int i = 0; i < 26; i++) {
            meaningTable[i] = (i % 9) + 1;
        }
    }

    public String calculate() {
        int year = Integer.parseInt(this.year);
        int month = Integer.parseInt(this.month);
        int day = Integer.parseInt(this.day);

        year = (year % 10) + (year / 10 % 10) + (year / 100 % 10) + (year / 1000 % 10);
        year = (year % 10) + (year / 10);
        month = (month % 10) + (month / 10);
        day = (day % 10) + (day / 10);

        int lifePathNumber = year + month + day;
        lifePathNumber = (lifePathNumber / 10) + (lifePathNumber % 10);

        int destinyNumber = calculateName(firstName) + calculateName(lastName);
        if (destinyNumber > 9) {
            destinyNumber = (destinyNumber % 10) + (destinyNumber / 10);
        }

        return "Lift Path Number: " + lifePathNumber + "\nDestiny Number: " + destinyNumber;
    }

    public int calculateName(String name) {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            sum += meaningTable[name.charAt(i) - 'A'];
        }

        return (sum % 10) + (sum / 10);
    }

    public void validate() throws FormatException {
        validateName(firstName);
        validateName(lastName);

        validateNumber(this.year);
        validateNumber(this.month);
        validateNumber(this.day);

        int year = Integer.parseInt(this.year);
        if (year > 2016) {
            throw new NumberFormatException("year", this.year);
        }

        int month = Integer.parseInt(this.month);
        if (month < 1 || month > 12) {
            throw new NumberFormatException("month", this.month);
        }

        int day = Integer.parseInt(this.day);
        if (day < 1 || day > maxDay[month]) {
            throw new NumberFormatException("day", this.day);
        }
    }

    private void validateName(String name) throws NameFormatException {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'A' || name.charAt(i) > 'Z') {
                throw new NameFormatException(name, i);
            }
        }
    }

    private void validateNumber(String number) throws NameFormatException {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                throw new NameFormatException(number, i);
            }
        }
    }

}
