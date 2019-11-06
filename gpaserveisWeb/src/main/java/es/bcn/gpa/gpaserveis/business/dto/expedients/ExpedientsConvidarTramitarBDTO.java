package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ConvidarTramitarRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsConvidarTramitarBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsConvidarTramitarBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The convidar tramitar RDTO. */
	private ConvidarTramitarRDTO convidarTramitarRDTO;

}
