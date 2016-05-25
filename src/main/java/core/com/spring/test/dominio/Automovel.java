/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.dominio;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

/**
 * @author Nilton Fernando
 */
public class Automovel implements Validable {

	@NotNull
	private Integer anoFabricacao;
	@NotNull
	private Integer anoModelo;

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	@Override
	public boolean validate(ConstraintValidatorContext cvc) {
		if (getAnoFabricacao() == null || getAnoModelo() == null) {
			return true;
		}
		boolean isValid;
		if (getAnoFabricacao() > getAnoModelo()) {
			isValid = false;
			cvc.disableDefaultConstraintViolation();
			cvc.buildConstraintViolationWithTemplate("{core.com.spring.test.constraint.anofabricacao}").addPropertyNode("anoFabricacao").addConstraintViolation();
		} else {
			isValid = true;
		}
		return isValid;

	}

}
