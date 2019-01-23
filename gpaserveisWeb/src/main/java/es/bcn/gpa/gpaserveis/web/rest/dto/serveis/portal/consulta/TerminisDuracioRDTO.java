package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.PeriodicitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TerminiMaximApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "TerminisDuracio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "terminiMaxim", "unitat", "periodicitat", "dataIniciVigencia", "dataFiVigencia" })
@Getter
@Setter
public class TerminisDuracioRDTO {

	@ApiModelProperty(value = "Termini màxim de duració del procediment")
	private String terminiMaxim;
	@ApiModelProperty(value = "Unitat de mesura del termini de duració", allowableValues = TerminiMaximApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String unitat;
	@ApiModelProperty(value = "Periodicitat del procediment", allowableValues = PeriodicitatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String periodicitat;
	@ApiModelProperty(value = "Data inici vigència")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
	private String dataIniciVigencia;
	@ApiModelProperty(value = "Data fi vigència")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
	private String dataFiVigencia;

}