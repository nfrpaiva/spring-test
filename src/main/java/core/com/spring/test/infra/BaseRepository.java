package core.com.spring.test.infra;

import core.com.spring.test.exception.RepositoryException;

public interface BaseRepository {

	<T> T find(Class<T> type, Object id);

	public <T> void salvar(T entity) throws RepositoryException;

	public <T> void alterar(T entity) throws RepositoryException;

}
