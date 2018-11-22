package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.obrir.expedients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaObrirExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi"
})
@Getter
@Setter
public class RespostaObrirExpedientsRDTO {
    
	@ApiModelProperty("Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty("Codi de l'expedient")
	private String codi;
	
}


