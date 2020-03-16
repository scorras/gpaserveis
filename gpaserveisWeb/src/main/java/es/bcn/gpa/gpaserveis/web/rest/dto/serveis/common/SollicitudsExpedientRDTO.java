package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitOvtApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SollicitudsExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "tipus", "estat" })
@Getter
@Setter
public class SollicitudsExpedientRDTO {

	@ApiModelProperty(value = "Identificador de la sol·licitud", required = true)
	private BigDecimal id;
	@ApiModelProperty(value = "Tipus de la sol·licitud", allowableValues = TramitOvtApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	private String tipus;
	@ApiModelProperty(value = "Estat de la sol·licitud", required = true)
	private String estat;
}
