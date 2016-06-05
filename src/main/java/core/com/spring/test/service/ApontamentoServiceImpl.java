package core.com.spring.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;
import core.com.spring.test.exception.BusinessException;
import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.RepositoryException;
import core.com.spring.test.exception.ServiceException;
import core.com.spring.test.infra.BaseRepository;
import core.com.spring.test.repository.ApontamentoRepositoryImpl;

@Named
public class ApontamentoServiceImpl implements ApontamentoService {

	@Inject
	private ApontamentoRepositoryImpl repository;
	
	@Inject
	private BaseRepository baseRepository;

	@Override
	public Apontamento obterApontamento(Long idJob) throws BusinessException {
		Apontamento result = null;
		List<Apontamento> apontamentos =  new ArrayList<>();
		apontamentos = repository.findApontamentosEmAberto(idJob);
		if (apontamentos.size() == 0) {
			Apontamento a = new Apontamento();
			a.setJob(new Job(idJob));
			try {
				baseRepository.salvar(a);
			} catch (RepositoryException e) {
				throw new ServiceException(ExceptionMessages.ERRO_AO_OBTER_APONTAMENTO, e);
			}
			result = a;
		} else if (apontamentos.size() == 1) {
			return apontamentos.get(0);
		} else {
			throw new ServiceException(ExceptionMessages.ERRO_GENERICO);
		}
		return result;
	}

	@Override
	public void parar(Apontamento a) throws BusinessException {
		a.setFim(DateTime.now().toDate());
		Apontamento entity =  baseRepository.find(Apontamento.class, a.getId());
		if (repository.existeApontamentoComOMesmoRange(entity)) {
			throw new ServiceException(ExceptionMessages.ERRO_EXISTE_APONTAMENTO_COM_MESMO_RANGE);
		}
		try {
			baseRepository.alterar(a);
		} catch (RepositoryException e) {
			throw new ServiceException(ExceptionMessages.ERRO_AO_PARAR_APONTAMENTO, e);
		}

	}

}
