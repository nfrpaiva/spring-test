package core.com.spring.test.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.exception.RepositoryException;
import core.com.spring.test.infra.AbstractRepository;

@Named
public class ApontamentoRepositoryImpl extends AbstractRepository implements ApontamentoRepository {

	@Override
	public List<Apontamento> findApontamentosEmAberto(Long idJob) throws RepositoryException {
		TypedQuery<Apontamento> query = em.createNamedQuery("find.allAllOpenByJob", Apontamento.class);
		query.setParameter("idJob", idJob);
		return query.getResultList();
	}

	@Override
	public boolean existeApontamentoComOMesmoRange(Apontamento apontamento) throws RepositoryException {
		TypedQuery<Long> query = em.createNamedQuery("count.byPeriod", Long.class);
		query.setParameter("idJob", apontamento.getJob().getId());
		query.setParameter("inicio", apontamento.getInicio());
		query.setParameter("apontamento", apontamento);
		return query.getSingleResult() != 0;
	}

}
