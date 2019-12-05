package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ObtenirPerInteroperabilitat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ObtenirPerInteroperabilitatBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ObtenirPerInteroperabilitatBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The obtenir per interoperabilitat. */
	private ObtenirPerInteroperabilitat obtenirPerInteroperabilitat;

}
