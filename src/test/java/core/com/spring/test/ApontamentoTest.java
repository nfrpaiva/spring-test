package core.com.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.com.spring.test.config.AbstractSpringTest;
import core.com.spring.test.config.PersistenceJPAConfig;
import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;
import core.com.spring.test.service.ApontamentoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(classes = { PersistenceJPAConfig.class }) })
public class ApontamentoTest extends AbstractSpringTest {

	@Inject
	private ApontamentoService service;

	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	public void testIniciarApontamento() {
		Job job = criarNovoJobNoBancoDeDados();
		Apontamento a = service.criar(job.getId());
		assertNotNull(a);
		assertNotNull(a.getId());
		assertNotNull(a.getInicio());
		assertNull(a.getFim());
	}

	@Test
	@Transactional
	public void testFinalizarApontamento() {
		Job job = criarNovoJobNoBancoDeDados();
		Apontamento a = service.criar(job.getId());
		service.criar(job.getId());
		service.parar(a);
		Apontamento b = em.find(Apontamento.class, a.getId());
		assertNotNull(b.getFim());
	}

	private Job criarNovoJobNoBancoDeDados() {
		Job job = new Job();
		em.persist(job);
		return job;
	}
}
