package core.com.spring.test.dominio;

import core.com.spring.test.validator.CaseMode;
import core.com.spring.test.validator.CheckCase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 2104219867453567628L;

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
        
	@CheckCase(CaseMode.UPPER)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

