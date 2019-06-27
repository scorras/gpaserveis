package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentsIdentitatNotificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipusDocument", "numeroDocument" })
@Getter
@Setter
public class DocumentsIdentitatNotificacioRDTO {

	@ApiModelProperty(value = "Tipus de document d'identitat de la persona", allowableValues = TipusDocumentIdentitatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	private String tipusDocument;
	@ApiModelProperty(value = "Número de document d'identitat de la persona", required = true)
	private String numeroDocument;

}