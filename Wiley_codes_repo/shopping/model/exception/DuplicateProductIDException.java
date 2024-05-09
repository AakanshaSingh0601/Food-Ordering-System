package shopping.model.exception;

public class DuplicateProductIDException extends RuntimeException  {
    public DuplicateProductIDException(String message) {
        super(message);
    }
}
