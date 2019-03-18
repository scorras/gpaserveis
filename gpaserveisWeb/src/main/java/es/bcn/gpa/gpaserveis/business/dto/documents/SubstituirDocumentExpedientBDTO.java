package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SubstituirDocumentExpedient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubstituirDocumentExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The substituir document expedient. */
	private SubstituirDocumentExpedient substituirDocumentExpedient;

}
