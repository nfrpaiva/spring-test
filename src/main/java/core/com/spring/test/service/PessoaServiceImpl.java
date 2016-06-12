package core.com.spring.test.service;

import javax.inject.Inject;
import javax.inject.Named;

import core.com.spring.test.dominio.Pessoa;
import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.RepositoryException;
import core.com.spring.test.exception.ServiceException;
import core.com.spring.test.infra.Base;
import core.com.spring.test.infra.BaseRepository;

@Named

public class PessoaServiceImpl implements PessoaService {

	@Inject
	@Base
	BaseRepository repository;

	@Override
	public void inserir(Pessoa p) throws ServiceException {
		try {
			repository.salvar(p);
		} catch (RepositoryException e) {
			throw new ServiceException(ExceptionMessages.ERRO_GENERICO, e);
		}
	}

}
