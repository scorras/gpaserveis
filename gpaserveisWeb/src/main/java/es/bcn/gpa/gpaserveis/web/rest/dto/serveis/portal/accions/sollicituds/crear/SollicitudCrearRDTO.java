package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitOvtApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SollicitudCrear")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiTramit", "sollicitant", "representant" })
@Getter
@Setter
public class SollicitudCrearRDTO {

	@ApiModelProperty(value = "Codi Tramit OVT relacionat a la sol·licitud", allowableValues = TramitOvtApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES_SOLLICITUDS, required = true)
	private String codiTramit;
	@ApiModelProperty(value = "Persona sol·licitant", required = true)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Persona representant", required = false)
	private PersonesRDTO representant;

}
