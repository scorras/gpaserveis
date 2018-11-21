package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Grups")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descripcio",
    "columnes",
    "ordre",
    "urlValidacio",
    "urlAjuda",
    "atributs"
})
public class DadesGrupsRDTO {
	
	@ApiModelProperty(value="Descripció del grup d'atributs")
    private String descripcio;
	@ApiModelProperty(value="Columnes del grup d'atributs")
    private String columnes;
	@ApiModelProperty(value="Ordre del grup d'atributs")
    private String ordre;
	@ApiModelProperty(value="URL de validació a nivell de grup d'atributs")
    private String urlValidacio;
    @ApiModelProperty(value="URL d'ajuda a nivell de grup d'atributs")
    private String urlAjuda;
    @ApiModelProperty(value="Atributs del grup")
    private List<DadesAtributsRDTO> atributs = Collections.emptyList();
    
    
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public String getColumnes() {
		return columnes;
	}
	public void setColumnes(String columnes) {
		this.columnes = columnes;
	}
	public String getOrdre() {
		return ordre;
	}
	public void setOrdre(String ordre) {
		this.ordre = ordre;
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
	public List<DadesAtributsRDTO> getAtributs() {
		return atributs;
	}
	public void setAtributs(List<DadesAtributsRDTO> atributs) {
		this.atributs = atributs;
	}
    
}
