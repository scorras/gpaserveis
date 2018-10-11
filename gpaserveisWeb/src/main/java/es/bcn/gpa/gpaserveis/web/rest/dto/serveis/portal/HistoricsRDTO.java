package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Historic")
@JsonPropertyOrder({
    "dataCreacio",
    "tipus",
    "descripcio"
})
public class HistoricsRDTO {
	
    private String dataCreacio;
    private String estat;
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
