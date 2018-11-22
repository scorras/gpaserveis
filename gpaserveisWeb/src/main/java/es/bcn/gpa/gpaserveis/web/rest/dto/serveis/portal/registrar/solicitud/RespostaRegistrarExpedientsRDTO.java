package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.registrar.solicitud;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="RespostaExpedientCrear")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
    "registre"
})
@Getter
@Setter
public class RespostaRegistrarExpedientsRDTO {

	@ApiModelProperty("Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty("Dades del registre de l'expedient")
	private RegistreRDTO registre;
	
}
