package ExceptionBlock.Exceptions;

public class GenderArgumentException extends IllegalArgumentException{
    private char gender;

    public GenderArgumentException( char gender) {
        super("Illegal gender symbol: " + gender);
        this.gender = gender;
    }
}
