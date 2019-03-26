package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.UploadDocumentExpedient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UploadDocumentExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The upload document expedient. */
	private UploadDocumentExpedient uploadDocumentExpedient;

}
