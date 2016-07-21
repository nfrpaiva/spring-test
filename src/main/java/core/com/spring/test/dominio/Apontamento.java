package core.com.spring.test.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.DateTime;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "find.allAllOpenByJob", query = "select a from Apontamento a where a.fim = null and a.job.id = :idJob"),
		@NamedQuery(name = "count.byPeriod", query = "select count(1) from Apontamento a where a.fim >= :inicio and a.job.id = :idJob and a != :apontamento")

})
public class Apontamento implements Serializable, Validable {

	private static final long serialVersionUID = 2819171568609241636L;

	public Apontamento() {
	}

	public Apontamento(Job job) {
		this.job = job;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fim;

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Column(length = 40)
	String descricao;

	@ManyToOne
	@JoinColumn(name = "idJob", foreignKey = @ForeignKey(name = "APONTAMENTO_JOB_FK"))
	private Job job;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Apontamento other = (Apontamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public boolean validate(ConstraintValidatorContext cvc) {
		if (this.inicio == null || this.fim == null) {
			return true;
		}
		if (new DateTime(this.inicio).isAfter(new DateTime(this.fim))) {
			cvc.buildConstraintViolationWithTemplate("{core.com.spring.test.constraint.apontamento.inicio.maior.fim}")
					// .addPropertyNode("fim")
					.addConstraintViolation();
			return false;
		}
		return true;
	}

}
