package es.bcn.gpa.gpaserveis.business.dto.procediments;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProcedimentsCercaBDTO {

	/** The codi. */
	private String codi;

	/** The nom. */
	private String nom;

	/** The activable format electronic. */
	private List<String> activableFormatElectronic;

	/** The actuacio. */
	private String actuacio;

	/** The operador. */
	private Integer operador;

	/** The aplicacio negoci. */
	private String aplicacioNegoci;

	/** The competencies. */
	private List<BigDecimal> competencies;

	/** The estats. */
	private List<BigDecimal> estats;

	/** The families. */
	private List<BigDecimal> families;

	/** The intern. */
	private Integer intern;

	/** The organ resolutori. */
	private String organResolutori;

	/** The ugos. */
	private List<BigDecimal> ugos;

	/** The ugos. */
	private List<BigDecimal> iniciacions;

	/** The current page number. */
	private Integer currentPageNumber;

	/** The page size. */
	private Integer pageSize;

	/** The sort. */
	private String sort;

	/** The dir. */
	private String dir;
}
