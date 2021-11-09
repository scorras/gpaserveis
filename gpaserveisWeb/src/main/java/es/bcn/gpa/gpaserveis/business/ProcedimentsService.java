package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;

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
	PageDataOfProcedimentsRDTO cercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO)
			throws GPAServeisServiceException;

	/**
	 * Consultar dades procediment.
	 *
	 * @param id
	 *            the id
	 * @return the procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ProcedimentsRDTO consultarDadesProcediment(BigDecimal id) throws GPAServeisServiceException;

	/**
	 * Consultar dades procediment per codi.
	 *
	 * @param codiProcediment
	 *            the codi procediment
	 * @return the procediments RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ProcedimentsRDTO consultarDadesProcedimentPerCodi(String codiProcediment) throws GPAServeisServiceException;

	/**
	 * Consultar relacionats procediment.
	 *
	 * @param id the id
	 * @return the list
	 * @throws GPAServeisServiceException 
	 */
	ProcedimentsRDTO consultarRelacionatsProcediment(BigDecimal id) throws GPAServeisServiceException;
}
