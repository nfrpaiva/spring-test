package core.com.spring.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import core.com.spring.test.config.AbstractSpringTest;
import core.com.spring.test.config.PersistenceJPAConfig;
import core.com.spring.test.dominio.heranca.Cachorro;
import core.com.spring.test.dominio.heranca.Cobra;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(classes = { PersistenceJPAConfig.class }) })
@Transactional
public class AnimalTest extends AbstractSpringTest {

	@PersistenceContext 
	private EntityManager em;
	@Test
	public void testHeranca(){
		Cachorro c = new Cachorro();
		c.setNome("Floquinho");
		c.setRaca("Sei la");
		em.persist(c);
		Cobra cobra = new Cobra();
		cobra.setNome("Jararaca");
		cobra.setVeneno("muito foda");
		em.persist(cobra);
		em.flush();
	}
}
