package core.com.spring.test;

import static org.easymock.EasyMock.anyLong;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.equalTo;
import static org.joda.time.Days.ONE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;
import core.com.spring.test.exception.ServiceException;
import core.com.spring.test.infra.BaseRepository;
import core.com.spring.test.repository.ApontamentoRepository;
import core.com.spring.test.service.ApontamentoService;
import core.com.spring.test.service.ApontamentoServiceImpl;
import core.com.spring.test.service.TimeManager;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextHierarchy({ @ContextConfiguration(classes = { PersistenceJPAConfig.class }) })
//@Transactional
@RunWith(EasyMockRunner.class)
public class ApontamentoServiceTest {

	private static final Long ANY_APONTAMENTO_ID = -99l;
	private static final Long ANY_JOB_ID = -99L;

	@TestSubject
	private ApontamentoService apontamentoService = new ApontamentoServiceImpl();

	@Mock
	private ApontamentoRepository mockRepository;

	@Mock
	private BaseRepository mockBaseRepository;

	@Mock
	private TimeManager timeManager;

	private Object[] mocks;

	@Before
	public void setUp() {
		mocks = new Object[] { timeManager, mockRepository, mockBaseRepository };
	}

	@After
	public void tearDown() {
		reset(mocks);
	}

	@Test
	public void obterNovoApontamentoEObterSucesso() throws Exception {
		Date now = DateTime.now().toDate();
		List<Apontamento> apontamentos = new ArrayList<>();
		expect(timeManager.now()).andReturn(now);
		expect(mockRepository.findApontamentosEmAberto(anyLong())).andReturn(apontamentos);
		mockBaseRepository.salvar(EasyMock.anyObject(Apontamento.class));
		expectLastCall();
		replay(mocks);
		Apontamento a = apontamentoService.obterApontamento(ANY_JOB_ID);
		verify(mocks);
		assertThat(a, Matchers.not(Matchers.nullValue()));
		assertThat(a.getInicio(), Matchers.equalTo(now));
	}

	@Test
	public void obterApontamentoExistenteEObterSucesso() throws Exception {
		Date now = DateTime.now().minus(Days.ONE).toDate();
		Apontamento apontamento = new Apontamento();
		apontamento.setId(ANY_JOB_ID);
		apontamento.setInicio(now);
		List<Apontamento> apontamentos = new ArrayList<>();
		apontamentos.add(apontamento);
		expect(mockRepository.findApontamentosEmAberto(anyLong())).andReturn(apontamentos);
		expectLastCall();
		replay(mocks);
		Apontamento a = apontamentoService.obterApontamento(ANY_JOB_ID);
		verify(mocks);
		assertThat(a, Matchers.equalTo(apontamento));
		assertThat(a.getInicio(), Matchers.equalTo(now));
	}

	@Test
	public void obterNovoApontamentoEFalharPorExistirMaisDeUmEmAberto() throws Exception {
		Apontamento apontamento1 = new Apontamento();
		apontamento1.setId(ANY_JOB_ID);
		Apontamento apontamento2 = new Apontamento();
		apontamento2.setId(ANY_JOB_ID);
		List<Apontamento> apontamentos = new ArrayList<>();
		expect(mockRepository.findApontamentosEmAberto(anyLong())).andReturn(apontamentos);
		replay(mocks);
		apontamentos.add(apontamento1);
		apontamentos.add(apontamento2);
		try {
			apontamentoService.obterApontamento(ANY_JOB_ID);
			verify(mocks);
			fail("Mais de um apontamento em aberto deve lançar exceção");
		} catch (Exception e) {
			if (e instanceof ServiceException == false) {
				fail("Deve lançar exceção de serviço");
			}
		}
	}

	@Test
	public void pararApontamentoETerSucesso() throws Exception {
		Date end = DateTime.now().plus(ONE).withTimeAtStartOfDay().toDate();
		Apontamento a = new Apontamento();
		a.setId(ANY_APONTAMENTO_ID);
		expect(mockBaseRepository.find(Apontamento.class, ANY_APONTAMENTO_ID)).andReturn(a);
		expect(mockRepository.existeApontamentoComOMesmoRange(EasyMock.anyObject(Apontamento.class))).andReturn(false);
		expect(timeManager.now()).andReturn(end);
		mockBaseRepository.alterar(a);
		expectLastCall();
		replay(mocks);
		apontamentoService.parar(a);
		verify(mocks);
		assertThat(a.getFim(), equalTo(end));
	}

	@Test
	public void pararApontamentoEFalhar() throws Exception {
		Apontamento a = new Apontamento(new Job(ANY_JOB_ID));
		a.setId(ANY_JOB_ID);
		expect(mockBaseRepository.find(Apontamento.class, ANY_APONTAMENTO_ID)).andReturn(a);
		expect(mockRepository.existeApontamentoComOMesmoRange(EasyMock.anyObject(Apontamento.class))).andReturn(true);
		replay(mocks);
		Apontamento b = new Apontamento(new Job(ANY_JOB_ID));
		b.setId(ANY_JOB_ID);
		try {
			apontamentoService.parar(b);
			verify(mocks);
			fail("Range de inicio e fim deve ser unico por job");
		} catch (ServiceException e) {
			assertEquals("O período informado de início e fim já existe em outro apontamento", e.getMessage());
		}

	}

	@Test
	public void testInicioMaiorQueFim() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Apontamento a = new Apontamento();
		a.setInicio(DateTime.parse("2016-07-06T00:00-03:00").toDate());
		a.setFim(DateTime.parse("2016-06-06T00:00-03:00").toDate());
		Set<ConstraintViolation<Apontamento>> validate = validator.validate(a);
		assertThat("Início deve ser maior que o final", equalTo(validate.iterator().next().getMessage()));

	}

}
