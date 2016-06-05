package core.com.spring.test.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Job(Long idJob) {
		this.id = idJob;
	}
	public Job(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Apontamento> getApontamentos() {
		return apontamentos;
	}
	public void setApontamentos(Set<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}
	private String descricao;
	@OneToMany(mappedBy = "job")
	private Set<Apontamento> apontamentos = new HashSet<>();
}
