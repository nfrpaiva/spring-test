package core.com.spring.test.infra;

import javax.inject.Named;

/**
 *
 * @author Nilton Fernando
 */
@Named
public class BaseRepositoryImpl extends AbstractRepository implements BaseRepository {

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
