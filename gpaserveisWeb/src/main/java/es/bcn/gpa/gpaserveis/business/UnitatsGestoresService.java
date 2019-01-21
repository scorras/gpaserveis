package es.bcn.gpa.gpaserveis.business;

import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;

/**
 * The Interface UnitatsGestoresService.
 */
public interface UnitatsGestoresService {

	/**
	 * Cerca unitats gestores.
	 *
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the page data of unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfUnitatsGestoresRDTO cercaUnitatsGestores(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO) throws GPAServeisServiceException;

}
