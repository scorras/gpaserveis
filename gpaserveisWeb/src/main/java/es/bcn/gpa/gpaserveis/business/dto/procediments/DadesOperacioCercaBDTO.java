package es.bcn.gpa.gpaserveis.business.dto.procediments;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DadesOperacioCercaBDTO {

	/** The id procediment. */
	private BigDecimal idProcediment;

	/** The id tramit. */
	private BigDecimal idTramitOvt;

}
