package es.bcn.gpa.gpaserveis.business.dto.expedients;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadesExpedientBDTO {

	/** The expedients RDTO. */
	private ExpedientsRDTO expedientsRDTO = null;

	/** The unitats gestores RDTO. */
	private UnitatsGestoresRDTO unitatsGestoresRDTO = null;

	/** The historics estats. */
	private List<EstatsRDTO> historicsEstats = null;

	/** The sollicitant. */
	private Persones sollicitant;

	/** The representant. */
	private Persones representant;

	/** The persones interessades. */
	private List<Persones> personesInteressades;

	/** The persones implicades. */
	private List<Persones> personesImplicades;

	/** The accions disponibles. */
	private List<AccionsEstatsRDTO> accionsDisponibles;

	/** The documents aportats. */
	private List<DocsEntradaRDTO> documentsAportats;

	/** The documents requerits. */
	private List<ConfDocEntradaRequeritRDTO> configuracioDocumentacioRequerida;

	/** The dades operacio. */
	private List<DadesEspecifiquesRDTO> dadesOperacio;

	/** The tramits ovt map. */
	private Map<BigDecimal, TramitsOvtRDTO> tramitsOvtMap;

}
