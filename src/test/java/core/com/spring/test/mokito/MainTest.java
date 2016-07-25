package core.com.spring.test.mokito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

	@Mock
	private Repository mockRepository;

	@Mock
	private EntityManager mockEntityManager;

	@InjectMocks
	private TestService service = new TestServiceImpl();

	@InjectMocks
	private Repository repository = new RepositoryImpl();

	@Test
	public void primeiro() throws Exception {
		TestEntity entity = new TestEntity(1l,"Nilton Fernando");
		service.doSomeThing(entity);
		verify(mockRepository).save(any(TestEntity.class));
		verifyNoMoreInteractions(mockRepository);
	}

	@Test
	public void segundo() throws Exception {
		reset(mockRepository);
		TestEntity entity = new TestEntity(1l,"Nilton Fernando");
		doThrow(new NullPointerException("churros exception")).when(mockRepository).save(entity);
		try {
			service.doSomeThing(entity);
			fail("Deveria ter lançado uma exceção");
		} catch (NullPointerException e) {
			assertEquals("churros exception",e.getMessage());
		}
	}

	@Test
	public void terceiro() throws Exception {
		TestEntity entity = new TestEntity(2l,"Jonh Doe");
		repository.save(entity);
		verify(mockEntityManager).persist(entity);
		verifyNoMoreInteractions(mockEntityManager);
	}
}
