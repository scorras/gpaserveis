package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class DadesExpedientBDTO.
 */
@Getter
@Setter
public class DadesExpedientBDTO {

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO;

	/** The unitats gestores RDTO. */
	private UnitatsGestoresRDTO unitatsGestoresRDTO;

	/** The historics estats. */
	private List<EstatsRDTO> historicsEstats;

	/** The sollicitant. */
	private Persones sollicitant;

	/** The representant. */
	private Persones representant;

	/** The persones interessades. */
	private List<PersonesSollicitudRDTO> personesInteressades;

	/** The persones implicades. */
	private List<PersonesSollicitudRDTO> personesImplicades;

	/** The accions disponibles. */
	private List<AccionsEstatsRDTO> accionsDisponibles;

	/** The documents aportats. */
	private List<DocsEntradaRDTO> documentsAportats;

	/** The documents requerits. */
	private List<ConfDocEntradaRequeritRDTO> configuracioDocumentacioRequerida;

	/** The dades operacio. */
	private List<DadaEspecificaBDTO> dadesOperacio;

	/** The dades operacio. */
	private List<DadesOperacions> dadesOperacioRequerits;

	/** The tramits ovt map. */
	private Map<BigDecimal, TramitsOvtRDTO> tramitsOvtMap;

	/** The sollicituds. */
	private List<SollicitudsRDTO> sollicituds;

}
