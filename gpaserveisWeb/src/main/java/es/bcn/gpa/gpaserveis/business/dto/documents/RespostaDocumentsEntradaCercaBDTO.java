package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaDocumentsEntradaCercaBDTO {

	/** The configuracio docs entrada RDTO list. */
	private List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList = null;

}
