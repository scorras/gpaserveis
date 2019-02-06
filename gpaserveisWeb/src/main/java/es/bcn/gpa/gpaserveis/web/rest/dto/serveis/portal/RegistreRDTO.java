package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Registre")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "numRegistre", "dataRegistre", "persona" })
@Getter
@Setter
public class RegistreRDTO {

	@ApiModelProperty(value = "Número del registre")
	private String numRegistre;
	@ApiModelProperty(value = "Data del registre")
	private String dataRegistre;
	@ApiModelProperty(value = "Persona que ha efectuat el registre")
	private PersonesRDTO persona;

}
