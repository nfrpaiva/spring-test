package core.com.spring.test.joinsempk;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"numcontrato"},name = "UK_CHURROS")})
public class LoteDetalhe implements Serializable {

	private static final long serialVersionUID = 2338389429418654599L;

	@Id
	@Column(name = "id_detalhe")
	private Long id;

	public LoteDetalhe() {
		super();
	}

	@Column(name = "numcontrato")
	private Long numContrato;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "NUMCONTRATO",referencedColumnName = "NUMCONTRATO",insertable = false,updatable = false)
	private List<Contrato> contratos;

	public LoteDetalhe(long l) {
		id = l;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Long getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
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
		LoteDetalhe other = (LoteDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
