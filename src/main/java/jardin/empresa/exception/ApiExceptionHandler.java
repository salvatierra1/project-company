package jardin.empresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchElementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiExceptionResponse> noSuchElementExceptionHandler(NoSuchElementException noSuchElementException) {
        var apiException = new ApiExceptionResponse(
                noSuchElementException.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiException);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiExceptionResponse> illegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException) {
        var apiException = new ApiExceptionResponse(
                illegalArgumentException.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }

    @ExceptionHandler(value = {GenericException.class})
    public ResponseEntity<ApiExceptionResponse> genericExceptionHandler(GenericException genericException) {
        var apiException = new ApiExceptionResponse(
                genericException.getMessage(),
                genericException.getHttpStatus().value()
        );
        return ResponseEntity.status(genericException.getHttpStatus()).body(apiException);
    }
}
