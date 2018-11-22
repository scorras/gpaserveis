package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="RespostaExpedientCrear")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id"
})
@Getter
@Setter
public class RespostaCrearExpedientsRDTO {

	@ApiModelProperty("Identificador de l'expedient")
	private BigDecimal id;
	
}
