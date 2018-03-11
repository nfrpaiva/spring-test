package core.com.spring.test;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.com.spring.PersistenceJPAConfig;
import core.com.spring.test.config.AbstractSpringTest;
import core.com.spring.test.dominio.Job;
import core.com.spring.test.service.JobService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(classes = { PersistenceJPAConfig.class }) })
@Transactional
public class JobServiceTest extends AbstractSpringTest {

	@Inject
	private JobService jobService;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testSalvarJob() throws Exception {
		Job job = new Job();
		job.setDescricao("ApontamentoTest Job");
		jobService.salvar(job);
		assertEquals(job, em.find(Job.class, job.getId()));
	}

	@SuppressWarnings("unused")
	private Job criarNovoJobNoBancoDeDados() {
		Job job = new Job();
		job.setDescricao("ApontamentoTest Job");
		em.persist(job);
		return job;
	}
}
