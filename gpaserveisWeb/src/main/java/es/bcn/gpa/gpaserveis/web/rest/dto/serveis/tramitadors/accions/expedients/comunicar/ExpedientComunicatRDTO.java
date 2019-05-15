package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.comunicar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusCanalComunicacioApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientComunicat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "canal", "dataComunicacio", "comentari" })
@Getter
@Setter
public class ExpedientComunicatRDTO {

	@ApiModelProperty(value = "Canal de comunicació informat.", required = true, allowableValues = TipusCanalComunicacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String canal;
	@ApiModelProperty(value = "Data del comunicat.", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataComunicacio;
	@ApiModelProperty(value = "Comentari.")
	private String comentari;

}
