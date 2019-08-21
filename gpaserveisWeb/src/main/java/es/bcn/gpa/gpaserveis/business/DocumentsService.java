package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioDigitalitzarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentEntradaFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarDocumentTramitacioFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.GuardarRequerimentFitxerBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentGeneratRegistrarComunicatBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ActualitzarNotificacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsPortasig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaPlantillaDocVinculada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument;

/**
 * The Interface DocumentsService.
 */
public interface DocumentsService {

	/**
	 * Cerca configuracio documentacio entrada.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfConfiguracioDocsEntradaRDTO cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException;

	/**
	 * Cerca configuracio documentacio entrada per tramit ovt.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfConfiguracioDocsEntradaRDTO cercaConfiguracioDocumentacioEntradaPerTramitOvt(
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Cerca configuracio documentacio tramitacio.
	 *
	 * @param documentsTramitacioCercaBDTO
	 *            the documents tramitacio cerca BDTO
	 * @return the page data of configuracio docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfConfiguracioDocsTramitacioRDTO cercaConfiguracioDocumentacioTramitacio(
	        DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO) throws GPAServeisServiceException;

	/**
	 * Cerca documents entrada agrupats per tramit ovt.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<DocsEntradaRDTO> cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio) throws GPAServeisServiceException;

	/**
	 * Cerca configuracio documentacio entrada requerida.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<ConfDocEntradaRequeritRDTO> cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal idDocumentacio)
	        throws GPAServeisServiceException;

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
	 * @param crearDocumentEntradaBDTO
	 *            the crear document entrada BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO crearDeclaracioResponsable(CrearDeclaracioResponsableBDTO crearDocumentEntradaBDTO) throws GPAServeisServiceException;

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
	 * Esborrar document expedient.
	 *
	 * @param esborrarDocumentExpedientBDTO
	 *            the esborrar document expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO esborrarDocumentExpedientBDTO) throws GPAServeisServiceException;

	/**
	 * Consultar dades document.
	 *
	 * @param idDocument
	 *            the id document
	 * @return the docs RDTO
	 */
	DocsRDTO consultarDadesDocument(BigDecimal idDocument) throws GPAServeisServiceException;

	/**
	 * Consultar dades document aportat.
	 *
	 * @param id
	 *            the id
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal id) throws GPAServeisServiceException;

	/**
	 * Consultar dades document generat.
	 *
	 * @param id
	 *            the id
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	DocsTramitacioRDTO consultarDadesDocumentGenerat(BigDecimal id) throws GPAServeisServiceException;

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
	 * Cerca dades operacio requerits.
	 *
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<BigDecimal> cercaDadesOperacioRequerits(BigDecimal documentacioIdext) throws GPAServeisServiceException;

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
	 * Signar validar document.
	 *
	 * @param signarDocument
	 *            the signar document
	 * @return the peticions portasig
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	List<PeticionsPortasig> signarValidarDocument(SignarDocument signarDocument) throws GPAServeisServiceException;

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
	 * Actualitzar notificacio.
	 *
	 * @param actualitzarNotificacionDocument
	 *            the actualitzar notificacion document
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void callbackNotificacio(ActualitzarNotificacio actualitzarNotificacio) throws GPAServeisServiceException;

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

}
