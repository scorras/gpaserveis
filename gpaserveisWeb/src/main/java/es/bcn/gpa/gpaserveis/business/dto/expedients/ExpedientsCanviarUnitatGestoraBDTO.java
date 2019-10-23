package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CanviUnitatGestoraRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsCanviarUnitatGestoraBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsCanviarUnitatGestoraBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The canvi unitat gestora RDTO. */
	private CanviUnitatGestoraRDTO canviUnitatGestoraRDTO;

}
