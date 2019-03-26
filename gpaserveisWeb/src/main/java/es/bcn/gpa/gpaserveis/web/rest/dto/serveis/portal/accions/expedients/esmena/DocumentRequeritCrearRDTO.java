package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.IdiomaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.OrigenApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.FitxerRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentRequeritCrear")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "configuracioDocumentacio", "origen", "comentari", "idioma", "fitxer" })
@Getter
@Setter
public class DocumentRequeritCrearRDTO {

	@ApiModelProperty(value = "Codi corresponent a la configuració del document definit a RPA.", required = true)
	private String configuracioDocumentacio;
	@ApiModelProperty(value = "Origen del tipus de documentació.", required = true, allowableValues = OrigenApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String origen;
	@ApiModelProperty(value = "Comentari del document.")
	private String comentari;
	@ApiModelProperty(value = "Idioma del document", allowableValues = IdiomaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String idioma;
	@ApiModelProperty(value = "Fitxer", required = true)
	private FitxerRDTO fitxer;

}
