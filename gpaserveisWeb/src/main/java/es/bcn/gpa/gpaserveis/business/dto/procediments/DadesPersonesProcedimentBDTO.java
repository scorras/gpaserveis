package es.bcn.gpa.gpaserveis.business.dto.procediments;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadesPersonesProcedimentBDTO {

	/** The procediments RDTO. */
	private ProcedimentsRDTO procedimentsRDTO;

	/** The id tramit. */
	private BigDecimal idTramitOvt;
}
