package ExceptionBlock.Exceptions;

public class NameSizeException extends Exception{
    private String name;

    public NameSizeException(String name) {
        super("Name size mismatch!: " + name);
        this.name = name;
    }
}
