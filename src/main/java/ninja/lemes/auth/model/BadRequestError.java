package ninja.lemes.auth.model;

public class BadRequestError {

    private final String message;

    public BadRequestError(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
