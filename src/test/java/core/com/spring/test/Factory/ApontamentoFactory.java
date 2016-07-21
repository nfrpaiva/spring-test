package core.com.spring.test.Factory;

import java.util.Date;

import core.com.spring.test.dominio.Apontamento;

public class ApontamentoFactory {
	private static final Long ANY_APONTAMENTO_ID = Long.MIN_VALUE;

	public static Apontamento novoComId() {
		Apontamento a = new Apontamento();
		a.setId(ANY_APONTAMENTO_ID);
		return a;
	}

	public static Apontamento novoComId(Date inicio) {
		Apontamento a = new Apontamento();
		a.setId(ANY_APONTAMENTO_ID);
		a.setInicio(inicio);
		return a;
	}
}
