package core.com.spring.test.infra;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import core.com.spring.test.repository.CommonRepository;

/**
 *
 * @author Nilton Fernando
 */
@Named
@CommonRepository
public class BaseRepositoryImpl implements BaseRepository {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public <T> T find(Class<T> type, Object id) {
		return em.find(type, id);
	}

	@Override
	public <T> void persist(T entity) {
		em.persist(entity);
	}
	@Override
	public <T> void merge(T entity) {
		em.merge(entity);
	}

}
