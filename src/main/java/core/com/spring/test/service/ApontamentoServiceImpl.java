package core.com.spring.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;
import core.com.spring.test.exception.BusinessException;
import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.RepositoryException;
import core.com.spring.test.exception.ServiceException;
import core.com.spring.test.repository.ApontamentoRepository;

@Named
public class ApontamentoServiceImpl implements ApontamentoService {

	@Inject
	private ApontamentoRepository repository;

	@Inject
	TimeManager timeManager;

	@Override
	public Apontamento obterApontamento(Long idJob) throws BusinessException {
		Apontamento result = null;
		List<Apontamento> apontamentos = new ArrayList<>();
		apontamentos = repository.findApontamentosEmAberto(idJob);
		if (apontamentos.size() == 0) {
			Apontamento a = new Apontamento();
			a.setInicio(timeManager.now());
			a.setJob(new Job(idJob));
			salvar(a);
			result = a;
		} else if (apontamentos.size() == 1) {
			return apontamentos.get(0);
		} else {
			throw new ServiceException(ExceptionMessages.ERRO_GENERICO);
		}
		return result;
	}

	private void salvar(Apontamento a) throws ServiceException {
		try {
			repository.salvar(a);
		} catch (RepositoryException e) {
			throw new ServiceException(ExceptionMessages.ERRO_AO_OBTER_APONTAMENTO, e);
		}
	}

	@Override
	public void parar(Apontamento a) throws BusinessException {
		Apontamento entity = repository.find(Apontamento.class, a.getId());
		if (repository.existeApontamentoComOMesmoRange(entity)) {
			throw new ServiceException(ExceptionMessages.ERRO_EXISTE_APONTAMENTO_COM_MESMO_RANGE);
		}
		try {
			a.setFim(timeManager.now());
			repository.alterar(a);
		} catch (RepositoryException e) {
			throw new ServiceException(ExceptionMessages.ERRO_AO_PARAR_APONTAMENTO, e);
		}

	}

}
