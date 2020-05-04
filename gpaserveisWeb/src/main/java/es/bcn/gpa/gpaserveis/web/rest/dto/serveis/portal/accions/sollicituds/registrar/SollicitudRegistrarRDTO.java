package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.registrar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SollicitudRegistrarRDTO.
 */
@ApiModel(value = "SollicitudRegistrar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "signaturaSolicitud" })
@Getter
@Setter
public class SollicitudRegistrarRDTO {

	/** The signatura solicitud. */
	@ApiModelProperty(value = "Identificador de la signatura de la sol·licitud")
	private BigDecimal signaturaSolicitud;

}
