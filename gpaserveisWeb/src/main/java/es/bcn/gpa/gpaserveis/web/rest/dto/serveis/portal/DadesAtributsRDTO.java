package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Atributs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codi",
    "descripcio",
    "ordre",
    "tipus",
    "validacions",
    "urlValidacio",
    "urlAjuda"
})
public class DadesAtributsRDTO {
	
    private String codi;
    private String descripcio;
    private String ordre;
    private String tipus;
    private String validacions;
    private String urlValidacio;
    private String urlAjuda;
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
	public String getOrdre() {
		return ordre;
	}
	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	public String getValidacions() {
		return validacions;
	}
	public void setValidacions(String validacions) {
		this.validacions = validacions;
	}
	public String getUrlValidacio() {
		return urlValidacio;
	}
	public void setUrlValidacio(String urlValidacio) {
		this.urlValidacio = urlValidacio;
	}
	public String getUrlAjuda() {
		return urlAjuda;
	}
	public void setUrlAjuda(String urlAjuda) {
		this.urlAjuda = urlAjuda;
	}
 
}
