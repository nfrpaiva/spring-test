package core.com.spring.test.service;

import core.com.spring.test.dominio.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
//@Transactional
public class PessoaServiceImpl implements PessoaService {

	@PersistenceContext
	private EntityManager em;

        @Override
	public EntityManager getEm() {
		return em;
	}

    @Override
    public void inserir(Pessoa p) {
        em.persist(p);
    }

	
}
