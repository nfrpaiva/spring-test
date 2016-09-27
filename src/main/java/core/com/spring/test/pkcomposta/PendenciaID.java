package core.com.spring.test.pkcomposta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Embeddable
public class PendenciaID implements Serializable {

	private static final long serialVersionUID = 6164907355314992352L;
	@Column(name = "itemID")
	private Long itemID;
	private String tipoPendencia;

	public PendenciaID(Long itemID,String tipoPendencia) {
		this.itemID = itemID;
		this.tipoPendencia = tipoPendencia;
	}

	public PendenciaID() {
		super();
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getTipoPendencia() {
		return tipoPendencia;
	}

	public void setTipoPendencia(String tipoPendencia) {
		this.tipoPendencia = tipoPendencia;
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
