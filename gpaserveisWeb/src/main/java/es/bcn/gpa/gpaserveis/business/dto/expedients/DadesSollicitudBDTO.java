package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.util.List;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class DadesSollicitudBDTO.
 */
@Getter
@Setter
public class DadesSollicitudBDTO {

	/** The sollicituds RDTO. */
	private SollicitudsRDTO sollicitudsRDTO;

	/** The unitats gestores RDTO. */
	private UnitatsGestoresRDTO unitatsGestoresRDTO;

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;

	/** The sollicitant. */
	private Persones sollicitant;

	/** The representant. */
	private Persones representant;

	/** The persones interessades. */
	private List<PersonesSollicitudRDTO> personesInteressades;

	/** The persones implicades. */
	private List<PersonesSollicitudRDTO> personesImplicades;

	/** The documents aportats. */
	private List<DocsEntradaRDTO> documentsAportats;

	/** The dades operacio. */
	private List<DadaEspecificaBDTO> dadesOperacio;

	/** The accions disponibles. */
	private List<AccionsEstatsRDTO> accionsDisponibles;

}
