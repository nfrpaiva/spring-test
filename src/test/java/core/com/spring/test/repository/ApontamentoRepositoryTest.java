package core.com.spring.test.repository;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import core.com.spring.test.config.AbstractSpringTest;
import core.com.spring.test.config.PersistenceJPAConfig;
import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class })
@Transactional
public class ApontamentoRepositoryTest extends AbstractSpringTest {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private ApontamentoRepository repository;

	@Test
	public void testFindApontamentosEmAberto() {
		Job job = new Job();
		job.setDescricao("Um nome qualquer");
		em.persist(job);
		assertEquals(0, repository.findApontamentosEmAberto(job.getId()).size());
		em.persist(new Apontamento(job));
		assertEquals(1, repository.findApontamentosEmAberto(job.getId()).size());
		em.persist(new Apontamento(job));
		em.persist(new Apontamento(job));
		assertEquals(3, repository.findApontamentosEmAberto(job.getId()).size());
	}

}
