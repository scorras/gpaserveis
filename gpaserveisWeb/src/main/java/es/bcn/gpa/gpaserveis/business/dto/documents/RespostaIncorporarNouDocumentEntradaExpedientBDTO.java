package es.bcn.gpa.gpaserveis.business.dto.documents;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaIncorporarNouDocumentEntradaExpedientBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class RespostaIncorporarNouDocumentEntradaExpedientBDTO {

	/** The docs entrada RDTO. */
	private DocsEntradaRDTO docsEntradaRDTO;

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;

	/** The registre assentament RDTO. */
	private RegistreAssentamentRDTO registreAssentamentRDTO;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
