package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;

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

	/**
	 * Consultar dades unitat gestora.
	 *
	 * @param id
	 *            the id
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	UnitatsGestoresRDTO consultarDadesUnitatGestora(BigDecimal id) throws GPAServeisServiceException;

	/**
	 * Consultar dades unitat gestora per codi.
	 *
	 * @param codi
	 *            the codi
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	UnitatsGestoresRDTO consultarDadesUnitatGestoraPerCodi(String codi) throws GPAServeisServiceException;

}
