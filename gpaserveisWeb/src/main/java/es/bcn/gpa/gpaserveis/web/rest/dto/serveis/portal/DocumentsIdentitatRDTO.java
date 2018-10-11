package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="DocumentIdentitat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tipusDocument",
    "numeroDocument",
    "pais"
})
public class DocumentsIdentitatRDTO {
    
	@ApiModelProperty(value="Tipus de document d'identitat de la persona",
			allowableValues = "NIF, NIE, CIF, PASSAPORT, DOCUMENT_IDENTITAT_ESTRANGER, DOCUMENT_EMPRESA_ESTRANGERA")
    private String tipusDocument;
	@ApiModelProperty(value="Número de document d'identitat de la persona")
    private String numeroDocument;
	@ApiModelProperty(value="Codi ISO del país del document d'identitat de la persona")
    private String pais;
	public String getTipusDocument() {
		return tipusDocument;
	}
	public void setTipusDocument(String tipusDocument) {
		this.tipusDocument = tipusDocument;
	}
	public String getNumeroDocument() {
		return numeroDocument;
	}
	public void setNumeroDocument(String numeroDocument) {
		this.numeroDocument = numeroDocument;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
    
}