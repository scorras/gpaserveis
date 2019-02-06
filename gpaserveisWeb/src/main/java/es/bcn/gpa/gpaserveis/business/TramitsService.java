package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;

/**
 * The Interface TramitsService.
 */
public interface TramitsService {

	/**
	 * Cerca tramits procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @return the page data of tramits RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfTramitsRDTO cercaTramitsProcediment(BigDecimal idProcediment) throws GPAServeisServiceException;
}
