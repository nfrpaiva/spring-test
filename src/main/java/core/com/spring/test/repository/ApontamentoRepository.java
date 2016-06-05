package core.com.spring.test.repository;

import java.util.List;

import core.com.spring.test.dominio.Apontamento;

public interface ApontamentoRepository {

	List<Apontamento> findApontamentosEmAberto(Long idJob);

}