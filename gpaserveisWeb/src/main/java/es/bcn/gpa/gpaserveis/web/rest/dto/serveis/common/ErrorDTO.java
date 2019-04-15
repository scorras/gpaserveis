package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Error")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "descripcio" })
@Getter
@Setter
public class ErrorDTO {

	@ApiModelProperty(value = "Codi de l'error")
	private String codi;
	@ApiModelProperty(value = "Descripció de l'error")
	private String descripcio;

}
