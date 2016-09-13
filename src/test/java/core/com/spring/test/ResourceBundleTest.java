package core.com.spring.test;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Test;

import core.com.spring.test.exception.ExceptionMessages;

public class ResourceBundleTest {

	@Test
	public void testExceptionResource() {
		ResourceBundle rBR = ResourceBundle.getBundle("exceptions");
		Assert.assertEquals("Erro ao tentar fazer login",rBR.getString("login.erro"));
		Assert.assertEquals("Sucesso ao Login",rBR.getString("login.sucesso"));
		Assert.assertEquals("é uma frase com ação",rBR.getString("login.acento"));
	}

	@Test
	public void enumsTest() {
		ResourceBundle rBR = ResourceBundle.getBundle("exceptions");
		for (ExceptionMessages m : ExceptionMessages.values()) {
			if (!rBR.containsKey(m.getValue())) {
				Assert.fail("Não existe mensagem para a chave: " + m.getValue() + " no arquivo exceptions.properties");
			}
		}
	}
}
