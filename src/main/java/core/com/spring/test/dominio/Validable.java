package core.com.spring.test.dominio;

import javax.validation.ConstraintValidatorContext;

import core.com.spring.test.validator.ValidableEntity;

@ValidableEntity
public interface Validable {

	boolean validate(ConstraintValidatorContext cvc);

}
