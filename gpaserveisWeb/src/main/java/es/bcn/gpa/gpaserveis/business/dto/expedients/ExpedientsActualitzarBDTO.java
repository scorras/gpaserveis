package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ActualitzarDadesSollicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsCrearBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsActualitzarBDTO {

	/** The actualitzar dades sollicitud. */
	private ActualitzarDadesSollicitud actualitzarDadesSollicitud;
}
