package core.com.spring.test.pkcomposta;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

@Entity

@NamedQuery(name = Item.findAllWithPendencias,query = "SELECT i FROM Item i JOIN FETCH i.pendencias")
public class Item implements Serializable {

	public static final String findAllWithPendencias = "findAllWithPendencias";
	private static final long serialVersionUID = -2766499771468344703L;
	private static final String SQ_ITEM_GENERATOR = "SQ_ITEM_GENERATOR";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SQ_ITEM_GENERATOR)
	@SequenceGenerator(sequenceName = "SQ_ITEM",name = SQ_ITEM_GENERATOR)
	@Column(name = "itemID",columnDefinition = "NUMBER(11)")
	private Long itemID;
	@Column(length = 100)
	private String descricao;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "item")
	private Set<Pendencia> pendencias = Sets.newHashSet();

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pendencia novaPendencia(String tipoPendencia) {
		Pendencia pendencia = new Pendencia(this,tipoPendencia);
		this.pendencias.add(pendencia);
		return pendencia;
	}

	public Set<Pendencia> getPendencias() {
		return pendencias;
	}

	public void setPendencias(Set<Pendencia> pendencias) {
		this.pendencias = pendencias;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
