package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientConsultaRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaConsultaExpedientsBDTO {

	private ExpedientConsultaRDTO expedient;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;
}
