package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaAbandonarExpedient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaExpedientsAbandonarBDTO {

	/** The resposta abandonar expedient. */
	private RespostaAbandonarExpedient respostaAbandonarExpedient;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
