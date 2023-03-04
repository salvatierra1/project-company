package jardin.empresa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> NotFoundRequestException(NotFoundException notFoundException){
        return ResponseEntity.status(404).body(notFoundException.getMessage());
    }

}
