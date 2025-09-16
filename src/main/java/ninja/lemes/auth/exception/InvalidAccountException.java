package ninja.lemes.auth.exception;

public class InvalidAccountException extends IllegalArgumentException {

    public InvalidAccountException(final String message) {
        super(message);
    }

}
