package es.bcn.gpa.gpaserveis.business.dto.procediments;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadesProcedimentBDTO {

	/** The procediments RDTO. */
	private ProcedimentsRDTO procedimentsRDTO;

	/** The tramits RDTO list. */
	private List<TramitsRDTO> tramitsRDTOList;

	/** The ugr RDTO. */
	private UnitatsGestoresRDTO ugrRDTO;

	/** The ugo RDTO list. */
	private List<UnitatsGestoresRDTO> ugoRDTOList;

}
