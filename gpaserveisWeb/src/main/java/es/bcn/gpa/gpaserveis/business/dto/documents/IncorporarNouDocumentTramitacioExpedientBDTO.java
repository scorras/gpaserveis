package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncorporarNouDocumentTramitacioExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The docs tramitacio RDTO. */
	private DocsTramitacioRDTO docsTramitacioRDTO;

}
