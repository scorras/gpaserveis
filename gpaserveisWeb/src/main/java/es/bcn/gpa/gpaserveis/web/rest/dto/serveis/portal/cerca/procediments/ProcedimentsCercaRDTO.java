package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitadorApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ProcedimentCerca")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "versio", "nom", "nomCastella", "descripcio", "ugr", "ugo", "estat", "estatCastella", "tramitador",
        "aplicacioNegoci", "organResolutori", "requereixNotificacio" })
@Getter
@Setter
public class ProcedimentsCercaRDTO {

	@ApiModelProperty(value = "Identificador del procediment")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi del procediment")
	private String codi;
	@ApiModelProperty(value = "Versió del procediment")
	private BigDecimal versio;
	@ApiModelProperty(value = "Nom del procediment")
	private String nom;
	@ApiModelProperty(value = "Nom del procediment en castellà")
	private String nomCastella;
	@ApiModelProperty(value = "Descripció del procediment")
	private String descripcio;
	@ApiModelProperty(value = "Unitat gestora responsable")
	private UnitatGestoraRDTO ugr;
	@ApiModelProperty(value = "Llista d'unitats gestores operatives")
	private List<UnitatGestoraRDTO> ugo;
	@ApiModelProperty(value = "Estat actual del procediment")
	private String estat;
	@ApiModelProperty(value = "Estat actual del procediment en castellà")
	private String estatCastella;
	@ApiModelProperty(value = "Aplicació de tramitació", allowableValues = TramitadorApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tramitador;
	@ApiModelProperty(value = "Nom de l'aplicació, en cas que el tramitador sigui una aplicació de negoci")
	private String aplicacioNegoci;
	@ApiModelProperty(value = "Òrgan resolutori del procediment")
	private String organResolutori;
	@ApiModelProperty(value = "Requereix Notificacio")
	private String requereixNotificacio;
	
}
