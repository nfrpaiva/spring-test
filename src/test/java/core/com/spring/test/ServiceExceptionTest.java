/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test;

import core.com.spring.test.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class ServiceExceptionTest {
    
    @Test
    public void testException(){
        Assert.assertEquals("é uma frase com ação", new ServiceException(ExceptionMessage.LOGIN_ACENTO).getMessage());
        Assert.assertEquals("Erro ao tentar fazer login", new ServiceException(ExceptionMessage.ERRO_AO_LOGIN).getMessage());
        Assert.assertEquals("Sucesso ao Login", new ServiceException(ExceptionMessage.SUCESSO_LOGIN).getMessage());
    }
}
