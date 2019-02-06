package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.HistoricEstatApiParamValueTranslator;

@ApiModel(value = "Historic")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "estat", "dataCreacio", "descripcio" })
@Getter
@Setter
public class HistoricsRDTO {

	@ApiModelProperty(value = "Estat de l'històric", allowableValues = HistoricEstatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String estat;
	@ApiModelProperty(value = "Data de creació de l'històric")
	private String dataCreacio;
	@ApiModelProperty(value = "Descipció de l'històric")
	private String descripcio;

}
