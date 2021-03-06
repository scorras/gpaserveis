package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusCampApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusGrupApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Atributs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "titol", "titolCastella", "descripcio", "descripcioCastella", "ordre", "tipus", "codiDefinicioGrup",
        "valorsLlista", "validacions", "urlOrigen", "visibilitat", "criticitat", "tipusDadaOperacio", "repeticions", "configuracioDocumentacioAportada" })
@Getter
@Setter
public class DadesAtributsRDTO {

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
	@ApiModelProperty(value = "Ordre del atribut dins del grup")
	private String ordre;
	@ApiModelProperty(value = "Tipus de camp de l'atribut", allowableValues = TipusCampApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipus;
	@ApiModelProperty(value = "Codi de el grup que actua com a subgrup")
	private String codiDefinicioGrup;
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llista, valors d'aquesta llista")
	private List<DadesAtributsValorsLlistaRDTO> valorsLlista;
	@ApiModelProperty(value = "Validacións de l'atribut")
	private List<DadesAtributsValidacionsRDTO> validacions;
	@ApiModelProperty(value = "URL d'origen a nivell d'atribut")
	private String urlOrigen;
	@ApiModelProperty(value = "Visibilitat")
	private Boolean visibilitat;
	@ApiModelProperty(value = "Criticitat")
	private String criticitat;
	@ApiModelProperty(value = "Tipus de dada d'operació de l'atribut", allowableValues = TipusGrupApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipusDadaOperacio;
	@ApiModelProperty(value = "Repeticions")
	private String repeticions;
	@ApiModelProperty(value = "Configuracio Documentacio Aportada")
	private ConfiguracioDocumentacioAportadaRDTO configuracioDocumentacioAportada;

}
