package core.com.spring.test.cascade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import core.com.spring.test.config.AbstractSpringTest;
import core.com.spring.test.config.PersistenceJPAConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class})
@Transactional
public class CascadeTest extends AbstractSpringTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testCascade() {
		Cadu cadu = new Cadu();
		em.persist(cadu);
		em.flush();
		em.clear();

		Cadu cadu2 = em.find(Cadu.class,cadu.getId());
		System.out.println(cadu);
		em.remove(cadu2);
		em.flush();
	}
}
