package core.com.spring.test.service;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.dominio.Job;

@Named
public class ApontamentoServiceImpl implements ApontamentoService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Apontamento criar(Long idJob) {
		Apontamento a = new Apontamento();
		a.setJob(new Job(idJob));
		em.persist(a);
		return a;
	}

	@Override
	public void parar(Apontamento a) {
		a.setFim(DateTime.now().toDate());
		em.merge(a);

	}

}
