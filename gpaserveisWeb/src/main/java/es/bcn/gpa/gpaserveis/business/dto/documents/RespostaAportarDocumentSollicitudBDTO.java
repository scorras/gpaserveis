package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaAportarDocumentExpedientBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class RespostaAportarDocumentSollicitudBDTO {

	/** The docs entrada RDTO list. */
	private List<DocsEntradaRDTO> docsEntradaRDTOList = null;

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO = null;
	
	private SollicitudsRDTO sollicitudsRDTO = null;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;

}
