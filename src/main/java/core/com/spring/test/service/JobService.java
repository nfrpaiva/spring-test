package core.com.spring.test.service;

import core.com.spring.test.dominio.Job;
import core.com.spring.test.exception.BusinessException;

public interface JobService {

	void salvar(Job job) throws BusinessException;

}
