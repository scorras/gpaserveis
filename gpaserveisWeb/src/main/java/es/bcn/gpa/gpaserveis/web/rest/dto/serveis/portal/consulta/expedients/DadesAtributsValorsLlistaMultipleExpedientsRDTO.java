package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ValorsLlistaMultiple")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "index", "valor" })
@Getter
@Setter
public class DadesAtributsValorsLlistaMultipleExpedientsRDTO {

	@ApiModelProperty(value = "Codi del valor de la llista")
	private String index;
	@ApiModelProperty(value = "Valor de la llista")
	private String valor;

}
