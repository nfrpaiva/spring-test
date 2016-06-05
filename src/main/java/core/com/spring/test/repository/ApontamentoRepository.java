package core.com.spring.test.repository;

import java.util.List;

import core.com.spring.test.dominio.Apontamento;
import core.com.spring.test.exception.RepositoryException;

public interface ApontamentoRepository {

	List<Apontamento> findApontamentosEmAberto(Long idJob) throws RepositoryException;
	boolean existeApontamentoComOMesmoRange (Apontamento apontamento) throws RepositoryException;

}