package core.com.spring.test.mokito;

public interface Repository {

	public void save(TestEntity entity);

	public TestEntity find(Long id);
}
