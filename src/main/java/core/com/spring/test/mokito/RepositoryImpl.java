package core.com.spring.test.mokito;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositoryImpl implements Repository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(TestEntity entity) {
		em.persist(entity);
	}

	@Override
	public TestEntity find(Long id) {
		return em.find(TestEntity.class,id);
	}

}
