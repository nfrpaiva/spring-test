package core.com.spring.test;

import core.com.spring.test.exception.ExceptionMensagens;
import java.util.ResourceBundle;
import org.junit.Assert;
import org.junit.Test;

public class ResourceBundleTest {

    @Test
    public void testExceptionResource() {
        ResourceBundle rBR = ResourceBundle.getBundle("exceptions");
        Assert.assertEquals("Erro ao tentar fazer login", rBR.getString("login.erro"));
        Assert.assertEquals("Sucesso ao Login", rBR.getString("login.sucesso"));
        Assert.assertEquals("é uma frase com ação", rBR.getString("login.acento"));
    }

    @Test
    public void enumsTest() {
        ResourceBundle rBR = ResourceBundle.getBundle("exceptions");
        for (ExceptionMensagens m : ExceptionMensagens.values()) {
            Assert.assertTrue(rBR.containsKey(m.getValue()));
        }
    }
}
