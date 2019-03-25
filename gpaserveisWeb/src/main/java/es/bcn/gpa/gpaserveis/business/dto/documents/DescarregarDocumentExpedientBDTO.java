package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DescarregarDocumentExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The id document. */
	private BigDecimal idDocument;

}
