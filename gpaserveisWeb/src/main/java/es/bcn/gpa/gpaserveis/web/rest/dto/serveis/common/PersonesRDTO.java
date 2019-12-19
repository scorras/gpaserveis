package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Persona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipusPersona", "nomRaoSocial", "cognom1", "cognom2", "documentIndentitat", "dadesNotificacio" })
@Getter
@Setter
public class PersonesRDTO {

	@ApiModelProperty(value = "Tipus de persona", allowableValues = TipusPersonaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	private String tipusPersona;
	@ApiModelProperty(value = "Nom o raó social de la persona", required = true)
	private String nomRaoSocial;
	@ApiModelProperty(value = "Cognom 1 de la persona", required = false)
	private String cognom1;
	@ApiModelProperty(value = "Cognom 2 de la persona", required = false)
	private String cognom2;
	@ApiModelProperty(value = "Document d'identitat de la persona", required = false)
	private DocumentsIdentitatRDTO documentIndentitat;
	@ApiModelProperty(value = "Dades de notificació de la persona", required = false)
	private DadesContacteRDTO dadesNotificacio;
}
