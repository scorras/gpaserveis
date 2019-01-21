package es.bcn.gpa.gpaserveis.business;

import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;

/**
 * The Interface ProcedimentsService.
 */
public interface ProcedimentsService {

	/**
	 * Cerca procediments.
	 *
	 * @param procedimentsCercaBDTO
	 *            the procediments cerca BDTO
	 * @return the page data of procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfProcedimentsRDTO cercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO) throws GPAServeisServiceException;

}
