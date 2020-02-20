package es.bcn.gpa.gpaserveis.business.dto.sollicituds;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SollicitudsCercaBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class SollicitudsCercaBDTO {

	/** The id. */
	private BigDecimal id;

	/** The id expedient. */
	private BigDecimal idExpedient;

	/** The id tramit ovt. */
	private BigDecimal idTramitOvt;

	/** The current page number. */
	private Integer currentPageNumber;

	/** The page size. */
	private Integer pageSize;

	/** The sort. */
	private String sort;

	/** The dir. */
	private String dir;
}
