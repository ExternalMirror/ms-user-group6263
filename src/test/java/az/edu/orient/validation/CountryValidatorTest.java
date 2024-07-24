package az.edu.orient.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryValidatorTest {

    CountryValidator countryValidator = new CountryValidator();

    @Test
    void isValidGivenValueIsNullExpectReturnFalse() {
        //setup
        String value = null;
        //when
        boolean result = countryValidator.isValid(value, null);
        //expect
        assertFalse(result);
    }

    @Test
    void isValidGivenValueIsAZEExpectReturnTrue() {
        //setup
        String value = "AZE";
        //when
        boolean result = countryValidator.isValid(value, null);
        //expect
        assertTrue(result);
    }

    @Test
    void isValidGivenValueIsEmptyStringExpectReturnFalse() {
        //setup
        String value = "";
        //when
        boolean result = countryValidator.isValid(value, null);
        //expect
        assertFalse(result);
    }
}