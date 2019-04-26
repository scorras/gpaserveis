package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientCanviEstatAccio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsCanviarEstatAccioBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsCanviarEstatAccioBDTO {

	/** The expedient canvi estat accio. */
	private ExpedientCanviEstatAccio expedientCanviEstatAccio;

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The id accio. */
	private BigDecimal idAccio;

}
