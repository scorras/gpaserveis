package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.EstatCiutadaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Historic")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "estat", "dataCreacio" })
@Getter
@Setter
public class HistoricsRDTO {

	@ApiModelProperty(value = "Estat de l'històric", allowableValues = EstatCiutadaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String estat;
	@ApiModelProperty(value = "Data de creació de l'històric")
	private String dataCreacio;

}
