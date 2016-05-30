package core.com.spring.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Nilton Fernando
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase a) {
        this.caseMode = a.value();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext cvc) {
        boolean isValid;
        if (object == null) {
            return true;
        }

        if (caseMode == CaseMode.UPPER) {
            isValid = object.equals(object.toUpperCase());
        } else {
            isValid = object.equals(object.toLowerCase());
        }
        return isValid;
    }

}
