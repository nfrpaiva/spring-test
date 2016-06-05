package core.com.spring.test.exception;

/**
 * @author Nilton Fernando
 */
public enum ExceptionMessages {
	ERRO_AO_LOGIN("login.erro"),
	SUCESSO_LOGIN("login.sucesso"),
	LOGIN_ACENTO("login.acento"),
	NOME_INVALIDO("nome.invalido"), 
	ERRO_GENERICO("erro.generico");

	private final String value;

	private ExceptionMessages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
