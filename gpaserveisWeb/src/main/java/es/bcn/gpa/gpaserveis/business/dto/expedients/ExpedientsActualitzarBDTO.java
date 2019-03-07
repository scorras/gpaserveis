package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
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

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;
}
