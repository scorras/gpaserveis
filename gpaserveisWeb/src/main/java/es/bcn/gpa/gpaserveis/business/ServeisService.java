package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.documents.AportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.SubstituirDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.UploadDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.AvisosCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaUploadDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreSolicitudExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;

/**
 * The Interface ServeisPortalService.
 */
public interface ServeisService {

	/**
	 * Cerca procediments.
	 *
	 * @param procedimentsCercaBDTO
	 *            the procediments cerca BDTO
	 * @return the resposta procediments cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaProcedimentsCercaBDTO cercaProcediments(ProcedimentsCercaBDTO procedimentsCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Cerca unitats gestores.
	 *
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<UnitatsGestoresRDTO> cercaUnitatsGestores(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Consulta dades unitat gestora.
	 *
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	UnitatsGestoresRDTO consultaDadesUnitatGestora(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar dades basiques procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesProcedimentBDTO consultarDadesBasiquesProcediment(BigDecimal idProcediment) throws GPAServeisServiceException;

	/**
	 * Consultar dades procediment.
	 *
	 * @param idProcediment
	 *            the id procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesProcedimentBDTO consultarDadesProcediment(BigDecimal idProcediment) throws GPAServeisServiceException;

	/**
	 * Consultar dades procediment.
	 *
	 * @param codiProcediment
	 *            the codi procediment
	 * @return the dades procediment BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesProcedimentBDTO consultarDadesProcediment(String codiProcediment) throws GPAServeisServiceException;

	/**
	 * Consultar dades tramit ovt.
	 *
	 * @param tramitsOvtCercaBDTO
	 *            the tramits ovt cerca BDTO
	 * @return the es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.
	 *         tramits ovt RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO consultarDadesTramitOvt(TramitsOvtCercaBDTO tramitsOvtCercaBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Cerca dades operacio.
	 *
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the resposta dades operacio cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaDadesOperacioCercaBDTO cercaDadesOperacio(DadesOperacioCercaBDTO dadesOperacioCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Cerca configuracio documentacio entrada.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the resposta documents entrada cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaDocumentsEntradaCercaBDTO cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Cerca configuracio documentacio entrada per tramit ovt.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the resposta documents entrada cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaDocumentsEntradaCercaBDTO cercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Cerca expedients.
	 *
	 * @param expedientsCercaBDTO
	 *            the expedients cerca BDTO
	 * @return the resposta expedients cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaExpedientsCercaBDTO cercaExpedients(ExpedientsCercaBDTO expedientsCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar dades basiques expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesBasiquesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Consultar dades basiques expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesBasiquesExpedient(String codiExpedient) throws GPAServeisServiceException;

	/**
	 * Consultar dades expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesExpedient(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Consultar dades expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesExpedient(String codiExpedient) throws GPAServeisServiceException;

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
	 * Cerca accions possibles.
	 *
	 * @param idAccioEstat
	 *            the id accio estat
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<AccionsEstatsRDTO> cercaAccionsPossibles(BigDecimal idAccioEstat) throws GPAServeisServiceException;

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
	 * Aportar documentacio expedient.
	 *
	 * @param aportarDocumentExpedientBDTO
	 *            the aportar document expedient BDTO
	 * @return the resposta aportar documentacio expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaAportarDocumentacioExpedientRDTO aportarDocumentacioExpedient(AportarDocumentExpedientBDTO aportarDocumentExpedientBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Substituir document expedient.
	 *
	 * @param substituirDocumentExpedientBDTO
	 *            the substituir document expedient BDTO
	 * @return the resposta substituir document expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaSubstituirDocumentExpedientRDTO substituirDocumentExpedient(SubstituirDocumentExpedientBDTO substituirDocumentExpedientBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Consultar dades document aportat.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Esborrar document expedient.
	 *
	 * @param esborrarDocumentExpedientBDTO
	 *            the esborrar document expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO esborrarDocumentExpedientBDTO) throws GPAServeisServiceException;

	/**
	 * Descarregar document expedient.
	 *
	 * @param descarregarDocumentExpedientBDTO
	 *            the descarregar document expedient BDTO
	 * @return the byte[]
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	byte[] descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Upload document expedient.
	 *
	 * @param uploadDocumentExpedientBDTO
	 *            the upload document expedient BDTO
	 * @return the resposta upload document expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaUploadDocumentExpedient uploadDocumentExpedient(UploadDocumentExpedientBDTO uploadDocumentExpedientBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Crear registre solicitud expedient.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @return the resposta crear registre solicitud expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaCrearRegistreSolicitudExpedient crearRegistreSolicitudExpedient(ExpedientsRegistrarBDTO expedientsRegistrarBDTO)
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

	// TODO Peticiones ligeras
	// /**
	// * Abandonar expedient.
	// *
	// * @param expedientsAbandonarBDTO
	// * the expedients abandonar BDTO
	// * @return the resposta abandonar expedient
	// * @throws GPAServeisServiceException
	// * the GPA serveis service exception
	// */
	// RespostaAbandonarExpedient abandonarExpedient(ExpedientsAbandonarBDTO
	// expedientsAbandonarBDTO) throws GPAServeisServiceException;
	// TODO Peticiones ligeras
	// /**
	// * Validar solicitud expedient.
	// *
	// * @param expedientsValidarBDTO
	// * the expedients validar BDTO
	// * @return the resposta validar expedient
	// * @throws GPAServeisServiceException
	// * the GPA serveis service exception
	// */
	// RespostaValidarExpedient validarSolicitudExpedient(ExpedientsValidarBDTO
	// expedientsValidarBDTO) throws GPAServeisServiceException;

}
