package core.com.spring.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
