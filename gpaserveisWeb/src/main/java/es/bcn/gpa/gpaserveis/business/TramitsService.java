package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;

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

	/**
	 * Consultar dades tramit ovt.
	 *
	 * @param idTramitOvt
	 *            the id tramit ovt
	 * @return the tramits ovt RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	TramitsOvtRDTO consultarDadesTramitOvt(BigDecimal idTramitOvt) throws GPAServeisServiceException;
}
