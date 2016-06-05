package core.com.spring.test.service;

import core.com.spring.test.dominio.Apontamento;

public interface ApontamentoService {
	public Apontamento criar(Long idJob);

	public void parar(Apontamento a);
}
