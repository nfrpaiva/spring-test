package core.com.spring.test.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;
import core.com.spring.test.exception.ExceptionMessages;
import core.com.spring.test.exception.ServiceException;

@Named
public class ApontamentoServiceImpl implements ApontamentoService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Apontamento obterApontamentoEmExecucao(Long idJob) throws ServiceException{
		Apontamento result = null;
		List<Apontamento> apontamentos =  findApontamentosEmAberto(idJob);
		if (apontamentos.size() ==0){
			Apontamento a = new Apontamento();
			a.setJob(new Job(idJob));
			em.persist(a);
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
		em.merge(a);

	}
	
	private List<Apontamento> findApontamentosEmAberto(Long idJob){
		TypedQuery<Apontamento> query = em.createNamedQuery("find.allAllOpenByJob", Apontamento.class);
		query.setParameter("idJob", idJob);
		return  query.getResultList();
	}

}
