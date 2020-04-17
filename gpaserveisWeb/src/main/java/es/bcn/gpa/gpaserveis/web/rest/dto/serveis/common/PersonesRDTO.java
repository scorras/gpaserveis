package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonPropertyOrder({ "relacio", "visibilitatOvt", "tipusPersona", "nomRaoSocial", "cognom1", "cognom2", "documentIndentitat",
		"dadesNotificacio" })
@XmlRootElement(name = "PERSONA")
@XmlType(name = "Persones", propOrder = { "relacio", "tipusPersona", "nomComplet", "documentIndentitat", "dadesNotificacio" })
@XmlAccessorType(XmlAccessType.NONE)
@Getter
@Setter
public class PersonesRDTO {

	@ApiModelProperty(value = "Relacio de la persona", allowableValues = RelacioPersonaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = false)
	@XmlElement(name = "RELACIO", required = true, type = String.class)
	private String relacio;
	@ApiModelProperty(value = "Visibilitat Ovt", required = false)
	private Boolean visibilitatOvt;
	@ApiModelProperty(value = "Tipus de persona", allowableValues = TipusPersonaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES, required = true)
	@XmlElement(name = "TIPUS_PERSONA", required = true, type = String.class)
	private String tipusPersona;
	@ApiModelProperty(value = "Nom o raó social de la persona", required = true)
	@XmlTransient
	private String nomRaoSocial;
	@ApiModelProperty(value = "Cognom 1 de la persona", required = false)
	@XmlTransient
	private String cognom1;
	@ApiModelProperty(value = "Cognom 2 de la persona", required = false)
	@XmlTransient
	private String cognom2;
	@ApiModelProperty(value = "Document d'identitat de la persona", required = false)
	@XmlElement(name = "DOCUMENT_INDENTITAT", required = true, type = DocumentsIdentitatRDTO.class)
	private DocumentsIdentitatRDTO documentIndentitat;
	@ApiModelProperty(value = "Dades de notificació de la persona", required = false)
	@XmlElement(name = "DADES_NOTIFICACIO", required = true, type = DadesContacteRDTO.class)
	private DadesContacteRDTO dadesNotificacio;

	@JsonIgnore
	@XmlElement(name = "NOM_COMPLET", required = true, type = String.class)
	public String getNomComplet() {
		return StringUtils.join(new String[] { nomRaoSocial, cognom1, cognom2 }, " ");
	}
}
