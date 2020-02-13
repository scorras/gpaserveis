package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;

/**
 * The Interface SollicitudsService.
 */
public interface SollicitudsService {

	/**
	 * Consultar sollicituds expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<SollicitudsRDTO> consultarSollicitudsExpedient(BigDecimal idExpedient) throws GPAServeisServiceException;

}
