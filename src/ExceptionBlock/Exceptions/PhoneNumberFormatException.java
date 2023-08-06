package ExceptionBlock.Exceptions;

public class PhoneNumberFormatException extends NumberFormatException{
    private long pn;

    public PhoneNumberFormatException(long pn) {
        super("Unsupported phone-number format:" + pn);
        this.pn = pn;
    }
}
