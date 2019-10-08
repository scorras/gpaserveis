package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.AnotarOperacioComptableRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnotarOperacioComptableBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The anotar operacio comptable RDTO. */
	private AnotarOperacioComptableRDTO anotarOperacioComptableRDTO;
}
