package es.bcn.gpa.gpaserveis.business.dto.procediments;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaDadesOperacioCercaBDTO {

	/** The dades grups RDTO list. */
	private List<DadesGrupsRDTO> dadesGrupsRDTOList;

}
