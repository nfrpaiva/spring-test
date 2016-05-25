/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author fernando
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
