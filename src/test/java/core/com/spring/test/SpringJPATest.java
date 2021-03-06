package core.com.spring.test;

import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import core.com.spring.PersistenceJPAConfig;
import core.com.spring.test.config.AbstractSpringTest;
import core.com.spring.test.dominio.Pessoa;
import core.com.spring.test.infra.Base;
import core.com.spring.test.infra.BaseRepository;
import core.com.spring.test.service.PessoaService;

/**
 *
 * @author Nilton Fernando
 */
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class SpringJPATest extends AbstractSpringTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	@Base
	private BaseRepository repository;

	@Test
	public void testSpringJPAConfiguration() {
		Assert.assertNotNull(this.em);
	}

	@Test
	public void testIfPersistenceContextInjectionWorks() throws Exception {
		Assert.assertNotNull(this.repository);
		Field f = this.repository.getClass().getSuperclass().getDeclaredField("em");
		f.setAccessible(true);
		Object em = f.get(this.repository);
		Assert.assertNotNull("Entity Manager não pode ser nulo", em);
	}

	@Test
	@Transactional
	public void testInsert() throws Exception {
		Pessoa p = new Pessoa();
		p.setNome("Nilton Fernando".toUpperCase());
		pessoaService.inserir(p);
		Assert.assertNotNull(p.getId());
	}

	@Inject
	private Validator validador;

	@Test
	public void testValidator() {
		Assert.assertNotNull(this.validador);
	}

}
