package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.CaracteristiquesGrupApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusGrupApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Grups")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "titol", "titolCastella", "descripcio", "descripcioCastella", "tipus", "pantalla", "repeticions", "columnes", "ordre",
        "caracteristiques", "urlValidacio", "atributs" })
@Getter
@Setter
public class DadesGrupsRDTO {
	@ApiModelProperty(value = "Codi de el grup")
	private String codi;
	@ApiModelProperty(value = "Títol del grup d'atributs")
	private String titol;
	@ApiModelProperty(value = "Títol del grup d'atributs en castellà")
	private String titolCastella;
	@ApiModelProperty(value = "Descripció del grup d'atributs")
	private String descripcio;
	@ApiModelProperty(value = "Descripció del grup d'atributs en castellà")
	private String descripcioCastella;
	@ApiModelProperty(value = "Tipus del grup d'atributs", allowableValues = TipusGrupApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipus;
	@ApiModelProperty(value = "Nombre màxim de repeticions del grup d'atributs repetible")
	private String repeticions;
	@ApiModelProperty(value = "Pantalla del grup d'atributs")
	private String pantalla;
	@ApiModelProperty(value = "Columnes del grup d'atributs")
	private String columnes;
	@ApiModelProperty(value = "Ordre del grup d'atributs")
	private String ordre;
	@ApiModelProperty(value = "Caracteristiques del grup d'atributs", allowableValues = CaracteristiquesGrupApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private List<String> caracteristiques;
	@ApiModelProperty(value = "URL de validació a nivell de grup d'atributs")
	private String urlValidacio;
	@ApiModelProperty(value = "Atributs del grup")
	private List<DadesAtributsRDTO> atributs = Collections.emptyList();

}
