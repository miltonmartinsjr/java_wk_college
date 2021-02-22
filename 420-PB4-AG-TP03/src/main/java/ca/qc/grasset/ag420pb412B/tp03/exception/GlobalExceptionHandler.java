package ca.qc.grasset.ag420pb412B.tp03.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@SuppressWarnings("static-method")
@ControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {

        super();
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> globleExcpetionHandler(
        final Exception exception_,
        final WebRequest webRequest_) {

        ErrorDetails errorDetails =
            new ErrorDetails(
                new Date(),
                exception_.getMessage(),
                webRequest_.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<?> resourceNotFoundException(
        final ResourceNotFoundException resourceNotFoundException_,
        final WebRequest webRequest_) {

        ErrorDetails errorDetails =
            new ErrorDetails(
                new Date(),
                resourceNotFoundException_.getMessage(),
                webRequest_.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
