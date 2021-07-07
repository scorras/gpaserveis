package es.bcn.gpa.gpaserveis.business.dto.expedients;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRepetiblesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class DadaEspecificaBDTO.
 */
@Getter
@Setter
public class DadaEspecificaBDTO {

	/** The dada especifica. */
	private DadesEspecifiquesRDTO dadaEspecifica;
	
	/** The dada especifica. */
	private DadesEspecifiquesRepetiblesRDTO dadaEspecificaRepetible;

	/** The dada operacio. */
	private DadesOperacions dadaOperacio;

}
