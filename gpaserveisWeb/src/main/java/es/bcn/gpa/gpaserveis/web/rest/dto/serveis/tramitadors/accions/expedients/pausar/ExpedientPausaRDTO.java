package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataLimit;

}
