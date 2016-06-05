package core.com.spring.test.service;

import core.com.spring.test.dominio.Pessoa;
import core.com.spring.test.exception.ServiceException;

/**
 * @author Nilton Fernando
 */
public interface PessoaService {

	public void inserir(Pessoa p) throws ServiceException;
}
