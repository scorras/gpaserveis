package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaValidarExpedient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaExpedientsValidarBDTO {

	/** The resposta validar expedient. */
	private RespostaValidarExpedient respostaValidarExpedient;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
