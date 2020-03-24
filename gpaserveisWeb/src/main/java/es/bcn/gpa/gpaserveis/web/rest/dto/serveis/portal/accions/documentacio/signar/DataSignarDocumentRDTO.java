package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusSignaturaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DataSignarDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "personaSignarDocument", "modalitatSignatura" })
@Getter
@Setter
public class DataSignarDocumentRDTO {

	@ApiModelProperty(value = "Persona que signa el document")
	PersonaSignarDocumentRDTO personaSignarDocument;

	@ApiModelProperty(value = "Tipus de signatura", allowableValues = TipusSignaturaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String modalitatSignatura;

}
