package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistrarSolicitudExpedient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsRegistrarBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsRegistrarBDTO {

	/** The registrar solicitud expedient. */
	private RegistrarSolicitudExpedient registrarSolicitudExpedient;
}
