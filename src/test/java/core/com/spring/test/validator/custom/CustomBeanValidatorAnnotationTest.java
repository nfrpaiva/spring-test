package core.com.spring.test.validator.custom;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

import org.junit.Test;

import core.com.spring.test.validator.AnoFabricacaoMaiorQueAnoModelo;
import core.com.spring.test.validator.CaseMode;
import core.com.spring.test.validator.CheckCase;

public class CustomBeanValidatorAnnotationTest {

	@CheckCase(value = CaseMode.UPPER)
	private String nome;

	public String getNome() {
		return nome;
	}

	private final ResourceBundle resource = ResourceBundle.getBundle("ValidationMessages");

	@Test
	public void testCheckCaseAnnotation() throws Exception {
		String key = this.getClass().getDeclaredField("nome").getAnnotation(CheckCase.class).message();
		assertKey(key);
	}

	public void testAnoFabricacaoMaiorQueAnoModeloAnnotation() throws Exception {
		Class<?>[] args = new Class[]{};
		Method m = AnoFabricacaoMaiorQueAnoModelo.class.getMethod("message",args);
		String key = (String) m.invoke(AnoFabricacaoMaiorQueAnoModelo.class,new Object[]{});
		assertKey(key);
	}

	private void assertKey(String key) {
		key = key.replace("{","").replace("}","");
		assertTrue("Resource ValidationMessage deve conter a chave: " + key,resource.containsKey(key));
	}

}
