package es.bcn.gpa.gpaserveis.business.dto.documents;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaAportarDocumentExpedientBDTO {

	/** The resposta aportar documentacio expedient RDTO. */
	private RespostaAportarDocumentacioExpedientRDTO respostaAportarDocumentacioExpedientRDTO;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
