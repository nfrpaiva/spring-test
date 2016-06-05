package core.com.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

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
import core.com.spring.test.exception.ServiceException;
import core.com.spring.test.service.ApontamentoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(classes = { PersistenceJPAConfig.class }) })
@Transactional
public class ApontamentoTest extends AbstractSpringTest {

	@Inject
	private ApontamentoService apontamentoService;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testIniciarApontamento() throws Exception {
		Job job = criarNovoJobNoBancoDeDados();
		Apontamento a = apontamentoService.obterApontamentoEmExecucao(job.getId());
		assertNotNull(a);
		assertNotNull(a.getId());
		assertNotNull(a.getInicio());
		assertNull(a.getFim());
	}

	@Test
	public void testFinalizarApontamento() throws Exception {
		Job job = criarNovoJobNoBancoDeDados();
		Apontamento a = apontamentoService.obterApontamentoEmExecucao(job.getId());
		apontamentoService.obterApontamentoEmExecucao(job.getId());
		apontamentoService.parar(a);
		Apontamento b = em.find(Apontamento.class, a.getId());
		assertNotNull(b.getFim());
	}

	@Test
	public void testExisteApontamentoEmAberto() throws Exception {
		Job job = criarNovoJobNoBancoDeDados();
		Apontamento a = apontamentoService.obterApontamentoEmExecucao(job.getId());
		assertEquals("Se já existe um apontamento em aberto ao tentar criar outro deve devolver o mesmo", a,
				apontamentoService.obterApontamentoEmExecucao(job.getId()));

	}
	@Test
	public void testExisteMaisDeUmApontamentosEmAberto()throws Exception{
		Job job = criarNovoJobNoBancoDeDados();
		criarNovoApontamentoNoBanco(job);
		criarNovoApontamentoNoBanco(job);
		try{
			apontamentoService.obterApontamentoEmExecucao(job.getId());
			fail("Mais de um apontamento em aberto deve lançar exceção");
		}catch (Exception e) {
			if (e instanceof ServiceException == false){
				fail("Deve lançar exceção de serviço");
			}
		}
		
	}

	private Job criarNovoJobNoBancoDeDados() {
		Job job = new Job();
		em.persist(job);
		return job;
	}
	private Apontamento criarNovoApontamentoNoBanco(Job job){
		Apontamento a = new Apontamento();
		a.setJob(job);
		em.persist(a);
		return a;
	}
}

