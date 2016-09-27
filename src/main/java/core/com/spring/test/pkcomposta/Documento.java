package core.com.spring.test.pkcomposta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Documento implements Serializable {

	private static final long serialVersionUID = -1556199603661252660L;
	@EmbeddedId
	private DocumentoID documentoID = new DocumentoID();
	@MapsId("pendenciaID")
	@ManyToOne
	@JoinColumns(value = {@JoinColumn(name = "itemID",insertable = false,updatable = false),@JoinColumn(name = "tipoPendencia",insertable = false,updatable = false)})
	private Pendencia pendencia;
	@Column(insertable = false,updatable = false)
	private String tipoDocumento;

	private String textoDocumento;

	public Documento(Pendencia pendencia,String tipoDocumento) {
		this();
		this.pendencia = pendencia;
		this.tipoDocumento = tipoDocumento;
		this.documentoID.setTipoDocumento(tipoDocumento);
	}

	public Documento() {
		super();
	}

	public DocumentoID getDocumentoID() {
		return documentoID;
	}

	public void setDocumentoID(DocumentoID documentoID) {
		this.documentoID = documentoID;
	}

	public Pendencia getPendencia() {
		return pendencia;
	}

	public void setPendencia(Pendencia pendencia) {
		this.pendencia = pendencia;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTextoDocumento() {
		return textoDocumento;
	}

	public void setTextoDocumento(String textoDocumento) {
		this.textoDocumento = textoDocumento;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(documentoID).build();
	}

	@Override
	public boolean equals(Object obj) {
		return new EqualsBuilder().append(this.documentoID, ((Documento) obj).documentoID).build();
	}

}
