package es.bcn.gpa.gpaserveis.business.dto.sollicituds;

import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaSollicitudsCercaBDTO {

	/** The dades sollicitud BDTO list. */
	private List<DadesSollicitudBDTO> dadesSollicitudBDTOList;

	/** The pagination attributes. */
	private PaginationAttributes paginationAttributes;

}
