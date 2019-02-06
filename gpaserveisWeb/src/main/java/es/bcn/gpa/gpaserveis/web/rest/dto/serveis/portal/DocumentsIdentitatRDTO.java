package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;

@ApiModel(value = "DocumentIdentitat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipusDocument", "numeroDocument", "pais" })
@Getter
@Setter
public class DocumentsIdentitatRDTO {

	@ApiModelProperty(value = "Tipus de document d'identitat de la persona", allowableValues = TipusDocumentIdentitatApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipusDocument;
	@ApiModelProperty(value = "Número de document d'identitat de la persona")
	private String numeroDocument;
	@ApiModelProperty(value = "Codi ISO del país del document d'identitat de la persona")
	private String pais;

}