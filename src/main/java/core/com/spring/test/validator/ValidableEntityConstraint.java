package core.com.spring.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import core.com.spring.test.dominio.Validable;

/**
 * @author Nilton Fernando
 */
public class ValidableEntityConstraint implements ConstraintValidator<ValidableEntity, Validable> {

    @Override
    public void initialize(ValidableEntity a) {

    }

    @Override
    public boolean isValid(Validable t, ConstraintValidatorContext cvc) {
        boolean isValid =  t.validate(cvc);
        if(!isValid){
        	cvc.disableDefaultConstraintViolation();
        }
        return isValid;
    }

}
