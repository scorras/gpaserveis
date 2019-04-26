package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ComentariCreacioAccio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ComentarisCrearAccioBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ComentarisCrearAccioBDTO {

	/** The comentari creacio accio. */
	private ComentariCreacioAccio comentariCreacioAccio;

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The id accio. */
	private BigDecimal idAccio;

}
