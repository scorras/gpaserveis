package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaSollicituds")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "sollicitud" })
@Getter
@Setter
public class RespostaConsultaSollicitudsRDTO {

	@ApiModelProperty(value = "Sollicitud")
	private SollicitudConsultaRDTO sollicitud;

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

}
