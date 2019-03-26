package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsAbandonarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaAbandonarExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaRegistrarSolicitudExpedient;

/**
 * The Interface ExpedientsService.
 */
public interface ExpedientsService {

	/**
	 * Cerca expedients.
	 *
	 * @param expedientsCercaBDTO
	 *            the expedients cerca BDTO
	 * @return the page data of expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfExpedientsRDTO cercaExpedients(ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar dades expedient.
	 *
	 * @param id
	 *            the id
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ExpedientsRDTO consultarDadesExpedient(BigDecimal id) throws GPAServeisServiceException;

	/**
	 * Consultar dades expedient per codi.
	 *
	 * @param codi
	 *            the codi
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ExpedientsRDTO consultarDadesExpedientPerCodi(String codi) throws GPAServeisServiceException;

	/**
	 * Cerca historics estats expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<EstatsRDTO> cercaHistoricsEstatsExpedient(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Cerca persones interesades expedient.
	 *
	 * @param idSolicitud
	 *            the id solicitud
	 * @return the page data of persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfPersonesSollicitudRDTO cercaPersonesInteresadesExpedient(BigDecimal idSolicitud) throws GPAServeisServiceException;

	/**
	 * Cerca altres persones implicades expedient.
	 *
	 * @param idSolicitud
	 *            the id solicitud
	 * @return the page data of persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfPersonesSollicitudRDTO cercaAltresPersonesImplicadesExpedient(BigDecimal idSolicitud) throws GPAServeisServiceException;

	/**
	 * Cerca dades especifiques expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<DadesEspecifiquesRDTO> cercaDadesEspecifiquesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Crear sollicitud expedient.
	 *
	 * @param expedientsCrearBDTO
	 *            the expedients crear BDTO
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ExpedientsRDTO crearSollicitudExpedient(ExpedientsCrearBDTO expedientsCrearBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar dades pais per codi iso.
	 *
	 * @param codiIso
	 *            the codi iso
	 * @return the paisos RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PaisosRDTO consultarDadesPaisPerCodiIso(String codiIso) throws GPAServeisServiceException;

	/**
	 * Actualitzar solicitud expedient.
	 *
	 * @param expedientsActualitzarBDTO
	 *            the expedients actualitzar BDTO
	 * @return the expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ExpedientsRDTO actualitzarSolicitudExpedient(ExpedientsActualitzarBDTO expedientsActualitzarBDTO) throws GPAServeisServiceException;

	/**
	 * Registrar solicitud expedient.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @return the resposta registrar solicitud expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaRegistrarSolicitudExpedient registrarSolicitudExpedient(ExpedientsRegistrarBDTO expedientsRegistrarBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Abandonar desistir expedient.
	 *
	 * @param expedientsAbandonarBDTO
	 *            the expedients abandonar BDTO
	 * @return the resposta abandonar expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaAbandonarExpedient abandonarDesistirExpedient(ExpedientsAbandonarBDTO expedientsAbandonarBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Abandonar renunciar expedient.
	 *
	 * @param expedientsAbandonarBDTO
	 *            the expedients abandonar BDTO
	 * @return the resposta abandonar expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaAbandonarExpedient abandonarRenunciarExpedient(ExpedientsAbandonarBDTO expedientsAbandonarBDTO)
	        throws GPAServeisServiceException;
}
