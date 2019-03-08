package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SolicitudActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "valor" })
@Getter
@Setter
public class AtributsActualitzarRDTO {

	@ApiModelProperty(value = "Codi identificador de l'atribut.", required = true)
	private String codi;
	@ApiModelProperty(value = "Valor de l'atribut", required = true)
	private String valor;

}
