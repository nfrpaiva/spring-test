/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.validator;

import core.com.spring.test.dominio.Automovel;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Nilton Fernando
 */
public class AnoFabricaoModeloConstraint implements ConstraintValidator<AnoFabricacaoMaiorQueAnoModelo, Automovel> {

    @Override
    public void initialize(AnoFabricacaoMaiorQueAnoModelo a) {

    }

    @Override
    public boolean isValid(Automovel t, ConstraintValidatorContext cvc) {
        boolean isValid;
        if (t.getAnoFabricacao() == null || t.getAnoModelo() == null) {
            return true;
        }
        if (t.getAnoFabricacao() > t.getAnoModelo()) {
            isValid = false;
            cvc.disableDefaultConstraintViolation();
            cvc.buildConstraintViolationWithTemplate("{core.com.spring.test.constraint.anofabricacao}")
                    .addPropertyNode("anoFabricacao")
                    .addConstraintViolation();
        } else {
            isValid = true;
        }

        return isValid;
    }

}
