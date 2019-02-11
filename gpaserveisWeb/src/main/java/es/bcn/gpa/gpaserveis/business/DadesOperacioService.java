package es.bcn.gpa.gpaserveis.business;

import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;

/**
 * The Interface DadesOperacioService.
 */
public interface DadesOperacioService {

	/**
	 * Cerca dades operacio.
	 *
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the page data of dades grups RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfDadesGrupsRDTO cercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO) throws GPAServeisServiceException;

}
