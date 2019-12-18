package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "PersonaNotificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipusPersona", "nom", "cognom1", "cognom2", "documentIdentitat", "dadesNotificacio" })
@Getter
@Setter
public class PersonesNotificacioRDTO {

	@ApiModelProperty(value = "Tipus de persona", allowableValues = TipusPersonaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	private String tipusPersona;
	@ApiModelProperty(value = "Nom de la persona", required = true)
	private String nom;
	@ApiModelProperty(value = "Cognom 1 de la persona", required = true)
	private String cognom1;
	@ApiModelProperty(value = "Cognom 2 de la persona", required = false)
	private String cognom2;
	@ApiModelProperty(value = "Document d'identitat de la persona", required = true)
	private DocumentsIdentitatNotificacioRDTO documentIdentitat;
	@ApiModelProperty(value = "Dades de notificació de la persona", required = true)
	private DadesContacteNotificacioRDTO dadesNotificacio;

}
