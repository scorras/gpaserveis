package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusGrupApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Grups")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "titol", "titolCastella", "descripcio", "descripcioCastella", "tipus", "columnes", "ordre", "urlValidacio",
        "atributs" })
@Getter
@Setter
public class DadesGrupsRDTO {

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
	@ApiModelProperty(value = "Columnes del grup d'atributs")
	private String columnes;
	@ApiModelProperty(value = "Ordre del grup d'atributs")
	private String ordre;
	@ApiModelProperty(value = "URL de validació a nivell de grup d'atributs")
	private String urlValidacio;
	@ApiModelProperty(value = "Atributs del grup")
	private List<DadesAtributsRDTO> atributs = Collections.emptyList();

}
