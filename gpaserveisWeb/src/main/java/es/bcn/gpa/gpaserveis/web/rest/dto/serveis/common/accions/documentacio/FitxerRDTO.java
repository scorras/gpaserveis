package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusMimeApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Fitxer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nom", "format" })
@Getter
@Setter
public class FitxerRDTO {

	@ApiModelProperty(value = "Nom del fitxer", required = true)
	String nom;
	@ApiModelProperty(value = "format del fitxer", required = true, allowableValues = TipusMimeApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	String format;
}
