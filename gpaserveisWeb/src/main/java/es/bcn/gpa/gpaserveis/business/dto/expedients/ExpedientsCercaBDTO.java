package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class ExpedientsCercaBDTO.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExpedientsCercaBDTO {

	/** The codi. */
	private String codi;

	/** The nif sollicitant. */
	private String nifSollicitant;

	/** The data presentacio des. */
	private DateTime dataPresentacioDes;

	/** The data presentacio fins A. */
	private DateTime dataPresentacioFinsA;

	/** The procediment codis list. */
	private List<String> procedimentCodisList;

	/** The procediment versio. */
	private BigDecimal procedimentVersio;

	/** The estat list. */
	private List<BigDecimal> estatList;

	/** The unitats gestores list. */
	private List<BigDecimal> unitatsGestoresList;

	/** The tramitador. */
	private String tramitador;

	/** The aplicacio negoci. */
	private String aplicacioNegoci;

	/** The current page number. */
	private Integer currentPageNumber;

	/** The page size. */
	private Integer pageSize;

	/** The sort. */
	private String sort;

	/** The dir. */
	private String dir;
}
