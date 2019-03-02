package es.bcn.gpa.gpaserveis.business.dto.procediments;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaProcedimentsCercaBDTO {

	/** The dades procediment BDTO list. */
	private List<DadesProcedimentBDTO> dadesProcedimentBDTOList;

	/** The pagination attributes. */
	private PaginationAttributes paginationAttributes;

}
