package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaExpedientsCercaBDTO {

	/** The dades expedient BDTO list. */
	private List<DadesExpedientBDTO> dadesExpedientBDTOList;

	/** The pagination attributes. */
	private PaginationAttributes paginationAttributes;

}
