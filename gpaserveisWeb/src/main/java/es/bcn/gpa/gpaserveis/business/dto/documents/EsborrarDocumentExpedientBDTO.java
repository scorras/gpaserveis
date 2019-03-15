package es.bcn.gpa.gpaserveis.business.dto.documents;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EsborrarDocumentExpedientBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The id document list. */
	private List<BigDecimal> idDocumentList;

}
