package utility;

public class WrongInstanceException extends Exception {
    // Custom checked exception
    public WrongInstanceException(String message) {
        super(message);
    }
}
