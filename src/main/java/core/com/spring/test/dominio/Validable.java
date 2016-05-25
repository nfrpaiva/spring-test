package core.com.spring.test.dominio;

import javax.validation.ConstraintValidatorContext;

import core.com.spring.test.validator.AnoFabricacaoMaiorQueAnoModelo;

@AnoFabricacaoMaiorQueAnoModelo
public interface Validable {

	boolean validate(ConstraintValidatorContext cvc);

}
