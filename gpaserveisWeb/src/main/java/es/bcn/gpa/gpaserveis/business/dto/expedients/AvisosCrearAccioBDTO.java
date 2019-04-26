package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AvisCreacioAccio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class AvisosCrearAccioBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class AvisosCrearAccioBDTO {

	/** The avis creacio accio. */
	private AvisCreacioAccio avisCreacioAccio;

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The id accio. */
	private BigDecimal idAccio;

}
