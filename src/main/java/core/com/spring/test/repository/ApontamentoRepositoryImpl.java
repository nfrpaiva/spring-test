package core.com.spring.test.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.infra.AbstractRepository;

@Named
public class ApontamentoRepositoryImpl extends AbstractRepository implements ApontamentoRepository {

	
	
	@Override
	public List<Apontamento> findApontamentosEmAberto(Long idJob) {
		TypedQuery<Apontamento> query = em.createNamedQuery("find.allAllOpenByJob", Apontamento.class);
		query.setParameter("idJob", idJob);
		return query.getResultList();
	}

}
