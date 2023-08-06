package ExceptionBlock.Exceptions;

public class UserDataException extends IllegalArgumentException{
    private String name;
    public UserDataException(String name) {
        super("Exception in following word!: " + name);
        this.name = name;
    }
}
