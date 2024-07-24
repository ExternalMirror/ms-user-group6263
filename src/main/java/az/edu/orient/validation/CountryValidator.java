package az.edu.orient.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {
    @Override
    public void initialize(ValidCountry constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }
        return "AZE".equals(value);
    }
}
