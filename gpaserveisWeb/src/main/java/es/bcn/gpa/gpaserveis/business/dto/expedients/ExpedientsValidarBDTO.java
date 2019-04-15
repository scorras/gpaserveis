package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ValidarExpedient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsValidarBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsValidarBDTO {

	/** The abandonar expedient. */
	private ValidarExpedient validarExpedient;

}
