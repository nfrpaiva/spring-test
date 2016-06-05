package core.com.spring.test.infra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository {
	@PersistenceContext
	protected EntityManager em;
}
