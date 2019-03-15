package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AportarDocumentacioExpedient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AportarDocumentacioExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The aportar documentacio expedient. */
	private AportarDocumentacioExpedient aportarDocumentacioExpedient;

}
