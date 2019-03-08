package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaActualitzarExpedients")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi" })
@Getter
@Setter
public class RespostaActualitzarExpedientsRDTO {

	@ApiModelProperty("Identificador de l'expedient")
	private BigDecimal id;

	@ApiModelProperty("Codi de l’expedient assignat durant la creació")
	private String codi;

}
