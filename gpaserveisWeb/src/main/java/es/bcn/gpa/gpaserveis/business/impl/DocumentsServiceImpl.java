package es.bcn.gpa.gpaserveis.business.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDeclaracioResponsableBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.ActualitzarDocumentTramitacioBDTO;
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
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentGeneratRegistrarComunicatBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.business.handler.ServeisServiceExceptionHandler;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioRequeritApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DownloadApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.NotificacionsApi;
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
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class DocumentsServiceImpl.
 */
@Service

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
@CommonsLog
public class DocumentsServiceImpl implements DocumentsService {

	/** The configuracio documentacio api. */
	@Autowired
	private ConfiguracioDocumentacioApi configuracioDocumentacioApi;

	/** The documentacio api. */
	@Autowired
	private DocumentacioApi documentacioApi;

	/** The documentacio requerit api. */
	@Autowired
	private DocumentacioRequeritApi documentacioRequeritApi;

	/** The download api. */
	@Autowired
	private DownloadApi downloadApi;

	/** The notificacions api. */
	@Autowired
	private NotificacionsApi notificacionsApi;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * cercaConfiguracioDocumentacioEntrada(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.DocumentsEntradaCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaConfiguracioDocumentacioEntrada")
	public PageDataOfConfiguracioDocsEntradaRDTO cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = configuracioDocumentacioApi
					.cercaConfiguracioDocumentacioEntrada(documentsEntradaCercaBDTO.getIdConfiguracioDocumentacio(), null, null, null, null,
							null, null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfConfiguracioDocsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio entrada.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @param e
	 *            the e
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfConfiguracioDocsEntradaRDTO fallbackCercaConfiguracioDocumentacioEntrada(
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * cercaConfiguracioDocumentacioEntradaPerTramitOvt(es.bcn.gpa.gpaserveis.
	 * business.dto.documents.DocumentsEntradaCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaConfiguracioDocumentacioEntradaPerTramitOvt")
	public PageDataOfConfiguracioDocsEntradaRDTO cercaConfiguracioDocumentacioEntradaPerTramitOvt(
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsEntradaCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = configuracioDocumentacioApi
					.cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO.getIdConfiguracioDocumentacio(),
							documentsEntradaCercaBDTO.getIdTramitOvt(), null, null, null, null, null, null, null, null, null, null, null,
							null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsEntradaCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfConfiguracioDocsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("cercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsEntradaCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio entrada per tramit ovt.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @param e
	 *            the e
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfConfiguracioDocsEntradaRDTO fallbackCercaConfiguracioDocumentacioEntradaPerTramitOvt(
			DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsEntradaCercaBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * cercaConfiguracioDocumentacioTramitacio(es.bcn.gpa.gpaserveis.business.
	 * dto.documents.DocumentsTramitacioCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaConfiguracioDocumentacioTramitacio")
	public PageDataOfConfiguracioDocsTramitacioRDTO cercaConfiguracioDocumentacioTramitacio(
			DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfConfiguracioDocsTramitacioRDTO pageDataOfConfiguracioDocsTramitacioRDTO = configuracioDocumentacioApi
					.cercaConfiguracioDocumentacioTramitacio(documentsTramitacioCercaBDTO.getIdConfiguracioDocumentacio(), null, null, null,
							null, null, null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfConfiguracioDocsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("cercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio tramitacio.
	 *
	 * @param documentsTramitacioCercaBDTO
	 *            the documents tramitacio cerca BDTO
	 * @param e
	 *            the e
	 * @return the page data of configuracio docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfConfiguracioDocsTramitacioRDTO fallbackCercaConfiguracioDocumentacioTramitacio(
			DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * cercaDocumentsEntradaAgrupatsPerTramitOvt(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt")
	public List<DocsEntradaRDTO> cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<DocsEntradaRDTO> docsEntradaRDTOList = documentacioApi.cercaDocumentsEntradaAgrupatsPerTramitOvt(idDocumentacio);

			if (log.isDebugEnabled()) {
				log.debug("cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTOList;
		} catch (RestClientException e) {
			log.error("cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca documents entrada agrupats per tramit ovt.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @param e
	 *            the e
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<DocsEntradaRDTO> fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * cercaConfiguracioDocumentacioEntradaRequerida(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaConfiguracioDocumentacioEntradaRequerida")
	public List<ConfDocEntradaRequeritRDTO> cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal idDocumentacio)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<ConfDocEntradaRequeritRDTO> confDocEntradaRequeritRDTOList = documentacioRequeritApi
					.cercaConfiguracioDocumentacioEntradaRequerida(idDocumentacio);

			if (log.isDebugEnabled()) {
				log.debug("cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return confDocEntradaRequeritRDTOList;
		} catch (RestClientException e) {
			log.error("cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio entrada requerida.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @param e
	 *            the e
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<ConfDocEntradaRequeritRDTO> fallbackCercaConfiguracioDocumentacioEntradaRequerida(BigDecimal idDocumentacio, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioEntradaRequerida(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#crearDocumentEntrada(es.
	 * bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentEntradaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearDocumentEntrada")
	public DocsEntradaRDTO crearDocumentEntrada(CrearDocumentEntradaBDTO crearDocumentEntradaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearDocumentEntrada(CrearDocumentEntradaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.crearDocumentEntrada(crearDocumentEntradaBDTO.getDocsEntradaRDTO(),
					crearDocumentEntradaBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("crearDocumentEntrada(CrearDocumentEntradaBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("crearDocumentEntrada(CrearDocumentEntradaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback crear document entrada.
	 *
	 * @param crearDocumentEntradaBDTO
	 *            the crear document entrada BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackCrearDocumentEntrada(CrearDocumentEntradaBDTO crearDocumentEntradaBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearDocumentEntrada(CrearDocumentEntradaBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * crearDeclaracioResponsable(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * CrearDeclaracioResponsableBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearDeclaracioResponsable")
	public DocsEntradaRDTO crearDeclaracioResponsable(CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearDeclaracioResponsable(CrearDeclaracioResponsableBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.crearDeclaracioResponsable(
					crearDeclaracioResponsableBDTO.getDocsEntradaRDTO(), crearDeclaracioResponsableBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("crearDeclaracioResponsable(CrearDeclaracioResponsableBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("crearDeclaracioResponsable(CrearDeclaracioResponsableBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback crear declaracio responsable.
	 *
	 * @param crearDeclaracioResponsableBDTO
	 *            the crear declaracio responsable BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackCrearDeclaracioResponsable(CrearDeclaracioResponsableBDTO crearDeclaracioResponsableBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearDeclaracioResponsable(CrearDeclaracioResponsableBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#crearDocumentTramitacio(
	 * es.bcn.gpa.gpaserveis.business.dto.documents.CrearDocumentTramitacioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearDocumentTramitacio")
	public DocsTramitacioRDTO crearDocumentTramitacio(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearDocumentTramitacio(CrearDocumentTramitacioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.crearDocumentTramitacio(
					crearDocumentTramitacioBDTO.getDocsTramitacioRDTO(), crearDocumentTramitacioBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("crearDocumentTramitacio(CrearDocumentTramitacioBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("crearDocumentTramitacio(CrearDocumentTramitacioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback crear document tramitacio.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackCrearDocumentTramitacio(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearDocumentTramitacio(CrearDocumentTramitacioBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * guardarDocumentTramitacioPlantilla(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.CrearDocumentTramitacioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentTramitacioPlantilla")
	public DocsTramitacioRDTO guardarDocumentTramitacioPlantilla(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentTramitacioPlantilla(CrearDocumentTramitacioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.guardarDocumentTramitacioPlantilla(
					crearDocumentTramitacioBDTO.getDocsTramitacioRDTO(), crearDocumentTramitacioBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentTramitacioPlantilla(CrearDocumentTramitacioBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("guardarDocumentTramitacioPlantilla(CrearDocumentTramitacioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback guardar document tramitacio plantilla.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackGuardarDocumentTramitacioPlantilla(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO,
			Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearDocumentTramitacio(CrearDocumentTramitacioBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * actualitzarDocumentEntrada(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * ActualitzarDocumentEntradaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackActualitzarDocumentEntrada")
	public DocsEntradaRDTO actualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.actualitzarDocumentEntrada(
					actualitzarDocumentEntradaBDTO.getDocsEntradaRDTO(), actualitzarDocumentEntradaBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("actualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("actualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback actualitzar document entrada.
	 *
	 * @param actualitzarDocumentEntradaBDTO
	 *            the actualitzar document entrada BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackActualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO actualitzarDocumentEntradaBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackActualitzarDocumentEntrada(ActualitzarDocumentEntradaBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * actualitzarDeclaracioResponsable(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.ActualitzarDeclaracioResponsableBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackActualitzarDeclaracioResponsable")
	public DocsEntradaRDTO actualitzarDeclaracioResponsable(ActualitzarDeclaracioResponsableBDTO actualitzarDeclaracioResponsableBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarDeclaracioResponsable(ActualitzarDeclaracioResponsableBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.actualitzarDeclaracioResponsable(
					actualitzarDeclaracioResponsableBDTO.getDocsEntradaRDTO(), actualitzarDeclaracioResponsableBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("actualitzarDeclaracioResponsable(ActualitzarDeclaracioResponsableBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("actualitzarDeclaracioResponsable(ActualitzarDeclaracioResponsableBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback actualitzar declaracio responsable.
	 *
	 * @param actualitzarDeclaracioResponsableBDTO
	 *            the actualitzar declaracio responsable BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackActualitzarDeclaracioResponsable(
			ActualitzarDeclaracioResponsableBDTO actualitzarDeclaracioResponsableBDTO, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackActualitzarDeclaracioResponsable(ActualitzarDeclaracioResponsableBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * actualitzarDocumentTramitacio(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.ActualitzarDocumentTramitacioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackActualitzarDocumentTramitacio")
	public DocsTramitacioRDTO actualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.actualitzarDocumentTramitacio(
					actualitzarDocumentTramitacioBDTO.getDocsTramitacioRDTO(), actualitzarDocumentTramitacioBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("actualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("actualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback actualitzar document tramitacio.
	 *
	 * @param actualitzarDocumentTramitacioBDTO
	 *            the actualitzar document tramitacio BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackActualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO actualitzarDocumentTramitacioBDTO,
			Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackActualitzarDocumentTramitacio(ActualitzarDocumentTramitacioBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * guardarDocumentEntradaFitxer(es.bcn.gpa.gpaserveis.business.dto.documents
	 * .GuardarDocumentEntradaFitxerBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentEntradaFitxer")
	public DocsEntradaRDTO guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO) - inici"); //$NON-NLS-1$
		}

		File file = null;
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.registerModule(new JodaModule());
		ObjectWriter jsonWriter = jsonMapper.writer();
		try {
			Path tempFile = Files.createTempFile("upload-temp-file", null);
			guardarDocumentEntradaFitxerBDTO.getFile().transferTo(tempFile.toFile());
			file = tempFile.toFile();

			String docsEntrada = jsonWriter.writeValueAsString(guardarDocumentEntradaFitxerBDTO.getDocsEntradaRDTO());

			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.guardarDocumentEntradaFitxer(docsEntrada, file,
					guardarDocumentEntradaFitxerBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException | IOException e) {
			log.error("guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage(), e);
		} finally {
			if (file != null) {
				FileUtils.deleteQuietly(file);
			}
		}
	}

	/**
	 * Fallback guardar document entrada fitxer.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackGuardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO,
			Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * guardarDocumentTramitacioFitxer(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.GuardarDocumentTramitacioFitxerBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentTramitacioFitxer")
	public DocsTramitacioRDTO guardarDocumentTramitacioFitxer(GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentTramitacioFitxer(GuardarDocumentTramitacioFitxerBDTO) - inici"); //$NON-NLS-1$
		}

		File file = null;
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.registerModule(new JodaModule());
		ObjectWriter jsonWriter = jsonMapper.writer();
		try {
			Path tempFile = Files.createTempFile("upload-temp-file", null);
			guardarDocumentTramitacioFitxerBDTO.getFile().transferTo(tempFile.toFile());
			file = tempFile.toFile();

			String docsTramitacio = jsonWriter.writeValueAsString(guardarDocumentTramitacioFitxerBDTO.getDocsTramitacioRDTO());

			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.guardarDocumentTramitacioFitxer(docsTramitacio, file,
					guardarDocumentTramitacioFitxerBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentTramitacioFitxer(GuardarDocumentTramitacioFitxerBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException | IOException e) {
			log.error("guardarDocumentTramitacioFitxer(GuardarDocumentTramitacioFitxerBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		} finally {
			if (file != null) {
				FileUtils.deleteQuietly(file);
			}
		}
	}

	/**
	 * Fallback guardar document tramitacio fitxer.
	 *
	 * @param guardarDocumentTramitacioFitxerBDTO
	 *            the guardar document tramitacio fitxer BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackGuardarDocumentTramitacioFitxer(
			GuardarDocumentTramitacioFitxerBDTO guardarDocumentTramitacioFitxerBDTO, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentTramitacioFitxer(GuardarDocumentTramitacioFitxerBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#guardarRequerimentFitxer(
	 * es.bcn.gpa.gpaserveis.business.dto.documents.
	 * GuardarRequerimentFitxerBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarRequerimentFitxer")
	public DocsTramitacioRDTO guardarRequerimentFitxer(GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarRequerimentFitxer(GuardarRequerimentFitxerBDTO) - inici"); //$NON-NLS-1$
		}

		File file = null;
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.registerModule(new JodaModule());
		ObjectWriter jsonWriter = jsonMapper.writer();
		try {
			Path tempFile = Files.createTempFile("upload-temp-file", null);
			guardarRequerimentFitxerBDTO.getFile().transferTo(tempFile.toFile());
			file = tempFile.toFile();

			String requeriment = jsonWriter.writeValueAsString(guardarRequerimentFitxerBDTO.getGuardarRequerimentExpedient());

			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.guardarRequerimentFitxer(file,
					guardarRequerimentFitxerBDTO.getIdExpedient(), requeriment);

			if (log.isDebugEnabled()) {
				log.debug("guardarRequerimentFitxer(GuardarRequerimentFitxerBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException | IOException e) {
			log.error("guardarRequerimentFitxer(GuardarRequerimentFitxerBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		} finally {
			if (file != null) {
				FileUtils.deleteQuietly(file);
			}
		}
	}

	/**
	 * Fallback guardar requeriment fitxer.
	 *
	 * @param guardarRequerimentFitxerBDTO
	 *            the guardar requeriment fitxer BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackGuardarRequerimentFitxer(GuardarRequerimentFitxerBDTO guardarRequerimentFitxerBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarRequerimentFitxer(GuardarRequerimentFitxerBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * guardarRequerimentPlantilla(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * CrearRequerimentBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarRequerimentPlantilla")
	public DocsTramitacioRDTO guardarRequerimentPlantilla(CrearRequerimentBDTO crearRequerimentBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarRequerimentPlantilla(CrearRequerimentBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.guardarRequerimentPlantilla(
					crearRequerimentBDTO.getGuardarRequerimentExpedient(), crearRequerimentBDTO.getIdExpedient());
			if (log.isDebugEnabled()) {
				log.debug("guardarRequerimentPlantilla(CrearRequerimentBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("guardarRequerimentPlantilla(CrearRequerimentBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback guardar requeriment plantilla.
	 *
	 * @param crearRequerimentBDTO
	 *            the crear requeriment BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackGuardarRequerimentPlantilla(CrearRequerimentBDTO crearRequerimentBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarRequerimentPlantilla(CrearRequerimentBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#actualitzarRequeriment(es
	 * .bcn.gpa.gpaserveis.business.dto.documents.CrearRequerimentBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackActualitzarRequeriment")
	public DocsTramitacioRDTO actualitzarRequeriment(CrearRequerimentBDTO crearRequerimentBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarRequeriment(CrearRequerimentBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi
					.actualitzarRequeriment(crearRequerimentBDTO.getGuardarRequerimentExpedient(), crearRequerimentBDTO.getIdExpedient());
			if (log.isDebugEnabled()) {
				log.debug("actualitzarRequeriment(CrearRequerimentBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("actualitzarRequeriment(CrearRequerimentBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback actualitzar requeriment.
	 *
	 * @param crearRequerimentBDTO
	 *            the crear requeriment BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackActualitzarRequeriment(CrearRequerimentBDTO crearRequerimentBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackActualitzarRequeriment(CrearRequerimentBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#consultarDadesDocument(
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesDocument")
	public DocsRDTO consultarDadesDocument(BigDecimal idDocument) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesDocument(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			DocsRDTO docsRDTO = documentacioApi.consultarDadesDocument(idDocument);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesDocument(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesDocument(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades document.
	 *
	 * @param idDocument
	 *            the id document
	 * @param e
	 *            the e
	 * @return the docs RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsRDTO fallbackConsultarDadesDocument(BigDecimal idDocument, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocument(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * consultarDadesDocumentAportat(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesDocumentAportat")
	public DocsEntradaRDTO consultarDadesDocumentAportat(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesDocumentAportat(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.consultarDadesDocumentAportat(id);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesDocumentAportat(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesDocumentAportat(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades document aportat.
	 *
	 * @param id
	 *            the id
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackConsultarDadesDocumentAportat(BigDecimal id, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocumentAportat(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * consultarDadesDocumentGenerat(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesDocumentGenerat")
	public DocsTramitacioRDTO consultarDadesDocumentGenerat(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesDocumentGenerat(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.consultarDadesDocumentGenerat(id);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesDocumentGenerat(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesDocumentGenerat(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades document generat.
	 *
	 * @param id
	 *            the id
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackConsultarDadesDocumentGenerat(BigDecimal id, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocumentGenerat(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * descarregarDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.documents
	 * .DescarregarDocumentExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackDescarregarDocumentExpedient")
	public byte[] descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			byte[] documentByteArray = downloadApi.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO.getIdDocument(),
					descarregarDocumentExpedientBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO) - fi"); //$NON-NLS-1$
			}
			return documentByteArray;
		} catch (RestClientException e) {
			log.error("descarregarDocumentExpedient(DescarregarDocumentExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback descarregar document expedient.
	 *
	 * @param descarregarDocumentExpedientBDTO
	 *            the descarregar document expedient BDTO
	 * @param e
	 *            the e
	 * @return the byte[]
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public byte[] fallbackDescarregarDocumentExpedient(DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackDescarregarDocumentExpedient(DescarregarDocumentExpedientBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * cercaDadesOperacioRequerits(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDadesOperacioRequerits")
	public List<BigDecimal> cercaDadesOperacioRequerits(BigDecimal documentacioIdext) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDadesOperacioRequerits(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<BigDecimal> dadesOperacioRequeritsIdList = documentacioApi.cercaDadesOperacioRequerits(documentacioIdext);

			if (log.isDebugEnabled()) {
				log.debug("cercaDadesOperacioRequerits(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return dadesOperacioRequeritsIdList;
		} catch (RestClientException e) {
			log.error("cercaDadesOperacioRequerits(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca dades operacio requerits.
	 *
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @param e
	 *            the e
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<BigDecimal> fallbackCercaDadesOperacioRequerits(BigDecimal documentacioIdext, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDadesOperacioRequerits(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * revisarDocumentacioEntrada(es.bcn.gpa.gpaserveis.business.dto.expedients.
	 * DocumentAportatValidarBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackRevisarDocumentacioEntrada")
	public void revisarDocumentacioEntrada(DocumentAportatValidarBDTO documentAportatValidarBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("revisarDocumentacioEntrada(DocumentAportatValidarBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.revisarDocumentacioEntrada(documentAportatValidarBDTO.getDocumentRevisio());

			if (log.isDebugEnabled()) {
				log.debug("revisarDocumentacioEntrada(DocumentAportatValidarBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("revisarDocumentacioEntrada(DocumentAportatValidarBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback revisar documentacio entrada.
	 *
	 * @param documentAportatValidarBDTO
	 *            the document aportat validar BDTO
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackRevisarDocumentacioEntrada(DocumentAportatValidarBDTO documentAportatValidarBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackRevisarDocumentacioEntrada(DocumentAportatValidarBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#getPlantillaDocVinculada(
	 * java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGetPlantillaDocVinculada")
	public RespostaPlantillaDocVinculada getPlantillaDocVinculada(BigDecimal idConfDoc, BigDecimal idDocVinculada)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("getPlantillaDocVinculada(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			RespostaPlantillaDocVinculada respostaPlantillaDocVinculada = configuracioDocumentacioApi
					.consultarPlantillaDocumentacioVinculada(idConfDoc, idDocVinculada);

			if (log.isDebugEnabled()) {
				log.debug("getPlantillaDocVinculada(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}

			return respostaPlantillaDocVinculada;
		} catch (RestClientException e) {
			log.error("getPlantillaDocVinculada(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback get plantilla doc vinculada.
	 *
	 * @param idConfDoc
	 *            the id conf doc
	 * @param idDocVinculada
	 *            the id doc vinculada
	 * @param e
	 *            the e
	 * @return the resposta plantilla doc vinculada
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public RespostaPlantillaDocVinculada fallbackGetPlantillaDocVinculada(BigDecimal idConfDoc, BigDecimal idDocVinculada, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGetPlantillaDocVinculada(BigDecimal, BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * associarRegistreDocumentacioExpedient(es.bcn.gpa.gpaserveis.rest.client.
	 * api.model.gpadocumentacio.DocumentActualizarRegistre)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackAssociarRegistreDocumentacioExpedient")
	public void associarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("associarRegistreDocumentacioExpedient(DocumentActualizarRegistre) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.associarRegistreDocumentacio(documentActualizarRegistreRDTO);

			if (log.isDebugEnabled()) {
				log.debug("associarRegistreDocumentacioExpedient(DocumentActualizarRegistre) - fi"); //$NON-NLS-1$
			}

		} catch (RestClientException e) {
			log.error("associarRegistreDocumentacioExpedient(DocumentActualizarRegistre)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e);
		}

	}

	/**
	 * Fallback associar registre documentacio expedient.
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackAssociarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackaAssociarRegistreDocumentacioExpedient(DocumentActualizarRegistre, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#associarRegistreDocsEnt(
	 * es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.
	 * DocsEntActualizarRegistre)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackAssociarRegistreDocsEnt")
	public void associarRegistreDocsEnt(DocsEntActualizarRegistre docsEntActualizarRegistreRDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("associarRegistreDocsEnt(DocsEntActualizarRegistre) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.associarRegistreDocsEnt(docsEntActualizarRegistreRDTO);

			if (log.isDebugEnabled()) {
				log.debug("associarRegistreDocsEnt(DocsEntActualizarRegistre) - fi"); //$NON-NLS-1$
			}

		} catch (RestClientException e) {
			log.error("associarRegistreDocsEnt(DocsEntActualizarRegistre)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback associar registre docs ent.
	 *
	 * @param docsEntActualizarRegistre
	 *            the docs ent actualizar registre
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackAssociarRegistreDocsEnt(DocsEntActualizarRegistre docsEntActualizarRegistre, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackaAssociarRegistreDocsEnt(DocsEntActualizarRegistre, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#signarValidarDocument(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarDocument)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackSignarValidarDocument")
	public PeticionsPortasig signarValidarDocument(SignarDocument signarDocument) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("signarValidarDocument(SignarDocument) - inici"); //$NON-NLS-1$
		}

		try {
			PeticionsPortasig crearPeticioPortaSig = documentacioApi.crearPeticioPortaSig(signarDocument);

			if (log.isDebugEnabled()) {
				log.debug("signarValidarDocument(SignarDocument) - fi"); //$NON-NLS-1$
			}
			return crearPeticioPortaSig;

		} catch (RestClientException e) {
			log.error("signarValidarDocument(SignarDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback signar validar document.
	 *
	 * @param signarDocument
	 *            the signar document
	 * @param e
	 *            the e
	 * @return the PeticionsPortasig
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PeticionsPortasig fallbackSignarValidarDocument(SignarDocument signarDocument, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSignarValidarDocument(SignarDocument, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * obtenirDocsTramitacioByNotificationId(java.lang.Long)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackObtenirDocsTramitacioByNotificationId")
	public DocsTramitacioRDTO obtenirDocsTramitacioByNotificationId(Long notificacioId) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirDocsTramitacioByNotificationId(Long) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi
					.obtenirDocsTramitacioByNotificationId(BigDecimal.valueOf(notificacioId));

			if (log.isDebugEnabled()) {
				log.debug("obtenirDocsTramitacioByNotificationId(Long) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("obtenirDocsTramitacioByNotificationId(Long)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback obtenir docs tramitacio by notification id.
	 *
	 * @param notificacioId
	 *            the notificacio id
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackObtenirDocsTramitacioByNotificationId(Long notificacioId, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackObtenirDocsTramitacioByNotificationId(Long, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#crearNotificacio(es.bcn.
	 * gpa.gpaserveis.business.dto.expedients.DocumentCrearNotificacioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearNotificacio")
	public NotificacionsRDTO crearNotificacio(DocumentCrearNotificacioBDTO documentCrearNotificacioBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearNotificacio(DocumentCrearNotificacioBDTO) - inici"); //$NON-NLS-1$
		}
		try {
			NotificacionsRDTO notificacionsRDTO = notificacionsApi.crearNotificacio(documentCrearNotificacioBDTO.getCrearNotificacio());

			if (log.isDebugEnabled()) {
				log.debug("crearNotificacio(DocumentCrearNotificacioBDTO) - fi"); //$NON-NLS-1$
			}
			return notificacionsRDTO;
		} catch (RestClientException e) {
			log.error("crearNotificacio(DocumentCrearNotificacioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback crear notificacio.
	 *
	 * @param documentCrearNotificacioBDTO
	 *            the document crear notificacio BDTO
	 * @param e
	 *            the e
	 * @return the notificacions RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public NotificacionsRDTO fallbackCrearNotificacio(DocumentCrearNotificacioBDTO documentCrearNotificacioBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearNotificacio(DocumentCrearNotificacioBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#callbackNotificacio(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.
	 * ActualitzarNotificacio)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackActualitzarNotificacio")
	public void callbackNotificacio(ActualitzarNotificacio actualitzarNotificacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarNotificacio(ActualitzarNotificacionDocument) - inici"); //$NON-NLS-1$
		}
		try {
			notificacionsApi.callbackNotificacio(actualitzarNotificacio);

			if (log.isDebugEnabled()) {
				log.debug("actualitzarNotificacio(ActualitzarNotificacionDocument) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("actualitzarNotificacio(ActualitzarNotificacionDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback actualitzar notificacio.
	 *
	 * @param actualitzarNotificacio
	 *            the actualitzar notificacio
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackActualitzarNotificacio(ActualitzarNotificacio actualitzarNotificacio, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackActualitzarNotificacio(ActualitzarNotificacionDocument, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * tancarRequerimentsExpedient(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackTancarRequerimentsExpedient")
	public void tancarRequerimentsExpedient(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("tancarRequerimentsExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.tancarRequerimentsExpedient(idDocumentacio);

			if (log.isDebugEnabled()) {
				log.debug("tancarRequerimentsExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("tancarRequerimentsExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback tancar requeriments expedient.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackTancarRequerimentsExpedient(BigDecimal idDocumentacio, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackTancarRequerimentsExpedient(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#callbackPortaSig(es.bcn.
	 * gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCallbackPortaSig")
	public void callbackPortaSig(CallbackPortaSig callbackPortaSig) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("callbackPortaSig(CallbackPortaSig) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.callbackPortaSig(callbackPortaSig);

			if (log.isDebugEnabled()) {
				log.debug("callbackPortaSig(CallbackPortaSig) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("callbackPortaSig(CallbackPortaSig)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback callback porta sig.
	 *
	 * @param callbackPortaSig
	 *            the callback porta sig
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackCallbackPortaSig(CallbackPortaSig callbackPortaSig, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCallbackPortaSig(CallbackPortaSig, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * crearDocumentEntradaDigitalitzat(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.CrearDocumentEntradaDigitalitzarBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearDocumentEntradaDigitalitzat")
	public DocsEntradaRDTO crearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO crearDocumentEntradaDigitalitzarBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.crearDocumentEntradaDigitalitzat(
					crearDocumentEntradaDigitalitzarBDTO.getDocsEntradaRDTO(), crearDocumentEntradaDigitalitzarBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("crearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("crearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback crear document entrada digitalitzat.
	 *
	 * @param crearDocumentEntradaDigitalitzarBDTO
	 *            the crear document entrada digitalitzar BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackCrearDocumentEntradaDigitalitzat(
			CrearDocumentEntradaDigitalitzarBDTO crearDocumentEntradaDigitalitzarBDTO, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * crearDocumentTramitacioDigitalitzat(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.CrearDocumentTramitacioDigitalitzarBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCrearDocumentTramitacioDigitalitzat")
	public DocsTramitacioRDTO crearDocumentTramitacioDigitalitzat(
			CrearDocumentTramitacioDigitalitzarBDTO crearDocumentTramitacioDigitalitzarBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("crearDocumentTramitacioDigitalitzat(CrearDocumentTramitacioDigitalitzarBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.crearDocumentTramitacioDigitalitzat(
					crearDocumentTramitacioDigitalitzarBDTO.getDocsTramitacioRDTO(),
					crearDocumentTramitacioDigitalitzarBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("crearDocumentTramitacioDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("crearDocumentEntradaDigitalitzat(CrearDocumentEntradaDigitalitzarBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback crear document tramitacio digitalitzat.
	 *
	 * @param crearDocumentTramitacioDigitalitzarBDTO
	 *            the crear document tramitacio digitalitzar BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackCrearDocumentTramitacioDigitalitzat(
			CrearDocumentTramitacioDigitalitzarBDTO crearDocumentTramitacioDigitalitzarBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCrearDocumentEntradaDigitalitzat(CrearDocumentTramitacioDigitalitzarBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * registrarComunicatDocumentTramitacio(es.bcn.gpa.gpaserveis.business.dto.
	 * expedients.DocumentGeneratRegistrarComunicatBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackRegistrarComunicatDocumentTramitacio")
	public void registrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO documentGeneratRegistrarComunicatBDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("registrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.registrarComunicatDocumentTramitacio(documentGeneratRegistrarComunicatBDTO.getDocumentRegistrarComunicat());

			if (log.isDebugEnabled()) {
				log.debug("registrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("registrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback registrar comunicat document tramitacio.
	 *
	 * @param documentGeneratRegistrarComunicatBDTO
	 *            the document generat registrar comunicat BDTO
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackRegistrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO documentGeneratRegistrarComunicatBDTO,
			Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackRegistrarComunicatDocumentTramitacio(DocumentGeneratRegistrarComunicatBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#callbackDigitalitzacio(es
	 * .bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.
	 * CallbackDigitalitzacio)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackcallbackDigitalitzacio")
	public void callbackDigitalitzacio(CallbackDigitalitzacio callbackDigitalitzacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("callbackDigitalitzacio(CallbackDigitalitzacio) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.callbackDigitalitzacio(callbackDigitalitzacio);

			if (log.isDebugEnabled()) {
				log.debug("callbackDigitalitzacio(CallbackDigitalitzacio) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("callbackDigitalitzacio(CallbackDigitalitzacio)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}

	}

	/**
	 * Fallbackcallback digitalitzacio.
	 *
	 * @param callbackDigitalitzacio
	 *            the callback digitalitzacio
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackcallbackDigitalitzacio(CallbackDigitalitzacio callbackDigitalitzacio, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackcallbackDigitalitzacio(CallbackDigitalitzacio, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#associatsDocsIntra(es.bcn
	 * .gpa.gpaserveis.business.dto.documents.DocsAssociatsIntraBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackcallbackAssociatsDocsIntra")
	public void associatsDocsIntra(DocsAssociatsIntraBDTO docsAssociatsIntraBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("associatsDocsIntra(DocsAssociatsIntraBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.associatsDocsIntra(docsAssociatsIntraBDTO.getDocsAssociatsIntra());

			if (log.isDebugEnabled()) {
				log.debug("associatsDocsIntra(DocsAssociatsIntraBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("associatsDocsIntra(DocsAssociatsIntraBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallbackcallback associats docs intra.
	 *
	 * @param docsAssociatsIntraBDTO
	 *            the docs associats intra BDTO
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackcallbackAssociatsDocsIntra(DocsAssociatsIntraBDTO docsAssociatsIntraBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackcallbackAssociatsDocsIntra(DocsAssociatsIntraBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * esBorrarDocumentacioEntrada(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * EsborrarDocumentBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackEsBorrarDocumentacioEntrada")
	public void esBorrarDocumentacioEntrada(EsborrarDocumentBDTO esborrarDocumentBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("esBorrarDocumentacioEntrada(EsborrarDocumentBDTO) - inici"); //$NON-NLS-1$
		}
		try {
			documentacioApi.esBorrarDocumentacioEntrada(esborrarDocumentBDTO.getIdDocument(), esborrarDocumentBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("esBorrarDocumentacioEntrada(EsborrarDocumentBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("esBorrarDocumentacioEntrada(EsborrarDocumentBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback es borrar documentacio entrada.
	 *
	 * @param esborrarDocumentBDTO
	 *            the esborrar document BDTO
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackEsBorrarDocumentacioEntrada(EsborrarDocumentBDTO esborrarDocumentBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackEsBorrarDocumentacioEntrada(EsborrarDocumentBDTO, Throwable) - inici"); //$NON-NLS-1$
		}
		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * esBorrarDocumentacioTramitacio(es.bcn.gpa.gpaserveis.business.dto.
	 * documents.EsborrarDocumentBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackEsBorrarDocumentacioTramitacio")
	public void esBorrarDocumentacioTramitacio(EsborrarDocumentBDTO esborrarDocumentBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("esBorrarDocumentacioTramitacio(EsborrarDocumentBDTO) - inici"); //$NON-NLS-1$
		}
		try {
			documentacioApi.esBorrarDocumentacioTramitacio(esborrarDocumentBDTO.getIdDocument(), esborrarDocumentBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("esBorrarDocumentacioTramitacio(EsborrarDocumentBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("esBorrarDocumentacioTramitacio(EsborrarDocumentBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback es borrar documentacio tramitacio.
	 *
	 * @param esborrarDocumentBDTO
	 *            the esborrar document BDTO
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackEsBorrarDocumentacioTramitacio(EsborrarDocumentBDTO esborrarDocumentBDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackEsBorrarDocumentacioTramitacio(EsborrarDocumentBDTO, Throwable) - inici"); //$NON-NLS-1$
		}
		ServeisServiceExceptionHandler.handleException(e);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 *      desassociarRegistreDocumentacioExpedient(es.bcn.gpa.gpaserveis.rest.
	 *      client. api.model.gpadocumentacio.DocumentActualizarRegistre)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackDesssociarRegistreDocumentacioExpedient")
	public void desassociarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("desassociarRegistreDocumentacioExpedient(DocumentActualizarRegistre) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.desassociarRegistreDocumentacio(documentActualizarRegistreRDTO);

			if (log.isDebugEnabled()) {
				log.debug("desassociarRegistreDocumentacioExpedient(DocumentActualizarRegistre) - fi"); //$NON-NLS-1$
			}

		} catch (RestClientException e) {
			log.error("desassociarRegistreDocumentacioExpedient(DocumentActualizarRegistre)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e);
		}

	}

	/**
	 * Fallback desassociar registre documentacio expedient.
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackDesssociarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO, Throwable e)
			throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackDesssociarRegistreDocumentacioExpedient(DocumentActualizarRegistre, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/**
	 * comprovarDocumentsSignatsExpedient(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackComprovarDocumentsSignatsExpedient")
	public Boolean comprovarDocumentsSignatsExpedient(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("comprovarDocumentsSignatsExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}
		try {
			Boolean documentsSignats = documentacioApi.comprovarDocumentsSignatsExpedient(idDocumentacio);

			if (log.isDebugEnabled()) {
				log.debug("comprovarDocumentsSignatsExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return documentsSignats;
		} catch (RestClientException e) {
			log.error("comprovarDocumentsSignatsExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback comprovar documents signats expedient.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @param e
	 *            the e
	 * @return the boolean
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public Boolean fallbackComprovarDocumentsSignatsExpedient(BigDecimal idDocumentacio, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackComprovarDocumentsSignatsExpedient(EsborrarDocumentBDTO, Throwable) - inici"); //$NON-NLS-1$
		}
		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}
}
