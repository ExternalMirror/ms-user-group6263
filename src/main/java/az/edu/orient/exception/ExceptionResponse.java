package az.edu.orient.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExceptionResponse {
    private int httpCode;
    private String message;
    private List<FieldValidationError> validations;
}

