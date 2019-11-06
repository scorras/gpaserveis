package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornarTramitacioRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsRetornarTramitacioBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsRetornarTramitacioBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The retornar tramitacio RDTO. */
	private RetornarTramitacioRDTO retornarTramitacioRDTO;

}
