package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.expedients.AvisosCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRetornarTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfPersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaObtenirXmlExpedient;

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
	 * Crear registre solicitud expedient.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @param tipusDocVinculada
	 * @return the resposta crear registre solicitud expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaCrearRegistreExpedient crearRegistre(ExpedientsRegistrarBDTO expedientsRegistrarBDTO, BigDecimal tipusDocVinculada)
			throws GPAServeisServiceException;

	/**
	 * Canviar estat accio expedient.
	 *
	 * @param expedientsCanviarEstatAccioBDTO
	 *            the expedients canviar estat accio BDTO
	 * @return the resposta canviar estat accio expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaCanviarEstatAccioExpedient canviarEstatAccioExpedient(ExpedientsCanviarEstatAccioBDTO expedientsCanviarEstatAccioBDTO)
			throws GPAServeisServiceException;

	/**
	 * Crear comentari accio.
	 *
	 * @param comentarisCrearAccioBDTO
	 *            the comentaris crear accio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void crearComentariAccio(ComentarisCrearAccioBDTO comentarisCrearAccioBDTO) throws GPAServeisServiceException;

	/**
	 * Crear avis accio.
	 *
	 * @param avisosCrearAccioBDTO
	 *            the avisos crear accio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void crearAvisAccio(AvisosCrearAccioBDTO avisosCrearAccioBDTO) throws GPAServeisServiceException;

	/**
	 * Crear data xml expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the string
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaObtenirXmlExpedient crearDataXmlExpedient(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Convidar tramitar expedient.
	 *
	 * @param expedientsConvidarTramitarBDTO
	 *            the expedients convidar tramitar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void convidarTramitarExpedient(ExpedientsConvidarTramitarBDTO expedientsConvidarTramitarBDTO) throws GPAServeisServiceException;

	/**
	 * Retornar tramitacio expedient.
	 *
	 * @param expedientsRetornarTramitacioBDTO
	 *            the expedients retornar tramitacio BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void retornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO expedientsRetornarTramitacioBDTO) throws GPAServeisServiceException;

	/**
	 * Registre documentacio ariadna.
	 *
	 * @param registreDocumentacioExpedient
	 *            the registre documentacio expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void registreDocumentacioAriadna(RegistreDocumentacioExpedient registreDocumentacioExpedient) throws GPAServeisServiceException;

	/**
	 * Canviar unitat gestora expedient.
	 *
	 * @param expedientsCanviarUnitatGestoraBDTO
	 *            the expedients canviar unitat gestora BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void canviarUnitatGestoraExpedient(ExpedientsCanviarUnitatGestoraBDTO expedientsCanviarUnitatGestoraBDTO)
			throws GPAServeisServiceException;

	/**
	 * Consultar dades registre assentament.
	 *
	 * @param codi
	 *            the codi
	 * @return the registre assentament RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RegistreAssentamentRDTO consultarDadesRegistreAssentament(String codi) throws GPAServeisServiceException;

	/**
	 * Gets the id expedient by documentacio id ext.
	 *
	 * @param documentacio
	 *            the documentacio
	 * @return the id expedient by documentacio id ext
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	BigDecimal getIdExpedientByDocumentacioIdExt(BigDecimal documentacio) throws GPAServeisServiceException;
}
