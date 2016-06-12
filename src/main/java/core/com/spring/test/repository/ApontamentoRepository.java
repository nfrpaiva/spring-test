package core.com.spring.test.repository;

import java.util.List;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.exception.RepositoryException;
import core.com.spring.test.infra.BaseRepository;

public interface ApontamentoRepository extends BaseRepository {

	List<Apontamento> findApontamentosEmAberto(Long idJob) throws RepositoryException;

	boolean existeApontamentoComOMesmoRange(Apontamento apontamento) throws RepositoryException;

}