package core.com.spring.test.validator.custom;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

import org.junit.Test;

import core.com.spring.test.validator.AnoFabricacaoMaiorQueAnoModelo;
import core.com.spring.test.validator.CaseMode;
import core.com.spring.test.validator.CheckCase;

@AnoFabricacaoMaiorQueAnoModelo
public class CustomBeanValidatorAnnotationTest {

	@CheckCase(value = CaseMode.UPPER)
	private String nome;

	public String getNome() {
		return nome;
	}

	private final ResourceBundle resource = ResourceBundle.getBundle("ValidationMessages");

	@Test
	public void testCheckCaseAnnotation() throws Exception {
		Field[] declaredFields = this.getClass().getDeclaredFields();
		for (int i = 0 ; i < declaredFields.length ; i++) {
			if (declaredFields[i].getName().equals("nome")) {
				Field field = declaredFields[i];
				String key = field.getAnnotation(CheckCase.class).message();
				key = limparChave(key);
				assertKey(key);
			}
		}
	}

	public void testAnoFabricacaoMaiorQueAnoModeloAnnotation() {
		String key = this.getClass().getAnnotation(AnoFabricacaoMaiorQueAnoModelo.class).message();
		key = limparChave(key);
		assertKey(key);
	}

	private void assertKey(String key) {
		assertTrue("Resource ValidationMessage deve conter a chave: " + key,resource.containsKey(key));
	}

	private String limparChave(String key) {
		key = key.replace("{","").replace("}","");
		return key;
	}
}
