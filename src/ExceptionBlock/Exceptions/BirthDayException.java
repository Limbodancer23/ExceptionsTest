package ExceptionBlock.Exceptions;

public class BirthDayException extends NumberFormatException {
    private String birthday;

    public BirthDayException(String birthday) {
        super("Unsupported birthday format: " + birthday);
        this.birthday = birthday;
    }
}
