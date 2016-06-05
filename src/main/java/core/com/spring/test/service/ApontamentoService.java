package core.com.spring.test.service;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.exception.BusinessException;

public interface ApontamentoService {
	public Apontamento obterApontamento(Long idJob) throws BusinessException;

	public void parar(Apontamento a) throws BusinessException;
}
