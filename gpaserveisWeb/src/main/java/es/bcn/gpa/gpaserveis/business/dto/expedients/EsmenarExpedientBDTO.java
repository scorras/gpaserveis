package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.AportarDocumentacioExpedient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EsmenarExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The aportar documentacio expedient. */
	private AportarDocumentacioExpedient aportarDocumentacioExpedient;

}
