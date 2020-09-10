package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaCrearTerceraPersonaBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class RespostaCrearTerceraPersonaBDTO {

	/** The tercera persona RDTO. */
	private PersonesSollicitudRDTO personesSollicitudRDTO;

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
