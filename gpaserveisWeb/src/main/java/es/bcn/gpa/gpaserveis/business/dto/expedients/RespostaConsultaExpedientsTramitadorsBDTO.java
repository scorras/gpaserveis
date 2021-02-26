package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.consultar.ExpedientConsultaTramitadorsRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaConsultaExpedientsTramitadorsBDTO {

	private ExpedientConsultaTramitadorsRDTO expedient;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;
}
