package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusCampApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "AtributsRequerits")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "titol", "titolCastella", "descripcio", "descripcioCastella", "tipus" })
@Getter
@Setter
public class DadesAtributsRequeritsRDTO {

	@ApiModelProperty(value = "Codi de l'atribut")
	private String codi;
	@ApiModelProperty(value = "Títol de l'atribut")
	private String titol;
	@ApiModelProperty(value = "Títol de l'atribut en castellà")
	private String titolCastella;
	@ApiModelProperty(value = "Descripció de l'atribut")
	private String descripcio;
	@ApiModelProperty(value = "Descripció de l'atribut en castellà")
	private String descripcioCastella;
	@ApiModelProperty(value = "Tipus de camp de l'atribut", allowableValues = TipusCampApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipus;

}
