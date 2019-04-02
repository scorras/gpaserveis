package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.IniciacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.DadesIdentificacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ProcedimentConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "versio", "nom", "nomCastella", "descripcio", "descripcioCastella", "ugr", "ugo", "organResolutori",
        "inici", "estat", "estatCastella", "dadesIdentificacio" })
@Getter
@Setter
public class ProcedimentsConsultaRDTO {

	@ApiModelProperty(value = "Identificador del procediment")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi del procediment")
	private String codi;
	@ApiModelProperty(value = "Versió del procediment")
	private String versio;
	@ApiModelProperty(value = "Nom del procediment")
	private String nom;
	@ApiModelProperty(value = "Nom del procediment en castellà")
	private String nomCastella;
	@ApiModelProperty(value = "Descripció del procediment")
	private String descripcio;
	@ApiModelProperty(value = "Descripció del procediment en castellà")
	private String descripcioCastella;
	@ApiModelProperty(value = "Unitat gestora responsable")
	private UnitatGestoraRDTO ugr;
	@ApiModelProperty(value = "Llista d'unitats gestores operatives")
	private List<UnitatGestoraRDTO> ugo;
	@ApiModelProperty(value = "Òrgan resolutori")
	private String organResolutori;
	@ApiModelProperty(value = "Tipus d'inici del procediment", allowableValues = IniciacioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private List<String> inici;
	@ApiModelProperty(value = "Estat actual del procediment")
	private String estat;
	@ApiModelProperty(value = "Estat actual del procediment en castellà")
	private String estatCastella;
	// @ApiModelProperty(value = "Llista de tràmits del procediment")
	// private List<TramitsRDTO> tramits;
	@ApiModelProperty(value = "Dades d'identificació del procediment")
	private DadesIdentificacioRDTO dadesIdentificacio;

}
