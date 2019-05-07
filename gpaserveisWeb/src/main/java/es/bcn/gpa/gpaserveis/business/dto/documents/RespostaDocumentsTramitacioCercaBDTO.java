package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaDocumentsTramitacioCercaBDTO {

	/** The configuracio docs tramitacio RDTO list. */
	private List<ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOList;

}
