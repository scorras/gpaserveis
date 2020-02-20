package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.RelacioPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Persona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipusPersona", "nomRaoSocial", "cognom1", "cognom2", "documentIndentitat", "dadesNotificacio" })
@XmlRootElement(name = "persona")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class PersonesRDTO {

	@ApiModelProperty(value = "Tipus de persona", allowableValues = TipusPersonaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	@XmlElement(name = "tipusPersona")
	private String tipusPersona;
	@ApiModelProperty(value = "Nom o raó social de la persona", required = true)
	@XmlElement(name = "nomRaoSocial")
	private String nomRaoSocial;
	@ApiModelProperty(value = "Cognom 1 de la persona", required = false)
	@XmlElement(name = "cognom1")
	private String cognom1;
	@ApiModelProperty(value = "Cognom 2 de la persona", required = false)
	@XmlElement(name = "cognom2")
	private String cognom2;
	@ApiModelProperty(value = "Document d'identitat de la persona", required = false)
	@XmlElement(name = "documentIndentitat")
	private DocumentsIdentitatRDTO documentIndentitat;
	@ApiModelProperty(value = "Dades de notificació de la persona", required = false)
	@XmlElement(name = "dadesNotificacio")
	private DadesContacteRDTO dadesNotificacio;
	@ApiModelProperty(value = "Relacio de la persona", allowableValues = RelacioPersonaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = false)
	@XmlElement(name = "relacio")
	private String relacio;
}
