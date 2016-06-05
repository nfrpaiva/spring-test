package core.com.spring.test.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;
import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.ServiceException;
import core.com.spring.test.repository.ApontamentoRepository;

@Named
public class ApontamentoServiceImpl implements ApontamentoService {

	@Inject
	private ApontamentoRepository repository;

	@Override
	public Apontamento obterApontamento(Long idJob) throws ServiceException{
		Apontamento result = null;
		List<Apontamento> apontamentos =  repository.findApontamentosEmAberto(idJob);
		if (apontamentos.size() ==0){
			Apontamento a = new Apontamento();
			a.setJob(new Job(idJob));
			repository.persist(a);
			result = a;
		}else if(apontamentos.size()==1) {
			return apontamentos.get(0);
		}else {
			throw new ServiceException(ExceptionMessages.ERRO_GENERICO);
		}
		return result;
	}

	@Override
	public void parar(Apontamento a) {
		a.setFim(DateTime.now().toDate());
		repository.merge(a);

	}
	


}
