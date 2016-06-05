package core.com.spring.test.service;

import javax.inject.Inject;
import javax.inject.Named;

import core.com.spring.test.dominio.Job;
import core.com.spring.test.exception.BusinessException;
import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.RepositoryException;
import core.com.spring.test.exception.ServiceException;
import core.com.spring.test.infra.BaseRepository;

@Named
public class JobServiceImpl implements JobService {

	@Inject
	private BaseRepository baseRepository;
	
	@Override
	public void salvar(Job job) throws BusinessException {
		try {
			baseRepository.salvar(job);
		} catch (RepositoryException e) {
			throw new ServiceException(ExceptionMessages.ERRO_GENERICO, e);
		}
	}

}
