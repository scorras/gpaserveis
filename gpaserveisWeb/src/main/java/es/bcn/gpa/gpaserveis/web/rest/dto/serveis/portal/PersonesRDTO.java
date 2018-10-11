package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Persona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "tipusPersona",
    "nomRaoSocial",
    "cognom1",
    "cognom2",
    "documentIndentitat"
})
public class PersonesRDTO {
	
	@ApiModelProperty(value="Identificador de la persona")
    private BigDecimal id;
	@ApiModelProperty(value="Tipus de persona",
			allowableValues = "FISICA, JURIDICA")
	private BigDecimal tipusPersona;
    @ApiModelProperty(value="Nom o raó social de la persona")
    private String nomRaoSocial;
    @ApiModelProperty(value="Cognom 1 de la persona")
    private String cognom1;
    @ApiModelProperty(value="Cognom 2 de la persona")
    private String cognom2;
    private DocumentsIdentitatRDTO documentIndentitat;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getTipusPersona() {
		return tipusPersona;
	}
	public void setTipusPersona(BigDecimal tipusPersona) {
		this.tipusPersona = tipusPersona;
	}
	public String getNomRaoSocial() {
		return nomRaoSocial;
	}
	public void setNomRaoSocial(String nomRaoSocial) {
		this.nomRaoSocial = nomRaoSocial;
	}
	public String getCognom1() {
		return cognom1;
	}
	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}
	public String getCognom2() {
		return cognom2;
	}
	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}
	public DocumentsIdentitatRDTO getDocumentIndentitat() {
		return documentIndentitat;
	}
	public void setDocumentIndentitat(DocumentsIdentitatRDTO documentIndentitat) {
		this.documentIndentitat = documentIndentitat;
	}

}
