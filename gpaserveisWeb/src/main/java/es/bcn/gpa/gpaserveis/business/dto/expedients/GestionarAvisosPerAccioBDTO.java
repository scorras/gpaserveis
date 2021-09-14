package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.GestionarAvisosPerAccio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * The Class GestionarAvisosPerAccioBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class GestionarAvisosPerAccioBDTO {

	
	/** The gestionar avisos per accio. */
	private GestionarAvisosPerAccio gestionarAvisosPerAccio;

	/** The id expedient. */
	private BigDecimal idExpedient;


}
