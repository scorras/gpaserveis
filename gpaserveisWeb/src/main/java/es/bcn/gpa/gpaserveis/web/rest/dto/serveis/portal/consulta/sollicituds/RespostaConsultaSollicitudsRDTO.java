package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaSollicituds")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sollicitud" })
@Getter
@Setter
public class RespostaConsultaSollicitudsRDTO {

	@ApiModelProperty(value = "Sollicitud")
	private SollicitudConsultaRDTO sollicitud;

}
