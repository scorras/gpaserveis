package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class HistoricsExpedientsCercaBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class HistoricsExpedientsCercaBDTO {

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The tipus list. */
	private List<BigDecimal> tipusList;
}
