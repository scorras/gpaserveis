package es.bcn.gpa.gpaserveis.business.dto.documents;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaUploadDocumentSollicitudBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class RespostaUploadDocumentSollicitudBDTO {

	/** The docs entrada RDTO. */
	private DocsEntradaRDTO docsEntradaRDTO = null;

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO = null;
	
	private RespostaResultatBDTO respostaResultatBDTO;
	
	/** The sollicituds RDTO. */
	private SollicitudsRDTO sollicitudsRDTO = null;
	

}
