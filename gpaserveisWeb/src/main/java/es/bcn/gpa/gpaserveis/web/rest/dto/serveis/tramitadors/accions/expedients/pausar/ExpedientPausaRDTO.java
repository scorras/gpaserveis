package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.MotiuPausaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientPausa")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "motiu", "dataLimit" })
@Getter
@Setter
public class ExpedientPausaRDTO {

	@ApiModelProperty(value = "Motiu per a pausar l'expedient", required = true, allowableValues = MotiuPausaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String motiu;
	@ApiModelProperty(value = "Data límit que estableix la durada de la pausa de l'expedient.")
	private BigDecimal dataLimit;

}
