package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaExpedientsAcumularBDTO {

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;

	/** The expedients acumulats RDTO list. */
	private List<ExpedientsRDTO> expedientsAcumulatsRDTOList;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
