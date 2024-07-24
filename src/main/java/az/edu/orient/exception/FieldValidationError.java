package az.edu.orient.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldValidationError {
    private String fieldError;
}
