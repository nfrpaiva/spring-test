/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.validator.custom;

import core.com.spring.test.dominio.Automovel;
import core.com.spring.test.dominio.Pessoa;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class CustomConstraintTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public CustomConstraintTest() {
    }

    @Test
    public void customConstraint() {
        Pessoa pojo = new Pessoa();
        pojo.setNome("lowcaseText");
        Set<ConstraintViolation<Pessoa>> validate = validator.validate(pojo);
        Assert.assertEquals(1, validate.size());
        ConstraintViolation<Pessoa> next = validate.iterator().next();
        String mensagem = next.getMessage();

        Assert.assertEquals("O texto deve estar em maiúsculo", mensagem);
        pojo.setNome("UPPER");
        Set<ConstraintViolation<Pessoa>> validate1 = validator.validate(pojo);
        Assert.assertEquals(0, validate1.size());
    }

    @Test
    public void customConstraintClassLevel() {
        Automovel a = new Automovel();
        Set<ConstraintViolation<Automovel>> validate = validator.validate(a);
        Assert.assertEquals(2, validate.size());
        a.setAnoFabricacao(2000);
        a.setAnoModelo(1999);
        Set<ConstraintViolation<Automovel>> validate1 = validator.validate(a);
        Assert.assertEquals(1, validate1.size());
        ConstraintViolation<Automovel> next = validate1.iterator().next();
        String mensagem = next.getMessage();
        Assert.assertEquals("O ano de fabricacao deve ser maior que o ano modelo", mensagem);
    }
}
