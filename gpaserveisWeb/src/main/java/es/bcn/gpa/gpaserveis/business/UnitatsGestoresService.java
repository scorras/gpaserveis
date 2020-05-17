package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.PageDataOfUnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsOrganigramaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UsuarisRDTO;

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

	/**
	 * Consultar dades usuari.
	 *
	 * @param matricula
	 *            the matricula
	 * @return the usuaris RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	UsuarisRDTO consultarDadesUsuari(String matricula) throws GPAServeisServiceException;

	/**
	 * Consultar dades unitat organigrama.
	 *
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @return the unitats organigrama RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	UnitatsOrganigramaRDTO consultarDadesUnitatOrganigrama(BigDecimal idUnitatGestora) throws GPAServeisServiceException;

}
