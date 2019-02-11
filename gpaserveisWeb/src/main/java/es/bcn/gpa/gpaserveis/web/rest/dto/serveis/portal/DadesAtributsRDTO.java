package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusCampApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Atributs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "descripcio", "ordre", "tipus", "valorsLlista", "validacions", "urlValidacio", "urlAjuda" })
@Getter
@Setter
public class DadesAtributsRDTO {

	@ApiModelProperty(value = "Codi de l'atribut")
	private String codi;
	@ApiModelProperty(value = "Descripció de l'atribut")
	private String descripcio;
	@ApiModelProperty(value = "Ordre del atribut dins del grup")
	private String ordre;
	@ApiModelProperty(value = "Tipus de camp de l'atribut", allowableValues = TipusCampApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipus;
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llista, valors d'aquesta llista")
	private List<DadesAtributsValorsLlistaRDTO> valorsLlista;
	@ApiModelProperty(value = "Validacións de l'atribut")
	private List<DadesAtributsValidacionsRDTO> validacions;
	@ApiModelProperty(value = "URL de validació a nivell d'atribut")
	private String urlValidacio;
	@ApiModelProperty(value = "URL d'ajuda a nivell d'atribut")
	private String urlAjuda;

}
