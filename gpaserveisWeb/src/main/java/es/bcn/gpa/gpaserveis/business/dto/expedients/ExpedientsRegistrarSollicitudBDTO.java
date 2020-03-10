package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearSollicitud;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsRegistrarSollicitudBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsRegistrarSollicitudBDTO {

	/** The registrar solicitud. */
	private CrearSollicitud crearSollicitud;
}
