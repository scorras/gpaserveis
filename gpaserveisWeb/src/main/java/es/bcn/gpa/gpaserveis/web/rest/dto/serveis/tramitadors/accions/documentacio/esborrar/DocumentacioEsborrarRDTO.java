package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.esborrar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.ConfiguracioApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentacioEsborrar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "configuracio" })
@Getter
@Setter
public class DocumentacioEsborrarRDTO {

	@ApiModelProperty(value = "Configuració del document.", required = true, allowableValues = ConfiguracioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String configuracio;

}
