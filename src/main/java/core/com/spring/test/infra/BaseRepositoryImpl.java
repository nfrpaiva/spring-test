package core.com.spring.test.infra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 *
 * @author Nilton Fernando
 */
@Component
public class BaseRepositoryImpl implements BaseRepository {

	@PersistenceContext
	private EntityManager em;
	
    @Override
	public <T> T find(Class<T> type, Object id) {
        return em.find(type, id);
    }

	@Override
	public <T> void persist(T entity) {
		em.persist(entity);
	}
    
}


