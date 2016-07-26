package core.com.spring.test.mokito;

public class TestServiceImpl implements TestService {

	private Repository repository;

	@Override
	public void doSomeThing(TestEntity entity) {
		System.out.println("doing Some Thing on TestServiceImp.doSomeThing(...)");
		repository.save(entity);
		repository.find(entity.getId());
	}
}
