package core.com.spring.test;

import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Nilton Fernando
 */
public class ServiceExceptionTest {
    
    @Test
    public void testException(){
        Assert.assertEquals("é uma frase com ação", new ServiceException(ExceptionMessages.LOGIN_ACENTO).getMessage());
        Assert.assertEquals("Erro ao tentar fazer login", new ServiceException(ExceptionMessages.ERRO_AO_LOGIN).getMessage());
        Assert.assertEquals("Sucesso ao Login", new ServiceException(ExceptionMessages.SUCESSO_LOGIN).getMessage());
    }
}
