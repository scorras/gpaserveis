package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusValidacioApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Validacions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipus", "valorsValidacions" })
@Getter
@Setter
public class DadesAtributsValidacionsRDTO {

	@ApiModelProperty(value = "Tipus de validació", allowableValues = TipusValidacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipus;
	@ApiModelProperty(value = "Valors aplicables a la validació")
	private List<DadesAtributsValorsValidacionsRDTO> valorsValidacions;

}
