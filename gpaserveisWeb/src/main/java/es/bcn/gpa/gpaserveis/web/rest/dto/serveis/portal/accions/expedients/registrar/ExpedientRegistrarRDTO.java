package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.registrar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientRegistrarRDTO.
 */
@ApiModel(value = "ExpedientRegistrar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "signaturaSolicitud", "matriculaInformador" })
@Getter
@Setter
public class ExpedientRegistrarRDTO {

	/** The signatura solicitud. */
	@ApiModelProperty(value = "Identificador de la signatura de la sol·licitud")
	private BigDecimal signaturaSolicitud;

	/** The matricula informador. */
	@ApiModelProperty(value = "Matrícula de l'informador.")
	private String matriculaInformador;

}
