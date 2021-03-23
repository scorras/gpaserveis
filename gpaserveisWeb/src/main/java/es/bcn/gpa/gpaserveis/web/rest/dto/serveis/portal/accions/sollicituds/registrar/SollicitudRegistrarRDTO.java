package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.registrar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.IdiomaPlantillaDocApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SollicitudRegistrarRDTO.
 */
@ApiModel(value = "SollicitudRegistrar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "signaturaSolicitud", "matriculaInformador", "idioma" })
@Getter
@Setter
public class SollicitudRegistrarRDTO {

	/** The signatura solicitud. */
	@ApiModelProperty(value = "Identificador de la signatura de la sol·licitud")
	private BigDecimal signaturaSolicitud;

	/** The matricula informador. */
	@ApiModelProperty(value = "Matrícula de l'informador.")
	private String matriculaInformador;

	/** The idioma. */
	@ApiModelProperty(value = "Idioma de la plantilla del justificant", allowableValues = IdiomaPlantillaDocApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String idioma;
}
