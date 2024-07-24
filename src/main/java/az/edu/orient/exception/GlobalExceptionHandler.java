package az.edu.orient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrientException.class)
    public ResponseEntity<ExceptionResponse> handleOrientException(OrientException ex) {
        var result = ExceptionResponse.builder().httpCode(ex.getHttpStatus().value()).message(ex.getMessage()).build();

        return ResponseEntity.status(ex.getHttpStatus()).body(result);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleOrientException(MethodArgumentNotValidException ex) {
        List<FieldValidationError> fieldErrors = ex.getFieldErrors().stream()
                .map(e->FieldValidationError.builder().fieldError(e.getDefaultMessage()).build())
                .toList();
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .httpCode(HttpStatus.BAD_REQUEST.value())
                .validations(fieldErrors)
                .build();
        return ResponseEntity.status(exceptionResponse.getHttpCode())
                .body(exceptionResponse);
    }
}
