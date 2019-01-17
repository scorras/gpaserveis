package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "UnitatGestora")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nom", "descripcio" })
@Getter
@Setter
public class UnitatGestoraRDTO {

	@ApiModelProperty(value = "Nom de la Unitat Gestora")
	private String nom;
	@ApiModelProperty(value = "Descripció de la Unitat Gestora")
	private String descripcio;

}
