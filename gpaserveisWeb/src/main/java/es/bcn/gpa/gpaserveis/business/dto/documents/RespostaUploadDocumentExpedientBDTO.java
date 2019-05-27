package es.bcn.gpa.gpaserveis.business.dto.documents;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaAportarDocumentExpedientBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class RespostaUploadDocumentExpedientBDTO {

	/** The docs entrada RDTO. */
	private DocsEntradaRDTO docsEntradaRDTO = null;

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO = null;

	/** The registre assentament RDTO. */
	private RegistreAssentamentRDTO registreAssentamentRDTO = null;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
