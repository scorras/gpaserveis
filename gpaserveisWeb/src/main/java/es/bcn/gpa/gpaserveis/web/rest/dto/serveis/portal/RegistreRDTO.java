package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Registre")
@JsonPropertyOrder({
	"codi",
    "dataRegistre",
    "persona"
})
public class RegistreRDTO {
	
	@ApiModelProperty(value="Codi del registre")
	private String codi;
	@ApiModelProperty(value="Data del registre")
    private String dataRegistre;
	@ApiModelProperty(value="Persona que ha efectuat el registre")
    private PersonesRDTO persona;

    
	public String getCodi() {
		return codi;
	}
	public void setCodi(String codi) {
		this.codi = codi;
	}
	public String getDataRegistre() {
		return dataRegistre;
	}
	public void setDataRegistre(String dataRegistre) {
		this.dataRegistre = dataRegistre;
	}
	public PersonesRDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonesRDTO persona) {
		this.persona = persona;
	}
}
