package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TornarEnrereRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsTornarEnrereBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsTornarEnrereBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The tornar enrere RDTO. */
	private TornarEnrereRDTO tornarEnrereRDTO;

}
