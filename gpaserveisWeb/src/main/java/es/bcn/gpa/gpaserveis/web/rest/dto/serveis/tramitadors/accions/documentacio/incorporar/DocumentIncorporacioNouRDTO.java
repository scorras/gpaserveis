package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusEstatsDocumentsApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentIncorporacioNou")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document" })
@Getter
@Setter
public class DocumentIncorporacioNouRDTO {

	@ApiModelProperty(value = "Document", required = true)
	private DocumentIncorporatNouRDTO document;
	
	@ApiModelProperty(value = "Estat del document.", allowableValues = TipusEstatsDocumentsApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String estat;

}
