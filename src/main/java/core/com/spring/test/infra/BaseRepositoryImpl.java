package core.com.spring.test.infra;

import javax.inject.Named;

import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.RepositoryException;

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
	public <T> void salvar(T entity) throws RepositoryException {
		em.persist(entity);
	}

	@Override
	public <T> void alterar(T entity) throws RepositoryException {
		validarEstadoDeEntidadeExistente(entity);
		em.merge(entity);
	}

	private <T> void validarEstadoDeEntidadeExistente(T entity) throws RepositoryException {
		if (entity == null) {
			throw new RepositoryException(ExceptionMessages.ERRO_ENTIDADE_NAO_PODE_SER_NULA);
		}
		Object classId = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
		if (classId == null) {
			throw new RepositoryException(ExceptionMessages.ERRO_ID_ENTIDADE_NAO_PODE_SER_NULO);
		}
	}

}
