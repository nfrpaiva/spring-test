/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import core.com.spring.test.dominio.Validable;

/**
 * @author Nilton Fernando
 */
public class AnoFabricaoModeloConstraint implements ConstraintValidator<AnoFabricacaoMaiorQueAnoModelo,Validable> {

	@Override
	public void initialize(AnoFabricacaoMaiorQueAnoModelo a) {

	}

	@Override
	public boolean isValid(Validable t,ConstraintValidatorContext cvc) {
		return t.validate(cvc);
	}

}
