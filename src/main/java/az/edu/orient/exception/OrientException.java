package az.edu.orient.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OrientException extends Exception {
    private final HttpStatus httpStatus;
    public OrientException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
