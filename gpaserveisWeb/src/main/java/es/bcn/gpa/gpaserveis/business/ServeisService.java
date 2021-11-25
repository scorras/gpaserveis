package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;

import es.bcn.gpa.gpaserveis.business.dto.audit.AuditServeisBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearRequerimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocsAssociatsIntraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentTramitacioFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarRequerimentFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.AnotarOperacioComptableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ComentarisCrearAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentGeneratRegistrarComunicatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarEstatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsConvidarTramitarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRedireccionarAssentamentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsReprendreBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRetornarTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsTornarEnrereBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.GestionarAvisosPerAccioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.InscriureEnRegistreBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ObtenirPerInteroperabilitatBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.ProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioRequeritsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaProcedimentsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.sollicituds.SollicitudsCrearBDTO;
import es.bcn.gpa.gpaserveis.business.dto.tramits.TramitsOvtCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.unitatsgestores.UnitatsGestoresCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConsultarSignaturaResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DadesSignatura;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsDigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentMassiu;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaPlantillaDocVinculada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarCriptograficaDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarPortasignaturesDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegellDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTabletDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocument;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarValidDocumentResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.MunicipisRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PageDataOfExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaisosRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ProvinciesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreDocumentacioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCanviarEstatAccioExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaInteroperabilitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornTramitacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudActualitzarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.TipusViesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PageDataOfDadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsOrganigramaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UsuarisRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn0.EsBcnMciSignaturaWebServiceSchemasTicketType;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds.SollicitudConsultaRDTO;

/**
 * The Interface ServeisPortalService.
 */
public interface ServeisService {

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
	 * Consultar dades unitat gestora.
	 *
	 * @param idUnitatGestora
	 *            the id unitat gestora
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	UnitatsGestoresRDTO consultarDadesUnitatGestora(BigDecimal idUnitatGestora) throws GPAServeisServiceException;

	/**
	 * Consultar dades unitat gestora.
	 *
	 * @param unitatsGestoresCercaBDTO
	 *            the unitats gestores cerca BDTO
	 * @return the unitats gestores RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	UnitatsGestoresRDTO consultarDadesUnitatGestora(UnitatsGestoresCercaBDTO unitatsGestoresCercaBDTO) throws GPAServeisServiceException;

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
	 * Cerca dades operacio requerits.
	 *
	 * @param dadesOperacioCercaBDTO
	 *            the dades operacio cerca BDTO
	 * @return the resposta dades operacio requerits cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaDadesOperacioRequeritsCercaBDTO cercaDadesOperacioRequerits(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)
	        throws GPAServeisServiceException;

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
	 * Cerca configuracio documentacio tramitacio.
	 *
	 * @param documentsTramitacioCercaBDTO
	 *            the documents tramitacio cerca BDTO
	 * @return the resposta documents tramitacio cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaDocumentsTramitacioCercaBDTO cercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO)
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
	 * Consultar dades sollicitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param visibilitat
	 *            the visibilitat persona
	 * @return the dades sollicitud BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesSollicitudBDTO consultarDadesSollicitud(BigDecimal idSollicitud, BigDecimal visibilitat) throws GPAServeisServiceException;

	/**
	 * Consultar dades sollicitud per visibilitat.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @return the dades sollicitud BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesSollicitudBDTO consultarDadesSollicitudPerVisibilitat(BigDecimal idSollicitud) throws GPAServeisServiceException;

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
	 * Consultar dades basiques per visibilitat expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesBasiquesPerVisibilitatExpedient(String codiExpedient) throws GPAServeisServiceException;

	/**
	 * Consultar dades expedient.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @param visibilitat
	 *            the visibilitat persona
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesExpedient(BigDecimal idExpedient, BigDecimal visibilitat) throws GPAServeisServiceException;

	/**
	 * Consultar dades expedient.
	 *
	 * @param codiExpedient
	 *            the codi expedient
	 * @param visibilitat
	 *            the visibilitat persona
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesExpedient(String codiExpedient, BigDecimal visibilitat) throws GPAServeisServiceException;

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
	 * Crear document entrada.
	 *
	 * @param crearDocumentEntradaBDTO
	 *            the crear document entrada BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO crearDocumentEntrada(CrearDocumentEntradaBDTO crearDocumentEntradaBDTO) throws GPAServeisServiceException;

	/**
	 * Crear declaracio responsable.
	 *
	 * @param crearDeclaracioResponsableBDTO
	 *            the crear declaracio responsable BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO crearDeclaracioResponsable(CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Crear document tramitacio.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO crearDocumentTramitacio(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO) throws GPAServeisServiceException;

	/**
	 * Actualitzar document entrada.
	 *
	 * @param actualitzarDocumentEntradaBDTO
	 *            the actualitzar document entrada BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO actualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Actualitzar declaracio responsable.
	 *
	 * @param actualitzarDeclaracioResponsableBDTO
	 *            the actualitzar declaracio responsable BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO actualitzarDeclaracioResponsable(ActualitzarDeclaracioResponsableBDTO actualitzarDeclaracioResponsableBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Actualitzar document tramitacio.
	 *
	 * @param actualitzarDocumentTramitacioBDTO
	 *            the actualitzar document tramitacio BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO actualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Guardar document entrada fitxer.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Guardar document entrada gestor documental.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO guardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Guardar document entrada escanejat gestor documental.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO guardarDocumentEntradaEscanejatGestorDocumental(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO)
	        throws GPAServeisServiceException;;

	/**
	 * Guardar document sollicitud signat.
	 *
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @param signaturaSolicitud
	 *            the signatura solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void guardarDocumentSollicitudSignat(BigDecimal documentacioIdext, BigDecimal signaturaSolicitud) throws GPAServeisServiceException;

	/**
	 * Guardar document tramitacio fitxer.
	 *
	 * @param guardarDocumentTramitacioFitxerBDTO
	 *            the guardar document tramitacio fitxer BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO guardarDocumentTramitacioFitxer(GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Consultar dades document.
	 *
	 * @param idDocument
	 *            the id document
	 * @return the docs RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsRDTO consultarDadesDocument(BigDecimal idDocument) throws GPAServeisServiceException;

	/**
	 * Consultar dades document aportat.
	 *
	 * @param idDocument
	 *            the id document
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal idDocument) throws GPAServeisServiceException;

	/**
	 * Consultar dades document aportat per codi CSV.
	 *
	 * @param csvDocument
	 *            the csv document
	 * @param visibilitat
	 *            the visibilitat persona
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO consultarDadesDocumentAportatPerCodiCSV(String csvDocument, BigDecimal visibilitat) throws GPAServeisServiceException;

	/**
	 * Consultar dades document generat.
	 *
	 * @param idDocument
	 *            the id document
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO consultarDadesDocumentGenerat(BigDecimal idDocument) throws GPAServeisServiceException;

	/**
	 * Consultar dades document generat per codi CSV.
	 *
	 * @param csvDocument
	 *            the csv document
	 * @param visibilitat
	 *            the visibilitat persona
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO consultarDadesDocumentGeneratPerCodiCSV(String csvDocument, BigDecimal visibilitat)
	        throws GPAServeisServiceException;

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
	 * Descarregar document expedient signat.
	 *
	 * @param idUltimaSignatura
	 *            the id ultima signatura
	 * @return the byte[]
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	byte[] descarregarDocumentExpedientSignat(BigDecimal idUltimaSignatura) throws GPAServeisServiceException;

	/**
	 * Crear registre solicitud expedient.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @param tipusDocVinculada
	 *            the tipus doc vinculada
	 * @return the resposta crear registre solicitud expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaCrearRegistreExpedient crearRegistre(ExpedientsRegistrarBDTO expedientsRegistrarBDTO, BigDecimal tipusDocVinculada)
	        throws GPAServeisServiceException;

	/**
	 * Crear registre solicitud.
	 *
	 * @param expedientsRegistrarSollicitudBDTO
	 *            the expedients registrar Sollicitud BDTO
	 * @param tipusDocVinculada
	 *            the tipus doc vinculada
	 * @return the resposta crear registre solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaCrearRegistreExpedient crearRegistreSollicitud(ExpedientsRegistrarSollicitudBDTO expedientsRegistrarSollicitudBDTO,
	        BigDecimal tipusDocVinculada) throws GPAServeisServiceException;

	/**
	 * Redireccionar registre.
	 *
	 * @param expedientsRedireccionarAssentamentBDTO
	 *            the expedients redireccionar assentament BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void redireccionarRegistre(ExpedientsRedireccionarAssentamentBDTO expedientsRedireccionarAssentamentBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Canviar estat expedient.
	 *
	 * @param expedientsCanviarEstatBDTO
	 *            the expedients canviar estat BDTO
	 * @return the resposta canviar estat expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaCanviarEstatAccioExpedient canviarEstatExpedient(ExpedientsCanviarEstatBDTO expedientsCanviarEstatBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Crear comentari accio.
	 *
	 * @param comentarisCrearAccioBDTO
	 *            the comentaris crear accio BDTO
	 * @return the integer
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	Integer crearComentariAccio(ComentarisCrearAccioBDTO comentarisCrearAccioBDTO) throws GPAServeisServiceException;

	/**
	 * Revisar documentacio entrada.
	 *
	 * @param documentAportatValidarBDTO
	 *            the document aportat validar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void revisarDocumentacioEntrada(DocumentAportatValidarBDTO documentAportatValidarBDTO) throws GPAServeisServiceException;

	/**
	 * Crear xml dades sollicitud.
	 *
	 * @param sollicitudConsultaRDTO
	 *            the sollicitud consulta RDTO
	 * @return the string
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	String crearXmlDadesSollicitud(SollicitudConsultaRDTO sollicitudConsultaRDTO) throws GPAServeisServiceException;

	/**
	 * Gets the plantilla doc vinculada.
	 *
	 * @param idConfDoc
	 *            the id conf doc
	 * @param idDocVinculada
	 *            the id doc vinculada
	 * @return the plantilla doc vinculada
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaPlantillaDocVinculada getPlantillaDocVinculada(BigDecimal idConfDoc, BigDecimal idDocVinculada)
	        throws GPAServeisServiceException;

	/**
	 * Associar registre sollicitud.
	 *
	 * @param sollicitudActualitzarRegistre
	 *            the sollicitud actualitzar registre
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void associarRegistreSollicitud(SollicitudActualitzarRegistre sollicitudActualitzarRegistre) throws GPAServeisServiceException;

	/**
	 * Associar registre documentacio expedient.
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void associarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO) throws GPAServeisServiceException;

	/**
	 * Associar registre docs ent.
	 *
	 * @param docsEntActualizarRegistreRDTO
	 *            the docs ent actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void associarRegistreDocsEnt(DocsEntActualizarRegistre docsEntActualizarRegistreRDTO) throws GPAServeisServiceException;

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
	 * Signar validar document.
	 *
	 * @param signarPortasignaturesDocument
	 *            the signar portasignatures document
	 * @return the peticions portasig
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PeticionsPortasig signarValidarDocument(SignarPortasignaturesDocument signarPortasignaturesDocument) throws GPAServeisServiceException;

	/**
	 * Signar segell document.
	 *
	 * @param signarSegellDocumentRDTO
	 *            the signar segell document RDTO
	 * @return the signar segell documents id
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	SignarSegellDocument signarSegellDocument(SignarSegellDocument signarSegellDocumentRDTO) throws GPAServeisServiceException;

	/**
	 * Signar valid document.
	 *
	 * @param signarValidDocumentRDTO
	 *            the signar valid document RDTO
	 * @return the signar valid document response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	SignarValidDocumentResponse signarValidDocument(SignarValidDocument signarValidDocumentRDTO) throws GPAServeisServiceException;

	/**
	 * Signar tablet document.
	 *
	 * @param signarTabletlDocumentRDTO
	 *            the signar tabletl document RDTO
	 * @return the signar tablet documents response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	SignarTabletDocumentResponse signarTabletDocument(SignarTabletDocument signarTabletlDocumentRDTO) throws GPAServeisServiceException;

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
	 * @return the retorn tramitacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RetornTramitacio retornarTramitacioExpedient(ExpedientsRetornarTramitacioBDTO expedientsRetornarTramitacioBDTO)
	        throws GPAServeisServiceException;

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
	 * Guardar requeriment fitxer.
	 *
	 * @param guardarRequerimentFitxerBDTO
	 *            the guardar requeriment fitxer BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO guardarRequerimentFitxer(GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Guardar requeriment plantilla.
	 *
	 * @param crearRequerimentBDTO
	 *            the crear requeriment BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO guardarRequerimentPlantilla(CrearRequerimentBDTO crearRequerimentBDTO) throws GPAServeisServiceException;

	/**
	 * Acumular expedient.
	 *
	 * @param expedientsAcumularBDTO
	 *            the expedients acumular BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void acumularExpedient(ExpedientsAcumularBDTO expedientsAcumularBDTO) throws GPAServeisServiceException;

	/**
	 * Cerca expedients acumulats.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<ExpedientsRDTO> cercaExpedientsAcumulats(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Actualitzar dades altra persona implicada.
	 *
	 * @param personesSollicitudRDTO
	 *            the persones sollicitud RDTO
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<PersonesSollicitudRDTO> actualitzarDadesAltraPersonaImplicada(PersonesSollicitudRDTO personesSollicitudRDTO)
	        throws GPAServeisServiceException;

	/**
	 * Obtenir docs tramitacio by notification id.
	 *
	 * @param notificacioId
	 *            the notificacio id
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO obtenirDocsTramitacioByNotificationId(Long notificacioId) throws GPAServeisServiceException;

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

	/**
	 * Crear notificacio.
	 *
	 * @param documentCrearNotificacioBDTO
	 *            the document crear notificacio BDTO
	 * @return the notificacions RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	NotificacionsRDTO crearNotificacio(DocumentCrearNotificacioBDTO documentCrearNotificacioBDTO) throws GPAServeisServiceException;

	/**
	 * Callback notificacio.
	 *
	 * @param actualitzarNotificacio
	 *            the actualitzar notificacio
	 * @param docEvidenciaElectronic
	 *            the doc evidencia electronic
	 * @param docEvidenciaPaper
	 *            the doc evidencia paper
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void callbackNotificacio(ActualitzarNotificacioBDTO actualitzarNotificacio, MultipartFile docEvidenciaElectronic,
	        MultipartFile docEvidenciaPaper) throws GPAServeisServiceException;

	/**
	 * Tancar requeriments expedient.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void tancarRequerimentsExpedient(BigDecimal idDocumentacio) throws GPAServeisServiceException;

	/**
	 * Callback porta sig.
	 *
	 * @param callbackPortaSig
	 *            the callback porta sig
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void callbackPortaSig(CallbackPortaSig callbackPortaSig) throws GPAServeisServiceException;

	/**
	 * Guardar document tramitacio plantilla.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO guardarDocumentTramitacioPlantilla(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Guardar document tramitacio justificant plantilla.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO guardarDocumentTramitacioJustificantPlantilla(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Crear document entrada digitalitzat.
	 *
	 * @param crearDocumentEntradaDigitalitzarBDTO
	 *            the crear document entrada digitalitzar BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO crearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO crearDocumentEntradaDigitalitzarBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Crear document tramitacio digitalitzat.
	 *
	 * @param crearDocumentTramitacioDigitalitzarBDTO
	 *            the crear document tramitacio digitalitzar BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO crearDocumentTramitacioDigitalitzat(CrearDocumentTramitacioDigitalitzarBDTO crearDocumentTramitacioDigitalitzarBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Registrar comunicat document tramitacio.
	 *
	 * @param documentGeneratRegistrarComunicatBDTO
	 *            the document generat registrar comunicat BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void registrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO documentGeneratRegistrarComunicatBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Callback digitalitzacio.
	 *
	 * @param callbackDigitalitzacio
	 *            the callback digitalitzacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void callbackDigitalitzacio(CallbackDigitalitzacio callbackDigitalitzacio) throws GPAServeisServiceException;

	/**
	 * Obtenir expedients relacionats.
	 *
	 * @param idExpedient
	 *            the id expedient
	 * @return the page data of expedients RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfExpedientsRDTO obtenirExpedientsRelacionats(BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Associats docs intra.
	 *
	 * @param docsAssociatsIntraBDTO
	 *            the docs associats intra
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void associatsDocsIntra(DocsAssociatsIntraBDTO docsAssociatsIntraBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar dades basiques expedient by id documentacio.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the dades expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesExpedientBDTO consultarDadesBasiquesExpedientByIdDocumentacio(BigDecimal idDocumentacio) throws GPAServeisServiceException;

	/**
	 * Actualitzar requeriment.
	 *
	 * @param crearRequerimentBDTO
	 *            the crear requeriment BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO actualitzarRequeriment(CrearRequerimentBDTO crearRequerimentBDTO) throws GPAServeisServiceException;

	/**
	 * Anotar operacio comptable.
	 *
	 * @param anotarOperacioComptableBDTO
	 *            the anotar operacio comptable BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void anotarOperacioComptable(AnotarOperacioComptableBDTO anotarOperacioComptableBDTO) throws GPAServeisServiceException;

	/**
	 * Inscriure en registre.
	 *
	 * @param inscriureEnRegistreBDTO
	 *            the inscriure en registre BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void inscriureEnRegistre(InscriureEnRegistreBDTO inscriureEnRegistreBDTO) throws GPAServeisServiceException;

	/**
	 * Es borrar documentacio entrada.
	 *
	 * @param esborrarDocumentBDTO
	 *            the esborrar document BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esBorrarDocumentacioEntrada(EsborrarDocumentBDTO esborrarDocumentBDTO) throws GPAServeisServiceException;

	/**
	 * Es borrar documentacio tramitacio.
	 *
	 * @param esborrarDocumentBDTO
	 *            the esborrar document BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esBorrarDocumentacioTramitacio(EsborrarDocumentBDTO esborrarDocumentBDTO) throws GPAServeisServiceException;

	/**
	 * obtenir l'aneu accion estat a partir de l'estat actual i la accion.
	 *
	 * @param idAccio
	 *            the id accio
	 * @param idEstatActual
	 *            the id estat actual
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 * @throws RestClientException
	 *             the rest client exception
	 */
	List<AccionsEstatsRDTO> cercaTransicioCanviEstat(BigDecimal idAccio, BigDecimal idEstatActual) throws GPAServeisServiceException;

	/**
	 * Canviar estat expedient. Esborrar registre solicitud expedient.
	 *
	 * @param expedientsRegistrarBDTO
	 *            the expedients registrar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esborrarRegistre(ExpedientsRegistrarBDTO expedientsRegistrarBDTO) throws GPAServeisServiceException;

	/**
	 * Esborrar registre solicitud.
	 *
	 * @param expedientsRegistrarSollicitudBDTO
	 *            the expedients registrar sollicitud BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esborrarRegistreSollicitud(ExpedientsRegistrarSollicitudBDTO expedientsRegistrarSollicitudBDTO) throws GPAServeisServiceException;

	/**
	 * Desassociar registre documentacio expedient.
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void desassociarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO)
	        throws GPAServeisServiceException;

	/**
	 * Comprovar documents signats expedient.
	 *
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @return the boolean
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	Boolean comprovarDocumentsSignatsExpedient(BigDecimal documentacioIdext) throws GPAServeisServiceException;

	/**
	 * Esborra comentari.
	 *
	 * @param idComentari
	 *            the id Comentari
	 * @param idExpedient
	 *            the id expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esborrarComentari(BigDecimal idComentari, BigDecimal idExpedient) throws GPAServeisServiceException;

	/**
	 * Obrir requeriments expedient.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void obrirRequerimentsExpedient(BigDecimal idDocumentacio) throws GPAServeisServiceException;

	/**
	 * Tornar enrere expedient.
	 *
	 * @param expedientsTornarEnrereBDTO
	 *            the expedients tornar enrere BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void tornarEnrereExpedient(ExpedientsTornarEnrereBDTO expedientsTornarEnrereBDTO) throws GPAServeisServiceException;

	/**
	 * Obtenir per interoperabilitat.
	 *
	 * @param obtenirPerInteroperabilitatBDTO
	 *            the obtenir per interoperabilitat BDTO
	 * @return the resposta interoperabilitat
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaInteroperabilitat obtenirPerInteroperabilitat(ObtenirPerInteroperabilitatBDTO obtenirPerInteroperabilitatBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Consultar estat digitalitzacio.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @return the peticions digitalitzacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PeticionsDigitalitzacioRDTO consultarEstatDigitalitzacio(String idPeticio) throws GPAServeisServiceException;

	/**
	 * Crear sollicitud.
	 *
	 * @param sollicitudCrearBDTO
	 *            the sollicitud crear BDTO
	 * @return the sollicituds RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	SollicitudsRDTO crearSollicitud(SollicitudsCrearBDTO sollicitudCrearBDTO) throws GPAServeisServiceException;

	/**
	 * Update sollicitud.
	 *
	 * @param sollicitudRDTO
	 *            the sollicitud RDTO
	 * @return the sollicituds RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	SollicitudsRDTO updateSollicitud(SollicitudsRDTO sollicitudRDTO) throws GPAServeisServiceException;

	/**
	 * Actualitzar dades sollicitud sollicituds.
	 *
	 * @param sollicitudsActualitzarBDTO
	 *            the sollicituds actualitzar BDTO
	 * @return the sollicituds RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	SollicitudsRDTO actualitzarDadesSollicitudSollicituds(SollicitudsActualitzarBDTO sollicitudsActualitzarBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Guardar dades especifiques sollicitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void guardarDadesEspecifiquesSollicitud(BigDecimal idSollicitud) throws GPAServeisServiceException;

	/**
	 * Cerca sollicituds.
	 *
	 * @param sollicitudsCercaBDTO
	 *            the sollicituds cerca BDTO
	 * @return the resposta sollicituds cerca BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	RespostaSollicitudsCercaBDTO cercaSollicituds(SollicitudsCercaBDTO sollicitudsCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Guardar xml sollicitud.
	 *
	 * @param idDocumentum
	 *            the id documentum
	 * @param xmlSolicitud
	 *            the xml solicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void guardarXmlSollicitud(String idDocumentum, String xmlSolicitud) throws GPAServeisServiceException;

	/**
	 * Consultar tipus vies by codi.
	 *
	 * @param codi
	 *            the codi
	 * @return the tipus vies RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	TipusViesRDTO consultarTipusViesByCodi(String codi) throws GPAServeisServiceException;

	/**
	 * Consultar paisos by codi.
	 *
	 * @param codi
	 *            the codi
	 * @return the paisos RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PaisosRDTO consultarPaisosByCodi(String codi) throws GPAServeisServiceException;

	/**
	 * Consultar provincies by codi.
	 *
	 * @param codi
	 *            the codi
	 * @return the provincies RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ProvinciesRDTO consultarProvinciesByCodi(String codi) throws GPAServeisServiceException;

	/**
	 * Consultar municipis by codi.
	 *
	 * @param codiMunicipi
	 *            the codi municipi
	 * @param codiProvincia
	 *            the codi provincia
	 * @return the municipis RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	MunicipisRDTO consultarMunicipisByCodi(String codiMunicipi, String codiProvincia) throws GPAServeisServiceException;

	/**
	 * Consultar dades signatura by codi peticio.
	 *
	 * @param codiPeticio
	 *            the codi peticio
	 * @return the dades signatura
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DadesSignatura consultarDadesSignaturaByCodiPeticio(String codiPeticio) throws GPAServeisServiceException;

	/**
	 * Actualitzar expedient.
	 *
	 * @param expedientsRDTO the expedients RDTO
	 * @throws GPAServeisServiceException             the GPA serveis service exception
	 */
	void actualitzarExpedient(ExpedientsRDTO expedientsRDTO) throws GPAServeisServiceException;

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

	/**
	 * Peticio amb documents signats.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @return the boolean
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	Boolean peticioAmbDocumentsSignats(String idPeticio) throws GPAServeisServiceException;

	/**
	 * Finalitzar signatura tablet.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void finalitzarSignaturaTablet(String idPeticio) throws GPAServeisServiceException;

	/**
	 * Incrementar reintents signatura.
	 *
	 * @param idDocument
	 *            the idDocument to increment
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void incrementarReintentsSignatura(BigDecimal idDocument) throws GPAServeisServiceException;

	/**
	 * Consultar dades persona sollicitud.
	 *
	 * @param idPersona
	 *            the id persona
	 * @return the persones sollicitud RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PersonesSollicitudRDTO consultarDadesPersonaSollicitud(BigDecimal idPersona) throws GPAServeisServiceException;

	/**
	 * Esborrar persona sollicitud.
	 *
	 * @param idPersonesSollicitud
	 *            the id persones sollicitud
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esborrarPersonaSollicitud(BigDecimal idPersonesSollicitud) throws GPAServeisServiceException;

	/**
	 * Incorporar Tercera Persona.
	 *
	 * @param personesSollicitudRDTO the persones sollicitud RDTO
	 * @return the PersonesSollicitud RDTO
	 * @throws GPAServeisServiceException             the GPA serveis service exception
	 */
	PersonesSollicitudRDTO incorporarTerceraPersona(PersonesSollicitudRDTO personesSollicitudRDTO) throws GPAServeisServiceException;

	/**
	 * Preparar signatura criptografica document.
	 *
	 * @param prepararSignaturaCriptograficaDocumentMassiu
	 *            the preparar signatura criptografica document massiu
	 * @return the preparar signatura criptografica document response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptograficaDocument(
	        PrepararSignaturaCriptograficaDocumentMassiu prepararSignaturaCriptograficaDocumentMassiu) throws GPAServeisServiceException;

	/**
	 * Signar criptografica document.
	 *
	 * @param signarCriptograficaDocument
	 *            the signar criptografica document
	 * @return the signar criptografica document response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	SignarCriptograficaDocumentResponse signarCriptograficaDocument(SignarCriptograficaDocument signarCriptograficaDocument)
	        throws GPAServeisServiceException;

	/**
	 * Consultar dades document generat per id gestor documental.
	 *
	 * @param idDocumentGestorDocumental
	 *            the id document gestor documental
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO consultarDadesDocumentGeneratPerIdGestorDocumental(String idDocumentGestorDocumental)
	        throws GPAServeisServiceException;

	/**
	 * Parses the mci signatures ticket.
	 *
	 * @param ticket
	 *            the ticket
	 * @return the es bcn mci signatura web service schemas ticket type
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	EsBcnMciSignaturaWebServiceSchemasTicketType parseMciSignaturesTicket(String ticket) throws GPAServeisServiceException;

	/**
	 * Obtenir persona expedient by document identitat.
	 *
	 * @param dadesExpedientBDTO the dades expedient BDTO
	 * @param documentUsuari the document usuari
	 * @return the persones
	 * @throws GPAServeisServiceException the GPA serveis service exception
	 */
	Persones obtenirPersonaExpedientByDocumentIdentitat(DadesExpedientBDTO dadesExpedientBDTO, String documentUsuari)
	        throws GPAServeisServiceException;

	/**
	 * Registrar auditoria de Serveis Tramitadors.
	 *
	 * @param auditServeisBDTO the audit serveis BDTO
	 * @throws GPAServeisServiceException             the GPA serveis service exception
	 */
	void registrarAuditServeisTramitadors(AuditServeisBDTO auditServeisBDTO) throws GPAServeisServiceException;

	/**
	 * Reprendre tramitacio.
	 *
	 * @param expedientsReprendreBDTO
	 *            the expedients reprendre BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void reprendreTramitacio(ExpedientsReprendreBDTO expedientsReprendreBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar signatura.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @param idDocumentGestorDocumental
	 *            the id document gestor documental
	 * @return the consultar signatura response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	ConsultarSignaturaResponse consultarSignatura(String idPeticio, String idDocumentGestorDocumental) throws GPAServeisServiceException;

	/**
	 * Gestionar avisos per accio.
	 *
	 * @param gestionarAvisosPerAccioBDTO the gestionar avisos per accio BDTO
	 * @throws GPAServeisServiceException the GPA serveis service exception
	 */
	void gestionarAvisosPerAccio(GestionarAvisosPerAccioBDTO gestionarAvisosPerAccioBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar procediments relacionats.
	 *
	 * @param id the id
	 * @return the procediment BDTO
	 * @throws GPAServeisServiceException 
	 */
	ProcedimentsRDTO consultarProcedimentsRelacionats(BigDecimal id) throws GPAServeisServiceException;
	PageDataOfDadesGrupsRDTO cercaAtributsProcediment(DadesOperacioCercaBDTO dadesOperacioCercaBDTO)throws GPAServeisServiceException;

	List<ProcedimentsRDTO> consultarProcedimentsRelacionats(BigDecimal id) throws GPAServeisServiceException;

}
