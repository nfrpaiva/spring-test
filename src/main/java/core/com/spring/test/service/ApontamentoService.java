package core.com.spring.test.service;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.exception.ServiceException;

public interface ApontamentoService {
	public Apontamento obterApontamentoEmExecucao(Long idJob) throws ServiceException;

	public void parar(Apontamento a);
}
