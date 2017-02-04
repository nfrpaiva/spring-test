package core.com.spring.test.joinsempk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Contrato implements Serializable {

	private static final long serialVersionUID = -6571851413520201778L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Column(name = "NUMCONTRATO")
	private Long numContrato;
	private Long subContrato;

	public Contrato() {
		super();
	}

	public Contrato(Long numContrato,Long subContrato) {
		this.numContrato = numContrato;
		this.subContrato = subContrato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}

	public Long getSubContrato() {
		return subContrato;
	}

	public void setSubContrato(Long subContrato) {
		this.subContrato = subContrato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( (id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contrato other = (Contrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
