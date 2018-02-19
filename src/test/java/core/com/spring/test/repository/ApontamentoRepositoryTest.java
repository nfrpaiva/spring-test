package core.com.spring.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import core.com.spring.PersistenceJPAConfig;
import core.com.spring.test.config.AbstractSpringTest;
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
	public void testFindApontamentosEmAberto()throws Exception {
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

	@Test
	public void testExisteApontamentoComOMesmoRange()  throws Exception{
		Job job = new Job();
		job.setDescricao("Um nome qualquer");
		em.persist(job);
		Apontamento a = new Apontamento(job);
		a.setInicio(DateTime.parse("2016-06-06T00:00-03:00").toDate());
		a.setFim(DateTime.parse("2016-07-06T00:00-03:00").toDate());
		em.persist(a);
		Apontamento b = new Apontamento(job);
		b.setInicio(DateTime.parse("2016-06-06T00:00-03:00").toDate());
		b.setFim(DateTime.parse("2016-07-06T00:00-03:00").toDate());
		em.persist(b);
		assertTrue(repository.existeApontamentoComOMesmoRange(b));

		Apontamento c = new Apontamento();
		c.setId(b.getId() + 99);
		c.setJob(job);
		c.setInicio(DateTime.parse("2016-07-06T00:01-03:00").toDate());
		c.setFim(DateTime.parse("2016-08-07T00:00-03:00").toDate());
		assertFalse(repository.existeApontamentoComOMesmoRange(c));

	}

}
