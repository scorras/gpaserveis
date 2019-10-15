package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.InscriureEnRegistreRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InscriureEnRegistreBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The inscriure en registre RDTO. */
	private InscriureEnRegistreRDTO inscriureEnRegistreRDTO;
}
