package core.com.spring.test.pkcomposta;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.Sets;

@Entity
public class Pendencia implements Serializable {

	private static final long serialVersionUID = 160331801175505689L;

	@EmbeddedId
	private PendenciaID id = new PendenciaID();
	@MapsId("itemID")
	@ManyToOne
	@JoinColumn(name = "itemID")
	private Item item;

	@Column(insertable = false,updatable = false)
	private String tipoPendencia;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "pendencia")
	private Set<Documento> documentos = Sets.newHashSet();

	public Pendencia(Item item,String tipoPendencia) {
		this();
		this.item = item;
		this.tipoPendencia = tipoPendencia;
		this.id.setTipoPendencia(tipoPendencia);
	}

	public Pendencia() {
		super();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).build();
	}

	@Override
	public boolean equals(Object obj) {
		return new EqualsBuilder().append(this.id, ((Pendencia) obj).id).build();
	}

	public PendenciaID getId() {
		return id;
	}

	public void setId(PendenciaID id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getTipoPendencia() {
		return tipoPendencia;
	}

	public void setTipoPendencia(String tipoPendencia) {
		this.tipoPendencia = tipoPendencia;
	}

	public Documento novoDocumento(String tipoDocumento) {
		Documento documento = new Documento(this,tipoDocumento);
		this.documentos.add(documento);
		return documento;
	}

	public Set<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}

}
