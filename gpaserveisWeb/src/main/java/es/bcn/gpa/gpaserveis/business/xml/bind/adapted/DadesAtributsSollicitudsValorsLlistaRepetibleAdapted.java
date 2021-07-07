package es.bcn.gpa.gpaserveis.business.xml.bind.adapted;

import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.DadesAtributsValorsLlistaRepetibleSollicitudsRDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class DadesAtributsSollicitudsValorAdapted.
 */
@Getter
@Setter
public class DadesAtributsSollicitudsValorsLlistaRepetibleAdapted {

	/** The valorsLlistaRepetible. */
	private List<DadesAtributsValorsLlistaRepetibleSollicitudsRDTO> valorsLlistaRepetible;
}