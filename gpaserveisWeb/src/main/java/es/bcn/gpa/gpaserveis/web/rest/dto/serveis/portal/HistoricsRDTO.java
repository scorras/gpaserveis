package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Historic")
@JsonPropertyOrder({
    "estat",
    "dataCreacio",
    "descripcio"
})
public class HistoricsRDTO {
	
	@ApiModelProperty(value="Estat de l'històric")
    private String estat;
	@ApiModelProperty(value="Data de creació de l'històric")
    private String dataCreacio;
	@ApiModelProperty(value="Descipció de l'històric")
    private String descripcio;
    
    
	public String getDataCreacio() {
		return dataCreacio;
	}
	public void setDataCreacio(String dataCreacio) {
		this.dataCreacio = dataCreacio;
	}
	public String getEstat() {
		return estat;
	}
	public void setEstat(String estat) {
		this.estat = estat;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
    
}
