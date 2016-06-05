package core.com.spring.test.exception;

/**
 * @author Nilton Fernando
 */
public enum ExceptionMessages {
	ERRO_AO_LOGIN("login.erro"),
	SUCESSO_LOGIN("login.sucesso"),
	LOGIN_ACENTO("login.acento"),
	NOME_INVALIDO("nome.invalido"), 
	ERRO_GENERICO("erro.generico"), 
	ERRO_AO_OBTER_APONTAMENTO("erro.obter.apontamento"), 
	ERRO_AO_PARAR_APONTAMENTO ("erro.parar.apontamento"), 
	ERRO_EXISTE_APONTAMENTO_COM_MESMO_RANGE ("erro.parar.ja.existe.range"), 
	ERRO_ENTIDADE_NAO_PODE_SER_NULA("erro.entidade.nao.pode.ser.nula"), 
	ERRO_ID_ENTIDADE_NAO_PODE_SER_NULO ("erro.id.entidade.nao.pode.ser.nulo");

	private final String value;

	private ExceptionMessages(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
