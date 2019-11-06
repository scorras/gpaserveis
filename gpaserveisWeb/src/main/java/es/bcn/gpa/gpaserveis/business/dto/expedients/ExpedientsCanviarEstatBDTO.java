package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsCanviarEstatBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsCanviarEstatBDTO {

	/** The expedient canvi estat accio. */
	private ExpedientCanviEstat expedientCanviEstat;

	/** The id expedient. */
	private BigDecimal idExpedient;

}
