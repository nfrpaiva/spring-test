package core.com.spring.test;

import static core.com.spring.test.Factory.ApontamentoFactory.novoComId;
import static org.easymock.EasyMock.anyLong;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.equalTo;
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

import com.google.common.collect.Lists;

import core.com.spring.test.Factory.ApontamentoFactory;
import core.com.spring.test.dominio.Apontamento;
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
		Apontamento apontamento = ApontamentoFactory.novoComId(now);
		List<Apontamento> apontamentos = Lists.newArrayList(apontamento);
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
		List<Apontamento> apontamentos = Lists.newArrayList(novoComId(), novoComId());
		expect(mockRepository.findApontamentosEmAberto(anyLong())).andReturn(apontamentos);
		replay(mocks);
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
		Date end = new Date();
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
	public void pararApontamentoEFalharPorJaExistirUmApontamentoComMesmoRange() throws Exception {
		Apontamento a = ApontamentoFactory.novoComId();
		expect(mockBaseRepository.find(Apontamento.class, a.getId())).andReturn(a);
		expect(mockRepository.existeApontamentoComOMesmoRange(EasyMock.anyObject(Apontamento.class))).andReturn(true);
		replay(mocks);
		Apontamento b = ApontamentoFactory.novoComId();
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
