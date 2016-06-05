package core.com.spring.test.service;

import javax.inject.Inject;
import javax.inject.Named;

import core.com.spring.test.dominio.Pessoa;
import core.com.spring.test.infra.BaseRepository;
import core.com.spring.test.repository.CommonRepository;

@Named

public class PessoaServiceImpl implements PessoaService {

	@Inject
	@CommonRepository
	BaseRepository repository;
	

    @Override
    public void inserir(Pessoa p) {
        repository.persist(p);
    }

}
