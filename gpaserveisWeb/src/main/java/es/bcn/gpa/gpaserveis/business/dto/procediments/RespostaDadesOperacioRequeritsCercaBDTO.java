package es.bcn.gpa.gpaserveis.business.dto.procediments;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaDadesOperacioRequeritsCercaBDTO {

	/** The dades operacions RDTO list. */
	private List<DadesOperacionsRDTO> dadesOperacionsRDTOList;

}
