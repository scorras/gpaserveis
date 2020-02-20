package es.bcn.gpa.gpaserveis.business.dto.documents;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespostaEsborrarDocumentEntradaSollicitudBDTO {

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;

	/** The docs entrada RDTO. */
	private DocsEntradaRDTO docsEntradaRDTO;

	/** The resposta resultat BDTO. */
	private RespostaResultatBDTO respostaResultatBDTO;
	
	/** The sollicituds RDTO. */
	private SollicitudsRDTO sollicitudsRDTO;

}
