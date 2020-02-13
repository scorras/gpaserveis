package es.bcn.gpa.gpaserveis.business.dto.sollicituds;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaSollicitudsRegistrarBDTO {

	/** The resposta crear registre solicitud expedient. */
	private RespostaCrearRegistreExpedient respostaCrearRegistreExpedient;

	/** The resposta crear justificant solicitud. */
	private DocsTramitacioRDTO docsTramitacioRDTO;

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
