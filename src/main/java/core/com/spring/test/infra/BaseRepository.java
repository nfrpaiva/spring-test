package core.com.spring.test.infra;

public interface BaseRepository {

	<T> T find(Class<T> type, Object id);

	public <T> void persist(T entity);

	public <T> void merge(T entity);

}
