package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="DocumentConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "descripcio",
    "descripcioAmpliada",
    "obligatori",
    "repetible",
    "suportConfeccio",
    "suportEnllac"
})
public class DocumentsConsultaRDTO {
	
	@ApiModelProperty(value="Identificador del document")
	private BigDecimal id;
	@ApiModelProperty(value="Codi del document")
	private String codi;
	@ApiModelProperty(value="Descripció del document")
	private String descripcio;
	@ApiModelProperty(value="Descripció ampliada del document")
	private String descripcioAmpliada;
	@ApiModelProperty(value="Obligatori")
	private boolean obligatori;
	@ApiModelProperty(value="Repetible")
	private boolean repetible;
	@ApiModelProperty(value="Suport per a la confecció del document",
			allowableValues="SENSE_SUPORT, PLANTILLA, GUIA, FORMULARI")
	private String suportConfeccio;
	@ApiModelProperty(value="Enllaç document de suport per a la confecció del document")
	private String suportEnllac;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getCodi() {
		return codi;
	}
	public void setCodi(String codi) {
		this.codi = codi;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public String getDescripcioAmpliada() {
		return descripcioAmpliada;
	}
	public void setDescripcioAmpliada(String descripcioAmpliada) {
		this.descripcioAmpliada = descripcioAmpliada;
	}
	public boolean isObligatori() {
		return obligatori;
	}
	public void setObligatori(boolean obligatori) {
		this.obligatori = obligatori;
	}
	public boolean isRepetible() {
		return repetible;
	}
	public void setRepetible(boolean repetible) {
		this.repetible = repetible;
	}
	public String getSuportConfeccio() {
		return suportConfeccio;
	}
	public void setSuportConfeccio(String suportConfeccio) {
		this.suportConfeccio = suportConfeccio;
	}
	public String getSuportEnllac() {
		return suportEnllac;
	}
	public void setSuportEnllac(String suportEnllac) {
		this.suportEnllac = suportEnllac;
	}
	
}
