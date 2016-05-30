package core.com.spring.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import core.com.spring.test.dominio.Validable;

/**
 * @author Nilton Fernando
 */
public class AnoFabricaoModeloConstraint implements ConstraintValidator<AnoFabricacaoMaiorQueAnoModelo, Validable> {

    @Override
    public void initialize(AnoFabricacaoMaiorQueAnoModelo a) {

    }

    @Override
    public boolean isValid(Validable t, ConstraintValidatorContext cvc) {
        cvc.disableDefaultConstraintViolation();
        return t.validate(cvc);
    }

}
