package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusSexeApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Persona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "tipusPersona", "nomRaoSocial", "cognom1", "cognom2", "documentIndentitat", "dadesContacte" })
@Getter
@Setter
public class PersonesRDTO {

	@ApiModelProperty(value = "Identificador de la persona")
	private BigDecimal id;
	@ApiModelProperty(value = "Tipus de persona", allowableValues = TipusPersonaApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipusPersona;
	@ApiModelProperty(value = "Nom o raó social de la persona")
	private String nomRaoSocial;
	@ApiModelProperty(value = "Cognom 1 de la persona")
	private String cognom1;
	@ApiModelProperty(value = "Cognom 2 de la persona")
	private String cognom2;
	@ApiModelProperty(value = "Sexe de la persona", allowableValues = TipusSexeApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String sexe;
	@ApiModelProperty(value = "Document d'identitat de la persona")
	private DocumentsIdentitatRDTO documentIndentitat;
	@ApiModelProperty(value = "Dades de contacte de la persona")
	private DadesContacteRDTO dadesContacte;
}
