package ninja.lemes.auth.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ninja.lemes.auth.model.BadRequestError;

@ControllerAdvice
public class AccountExceptionHandler {

    @ExceptionHandler(InvalidAccountException.class)
    public ResponseEntity<BadRequestError> handleIllegalArgument(InvalidAccountException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(new BadRequestError(exception.getMessage()));
    }

}
