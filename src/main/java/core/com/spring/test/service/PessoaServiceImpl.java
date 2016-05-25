package core.com.spring.test.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import core.com.spring.test.dominio.Pessoa;
import core.com.spring.test.infra.BaseRepository;

@Component
//@Transactional
public class PessoaServiceImpl implements PessoaService {

	@Inject
	BaseRepository repository;
	

    @Override
    public void inserir(Pessoa p) {
        repository.persist(p);
    }

}
