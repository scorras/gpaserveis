package es.bcn.gpa.gpaserveis.business.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.DocumentsService;
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
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.SignaturesApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackDigitalitzacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackManuscrita;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CallbackPortaSig;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConsultarSignaturaResponse;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DadesSignatura;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.NotificacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
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
import lombok.extern.apachecommons.CommonsLog;
import net.opentrends.openframe.services.security.core.userdetails.ImiUserDetails;
import net.opentrends.openframe.services.security.util.SecurityUtils;

/**
 * The Class DocumentsServiceImpl.
 */
@Service
@CommonsLog
public class DocumentsServiceImpl implements DocumentsService {

	/** The configuracio documentacio api. */
	@Autowired
	private ConfiguracioDocumentacioApi configuracioDocumentacioApi;

	/** The documentacio api. */
	@Autowired
	private DocumentacioApi documentacioApi;

	/** The signatures api. */
	@Autowired
	private SignaturesApi signaturesApi;

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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	 * cercaDocumentsEntradaPerSollicitud(java.math.BigDecimal,
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDocumentsEntradaPerSollicitud")
	public List<DocsEntradaRDTO> cercaDocumentsEntradaPerSollicitud(BigDecimal idSollicitud, BigDecimal visibilitat)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDocumentsEntradaPerSollicitud(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<DocsEntradaRDTO> docsEntradaRDTOList = documentacioApi.cercaDocumentsEntradaPerSollicitud(idSollicitud, visibilitat);

			if (log.isDebugEnabled()) {
				log.debug("cercaDocumentsEntradaPerSollicitud(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTOList;
		} catch (RestClientException e) {
			log.error("cercaDocumentsEntradaPerSollicitud(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback cerca documents entrada per sollicitud.
	 *
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param e
	 *            the e
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<DocsEntradaRDTO> fallbackCercaDocumentsEntradaPerSollicitud(BigDecimal idSollicitud, BigDecimal visibilitat, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDocumentsEntradaPerSollicitud(BigDecimal, BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * cercaDocumentsEntradaAgrupatsPerTramitOvt(java.math.BigDecimal,
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt")
	public List<DocsEntradaRDTO> cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio, BigDecimal visibilitat)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<DocsEntradaRDTO> docsEntradaRDTOList = documentacioApi.cercaDocumentsEntradaAgrupatsPerTramitOvt(idDocumentacio,
			        visibilitat);

			if (log.isDebugEnabled()) {
				log.debug("cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTOList;
		} catch (RestClientException e) {
			log.error("cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	public List<DocsEntradaRDTO> fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio, BigDecimal visibilitat,
	        Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal, BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#cercaDocumentsTramitacio(
	 * java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDocumentsTramitacio")
	public List<DocsTramitacioRDTO> cercaDocumentsTramitacio(BigDecimal idDocumentacio, BigDecimal visibilitat)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDocumentsTramitacio(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			List<DocsTramitacioRDTO> docsTramitacioRDTOList = documentacioApi.cercaDocumentsTramitacioComunicats(idDocumentacio,
			        visibilitat);

			if (log.isDebugEnabled()) {
				log.debug("cercaDocumentsTramitacio(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTOList;
		} catch (RestClientException e) {
			log.error("cercaDocumentsTramitacio(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback cerca documents tramitacio.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @param visibilitat
	 *            the visibilitat
	 * @param e
	 *            the e
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<DocsTramitacioRDTO> fallbackCercaDocumentsTramitacio(BigDecimal idDocumentacio, BigDecimal visibilitat, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDocumentsTramitacio(BigDecimal, BigDecimal, Throwable) - inici"); //$NON-NLS-1$
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	 * guardarDocumentTramitacioJustificantPlantilla(
	 * CrearDocumentTramitacioBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentTramitacioJustificantPlantilla")
	public DocsTramitacioRDTO guardarDocumentTramitacioJustificantPlantilla(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentTramitacioJustificantPlantilla(CrearDocumentTramitacioBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.guardarDocumentTramitacioJustificantPlantilla(
			        crearDocumentTramitacioBDTO.getDocsTramitacioRDTO(), crearDocumentTramitacioBDTO.getIdExpedient(),
			        crearDocumentTramitacioBDTO.getIdSollicitud());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentTramitacioJustificantPlantilla(CrearDocumentTramitacioBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("guardarDocumentTramitacioJustificantPlantilla(CrearDocumentTramitacioBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback guardar document tramitacio justificant plantilla.
	 *
	 * @param crearDocumentTramitacioBDTO
	 *            the crear document tramitacio BDTO
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackGuardarDocumentTramitacioJustificantPlantilla(CrearDocumentTramitacioBDTO crearDocumentTramitacioBDTO,
	        Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentTramitacioJustificantPlantilla(CrearDocumentTramitacioBDTO, Throwable) - inici"); //$NON-NLS-1$
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
			String extension = FilenameUtils.getExtension(guardarDocumentEntradaFitxerBDTO.getFile().getOriginalFilename());
			Path tempFile = Files.createTempFile("upload-temp-file", "." + extension);
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
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#guardarXmlSollicitud(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarXmlSollicitud")
	public void guardarXmlSollicitud(String idDocumentum, String xmlSollicitud) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO) - inici"); //$NON-NLS-1$
		}

		File file = null;
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.registerModule(new JodaModule());
		ObjectWriter jsonWriter = jsonMapper.writer();
		try {
			Path tempFile = Files.createTempFile("upload-temp-file", ".xml");
			file = tempFile.toFile();
			FileUtils.writeStringToFile(file, xmlSollicitud, StandardCharsets.UTF_8.toString());

			documentacioApi.guardarXmlSollicitud(file, idDocumentum);

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentEntradaFitxer(GuardarDocumentEntradaFitxerBDTO) - fi"); //$NON-NLS-1$
			}
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
	 * Fallback guardar xml sollicitud.
	 *
	 * @param idDocumentum
	 *            the id documentum
	 * @param xmlSollicitud
	 *            the xml sollicitud
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackGuardarXmlSollicitud(String idDocumentum, String xmlSollicitud, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarXmlSollicitud(String, String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
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
			String extension = FilenameUtils.getExtension(guardarDocumentTramitacioFitxerBDTO.getFile().getOriginalFilename());
			Path tempFile = Files.createTempFile("upload-temp-file", "." + extension);
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
			String extension = FilenameUtils.getExtension(guardarRequerimentFitxerBDTO.getFile().getOriginalFilename());
			Path tempFile = Files.createTempFile("upload-temp-file", "." + extension);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	 * consultarDadesDocumentAportatPerCodiCSV(java.lang.String,
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesDocumentAportatPerCodiCSV")
	public DocsEntradaRDTO consultarDadesDocumentAportatPerCodiCSV(String csvDocument, BigDecimal visibilitat)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesDocumentAportatPerCodiCSV(String, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.consultarDadesDocumentAportatPerCodiCSV(csvDocument, visibilitat);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesDocumentAportatPerCodiCSV(String, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesDocumentAportatPerCodiCSV(String, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback consultar dades document aportat per codi CSV.
	 *
	 * @param csvDocument
	 *            the csv document
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackConsultarDadesDocumentAportatPerCodiCSV(String csvDocument, BigDecimal visibilitat, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocumentAportatPerCodiCSV(String, BigDecimal, Throwable) - inici"); //$NON-NLS-1$
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	 * consultarDadesDocumentGeneratPerCodiCSV(java.lang.String,
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesDocumentGeneratPerCodiCSV")
	public DocsTramitacioRDTO consultarDadesDocumentGeneratPerCodiCSV(String csvDocument, BigDecimal visibilitat)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesDocumentGeneratPerCodiCSV(String, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.consultarDadesDocumentGeneratPerCodiCSV(csvDocument, visibilitat);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesDocumentGeneratPerCodiCSV(String, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (RestClientException e) {
			log.error("consultarDadesDocumentGeneratPerCodiCSV(String, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback consultar dades document generat per codi CSV.
	 *
	 * @param csvDocument
	 *            the csv document
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackConsultarDadesDocumentGeneratPerCodiCSV(String csvDocument, BigDecimal visibilitat, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocumentGeneratPerCodiCSV(String, BigDecimal, Throwable) - inici"); //$NON-NLS-1$
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	 * descarregarDocumentExpedient(BigDecimal idUltimaSignatura)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackDescarregarDocumentExpedientSignat")
	public byte[] descarregarDocumentExpedientSignat(BigDecimal idUltimaSignatura) throws GPAServeisServiceException {

		if (log.isDebugEnabled()) {
			log.debug("descarregarDocumentExpedientSignat(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {

			byte[] documentByteArray = signaturesApi.descarregarDocumentExpedientSignat(idUltimaSignatura);

			if (log.isDebugEnabled()) {
				log.debug("descarregarDocumentExpedientSignat(BigDecimal) - fi"); //$NON-NLS-1$
			}
			return documentByteArray;
		} catch (RestClientException e) {
			log.error("descarregarDocumentExpedientSignat(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback descarregar document expedient signat.
	 *
	 * @param idUltimaSignatura
	 *            the id ultima signatura
	 * @param e
	 *            the e
	 * @return the byte[]
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public byte[] fallbackDescarregarDocumentExpedientSignat(BigDecimal idUltimaSignatura, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackDescarregarDocumentExpedientSignat(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	public PeticionsPortasig signarValidarDocument(SignarPortasignaturesDocument signarPortasignaturesDocument)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("signarValidarDocument(SignarDocument) - inici"); //$NON-NLS-1$
		}

		try {
			PeticionsPortasig crearPeticioPortaSig = signaturesApi.crearPeticioPortaSig(signarPortasignaturesDocument);

			if (log.isDebugEnabled()) {
				log.debug("signarValidarDocument(SignarDocument) - fi"); //$NON-NLS-1$
			}
			return crearPeticioPortaSig;

		} catch (RestClientException e) {
			log.error("signarValidarDocument(SignarDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback signar validar document.
	 *
	 * @param signarPortasignaturesDocument
	 *            the signar portasignatures document
	 * @param e
	 *            the e
	 * @return the peticions portasig
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PeticionsPortasig fallbackSignarValidarDocument(SignarPortasignaturesDocument signarPortasignaturesDocument, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSignarValidarDocument(SignarDocument, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#signarSegellDocument(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarSegell)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackSignarSegellDocument")
	public SignarSegellDocument signarSegellDocument(SignarSegellDocument signarSegellDocumentRDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("signarSegellDocument(SignarSegellDocument) - inici"); //$NON-NLS-1$
		}

		ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
		String userInfo = imiUser != null ? imiUser.getPayload() : "Sin usuario";
		if (log.isInfoEnabled()) {
			log.info("SEGUIMIENTO USUARIO SSO signarSegellDocument (DocumentsService): " + userInfo);
		}

		try {
			SignarSegellDocument signarSegellDocument = signaturesApi.signarSegell(signarSegellDocumentRDTO);

			if (log.isDebugEnabled()) {
				log.debug("signarSegellDocument(SignarSegellDocument) - fi"); //$NON-NLS-1$
			}
			return signarSegellDocument;

		} catch (RestClientException e) {
			log.error("signarSegellDocument(SignarSegellDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback signar segell document.
	 *
	 * @param signarSegellDocument
	 *            the signar segelldocument
	 * @param e
	 *            the e
	 * @return the SignarSegellDocument
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public SignarSegellDocument fallbackSignarSegellDocument(SignarSegellDocument signarSegellDocument, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSignarSegellDocument(SignarSegellDocument, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#signarValidDocument(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.
	 * SignarValidDocument)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackSignarValidDocument")
	public SignarValidDocumentResponse signarValidDocument(SignarValidDocument signarValidDocumentRDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("signarValidDocument(SignarValidDocument) - inici"); //$NON-NLS-1$
		}

		try {
			SignarValidDocumentResponse signarValidDocumentResponse = signaturesApi.signarValid(signarValidDocumentRDTO);

			if (log.isDebugEnabled()) {
				log.debug("signarValidDocument(SignarValidDocument) - fi"); //$NON-NLS-1$
			}
			return signarValidDocumentResponse;

		} catch (RestClientException e) {
			log.error("signarValidDocument(SignarValidDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback signar valid document.
	 *
	 * @param signarValidDocumentRDTO
	 *            the signar valid document RDTO
	 * @param e
	 *            the e
	 * @return the signar valid document response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public SignarValidDocumentResponse fallbackSignarValidDocument(SignarValidDocument signarValidDocumentRDTO, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSignarValidDocument(SignarValidDocument, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#signarTabletDocument(es.
	 * bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.SignarTablet)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackSignarTabletDocument")
	public SignarTabletDocumentResponse signarTabletDocument(SignarTabletDocument signarTabletDocumentRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("signarTabletDocument(SignarTabletDocument) - inici"); //$NON-NLS-1$
		}

		try {
			SignarTabletDocumentResponse signarTabletDocumentResponse = signaturesApi.signarTablet(signarTabletDocumentRDTO);

			if (log.isDebugEnabled()) {
				log.debug("signarTabletDocument(SignarTabletDocument) - fi"); //$NON-NLS-1$
			}
			return signarTabletDocumentResponse;

		} catch (RestClientException e) {
			log.error("signarTabletDocument(SignarTabletDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback signar tablet document.
	 *
	 * @param signarTabletDocumentRDTO
	 *            the signar tablet document RDTO
	 * @param e
	 *            the e
	 * @return the SignarTabletDocument
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public SignarTabletDocumentResponse fallbackSignarTabletDocument(SignarTabletDocument signarTabletDocumentRDTO, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSignarTabletDocument(SignarTabletDocument, Throwable) - inici"); //$NON-NLS-1$
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	 * bcn.gpa.gpaserveis.business.dto.documents.ActualitzarNotificacioBDTO,
	 * org.springframework.web.multipart.MultipartFile,
	 * org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	// @HystrixCommand(fallbackMethod = "fallbackCallbackNotificacio")
	public void callbackNotificacio(ActualitzarNotificacioBDTO actualitzarNotificacio, MultipartFile docEvidenciaElectronic,
	        MultipartFile docEvidenciaPaper) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("actualitzarNotificacio(ActualitzarNotificacionDocument, MultipartFile, MultipartFile) - inici"); //$NON-NLS-1$
		}
		try {
			File docEvidenciaPaperFile = null;
			File docEvidenciaElectronicFile = null;

			ObjectMapper jsonMapper = new ObjectMapper();
			jsonMapper.registerModule(new JodaModule());
			ObjectWriter jsonWriter = jsonMapper.writer();

			if (docEvidenciaPaper != null) {
				docEvidenciaPaperFile = new File(docEvidenciaPaper.getOriginalFilename());
				docEvidenciaPaper.transferTo(docEvidenciaPaperFile);
			}

			if (docEvidenciaElectronic != null) {
				docEvidenciaElectronicFile = new File(docEvidenciaElectronic.getOriginalFilename());
				docEvidenciaElectronic.transferTo(docEvidenciaElectronicFile);
			}

			String actualitzarNotificacionDocument = jsonWriter.writeValueAsString(actualitzarNotificacio);

			notificacionsApi.callbackNotificacio(actualitzarNotificacionDocument, docEvidenciaElectronicFile, docEvidenciaPaperFile);

			if (log.isDebugEnabled()) {
				log.debug("actualitzarNotificacio(ActualitzarNotificacionDocument, MultipartFile, MultipartFile) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("actualitzarNotificacio(ActualitzarNotificacionDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		} catch (IllegalStateException e) {
			log.error("actualitzarNotificacio(ActualitzarNotificacionDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		} catch (IOException e) {
			log.error("actualitzarNotificacio(ActualitzarNotificacionDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback callback notificacio.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	// public void fallbackCallbackNotificacio(ActualitzarNotificacio
	// actualitzarNotificacio, MultipartFile docEvidenciaElectronic,
	// MultipartFile docEvidenciaPaper, Throwable e) throws
	// GPAServeisServiceException {
	// if (log.isDebugEnabled()) {
	// log.debug("fallbackCallbackNotificacio(ActualitzarNotificacionDocument,MultipartFile,
	// MultipartFile, Throwable) - inici"); //$NON-NLS-1$
	// }
	//
	// ServeisServiceExceptionHandler.handleException(e);
	// }

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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
			signaturesApi.callbackPortaSig(callbackPortaSig);

			if (log.isDebugEnabled()) {
				log.debug("callbackPortaSig(CallbackPortaSig) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("callbackPortaSig(CallbackPortaSig)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
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
	 * (non-Javadoc).
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
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
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the boolean
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * guardarDocumentEntradaGestorDocumental(es.bcn.gpa.gpaserveis.business.dto
	 * .documents .GuardarDocumentEntradaFitxerBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentEntradaGestorDocumental")
	public DocsEntradaRDTO guardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.guardarDocumentEntradaGestorDocumental(
			        guardarDocumentEntradaFitxerBDTO.getDocsEntradaRDTO(), guardarDocumentEntradaFitxerBDTO.getIdExpedient(),
			        guardarDocumentEntradaFitxerBDTO.getIdGestorDocumental());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("guardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Fallback guardar document entrada gestor documental.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackGuardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO,
	        Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentEntradaGestorDocumental(GuardarDocumentEntradaFitxerBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * guardarDocumentEntradaEscanejatGestorDocumental(es.bcn.gpa.gpaserveis.
	 * business.dto.documents.GuardarDocumentEntradaFitxerBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentEntradaEscanejatGestorDocumental")
	public DocsEntradaRDTO guardarDocumentEntradaEscanejatGestorDocumental(
	        GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentEntradaEscanejatGestorDocumental(GuardarDocumentEntradaFitxerBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.guardarDocumentEntradaEscanejatGestorDocumental(
			        guardarDocumentEntradaFitxerBDTO.getDocsEntradaRDTO(), guardarDocumentEntradaFitxerBDTO.getIdExpedient(),
			        guardarDocumentEntradaFitxerBDTO.getIdGestorDocumental());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentEntradaEscanejatGestorDocumental(GuardarDocumentEntradaFitxerBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (RestClientException e) {
			log.error("guardarDocumentEntradaEscanejatGestorDocumental(GuardarDocumentEntradaFitxerBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Fallback guardar document entrada escanejat gestor documental.
	 *
	 * @param guardarDocumentEntradaFitxerBDTO
	 *            the guardar document entrada fitxer BDTO
	 * @param e
	 *            the e
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackGuardarDocumentEntradaEscanejatGestorDocumental(
	        GuardarDocumentEntradaFitxerBDTO guardarDocumentEntradaFitxerBDTO, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentEntradaEscanejatGestorDocumental(GuardarDocumentEntradaFitxerBDTO, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * guardarDocumentSollicitudSignat(java.math.BigDecimal,
	 * java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentSollicitudSignat")
	public void guardarDocumentSollicitudSignat(BigDecimal documentacioIdext, BigDecimal signaturaSolicitud)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentSollicitudSignat(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.guardarDocumentSollicitudSignat(documentacioIdext, signaturaSolicitud);

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentSollicitudSignat(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("guardarDocumentSollicitudSignat(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Fallback guardar document sollicitud signat.
	 *
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @param signaturaSolicitud
	 *            the signatura solicitud
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackGuardarDocumentSollicitudSignat(BigDecimal documentacioIdext, BigDecimal signaturaSolicitud, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentSollicitudSignat(BigDecimal, BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * obrirRequerimentsExpedient(java.math.BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackObrirRequerimentsExpedient")
	public void obrirRequerimentsExpedient(BigDecimal idDocumentacio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obrirRequerimentsExpedient(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.obrirRequerimentsExpedient(idDocumentacio);

			if (log.isDebugEnabled()) {
				log.debug("obrirRequerimentsExpedient(BigDecimal) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("obrirRequerimentsExpedient(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback obrir requeriments expedient.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackObrirRequerimentsExpedient(BigDecimal idDocumentacio, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackObrirRequerimentsExpedient(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * obtenirEstatDigitalitzacioDocument(String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarEstatDigitalitzacio")
	public PeticionsDigitalitzacioRDTO consultarEstatDigitalitzacio(String idPeticio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirEstatDigitalitzacioDocument(Long) - inici"); //$NON-NLS-1$
		}

		try {
			PeticionsDigitalitzacioRDTO peticionsDigitalitzacioRDTO = documentacioApi.consultarEstatDigitalitzacio(idPeticio);

			if (log.isDebugEnabled()) {
				log.debug("obtenirEstatDigitalitzacioDocument(Long) - fi"); //$NON-NLS-1$
			}

			return peticionsDigitalitzacioRDTO;
		} catch (RestClientException e) {
			log.error("obtenirEstatDigitalitzacioDocument(Long)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}

	}

	/**
	 * Fallback consultar estat digitalitzacio.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @param e
	 *            the e
	 * @return the peticions digitalitzacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PeticionsDigitalitzacioRDTO fallbackConsultarEstatDigitalitzacio(String idPeticio, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarEstatDigitalitzacio(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * consultarDadesSignaturaByCodiPeticio(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDataSignaturaByCodiPeticio")
	public DadesSignatura consultarDadesSignaturaByCodiPeticio(String codiPeticio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("obtenirEstatDigitalitzacioDocument(Long) - inici"); //$NON-NLS-1$
		}

		try {
			DadesSignatura dadesSignatura = signaturesApi.consultarDadesSignatura(codiPeticio);

			if (log.isDebugEnabled()) {
				log.debug("obtenirEstatDigitalitzacioDocument(Long) - fi"); //$NON-NLS-1$
			}

			return dadesSignatura;
		} catch (RestClientException e) {
			log.error("obtenirEstatDigitalitzacioDocument(Long)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback Consultar data signatura by codi peticio.
	 *
	 * @param codiPeticio
	 *            the codi peticio
	 * @param e
	 *            the e
	 * @return the dades signatura
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DadesSignatura fallbackConsultarDataSignaturaByCodiPeticio(String codiPeticio, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackconsultarDataSignaturaByCodiPeticio(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * peticioAmbDocumentsSignats(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackPeticioAmbDocumentsSignats")
	public Boolean peticioAmbDocumentsSignats(String idPeticio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("peticioAmbDocumentsSignats(String) - inici"); //$NON-NLS-1$
		}

		try {
			Boolean peticioAmbDocumentsSignatsResponse = signaturesApi.peticioAmbDocumentsSignats(idPeticio);

			if (log.isDebugEnabled()) {
				log.debug("peticioAmbDocumentsSignats(String) - fi"); //$NON-NLS-1$
			}

			return peticioAmbDocumentsSignatsResponse;
		} catch (RestClientException e) {
			log.error("peticioAmbDocumentsSignats(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback peticio amb documents signats.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @param e
	 *            the e
	 * @return the boolean
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public Boolean fallbackPeticioAmbDocumentsSignats(String idPeticio, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackPeticioAmbDocumentsSignats(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#finalitzarSignaturaTablet
	 * (java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackFinalitzarSignaturaTablet")
	public void finalitzarSignaturaTablet(String idPeticio) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("finalitzarSignaturaTablet(String) - inici"); //$NON-NLS-1$
		}

		try {
			CallbackManuscrita callbackManuscrita = new CallbackManuscrita();
			callbackManuscrita.setIdPeticio(idPeticio);
			signaturesApi.finalitzarSignaturaTablet(callbackManuscrita);

			if (log.isDebugEnabled()) {
				log.debug("finalitzarSignaturaTablet(String) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("finalitzarSignaturaTablet(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback finalitzar signatura tablet.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackFinalitzarSignaturaTablet(String idPeticio, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackFinalitzarSignaturaTablet(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/**
	 * Fallback callback notificacio.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackIncrementarReintentsSignatura")
	public void incrementarReintentsSignatura(BigDecimal idDocument) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("incrementarReintentsSignatura(BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			signaturesApi.incrementarReintentsSignatura(idDocument);

			if (log.isDebugEnabled()) {
				log.debug("incrementarReintentsSignatura(BigDecimal) - fi"); //$NON-NLS-1$
			}
		} catch (RestClientException e) {
			log.error("incrementarReintentsSignatura(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback incrementar seintents signatura
	 *
	 * @param idDocument
	 *            the iddocument
	 * @param e
	 *            the e
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackIncrementarReintentsSignatura(BigDecimal idDocument, Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackIncrementarReintentsSignatura(BigDecimal, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * prepararSignaturaCriptograficaDocument(es.bcn.gpa.gpaserveis.rest.client.
	 * api.model.gpadocumentacio.PrepararSignaturaCriptograficaDocumentMassiu)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackPrepararSignaturaCriptograficaDocument")
	public PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptograficaDocument(
	        PrepararSignaturaCriptograficaDocumentMassiu prepararSignaturaCriptograficaDocumentMassiu) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("prepararSignaturaCriptograficaDocument(PrepararSignaturaCriptograficaDocumentMassiu) - inici"); //$NON-NLS-1$
		}

		try {
			PrepararSignaturaCriptograficaDocumentResponse prepararSignaturaCriptograficaDocumentResponse = signaturesApi
			        .prepararSignaturaCriptografica(prepararSignaturaCriptograficaDocumentMassiu);

			if (log.isDebugEnabled()) {
				log.debug("prepararSignaturaCriptograficaDocument(PrepararSignaturaCriptograficaDocumentMassiu) - fi"); //$NON-NLS-1$
			}
			return prepararSignaturaCriptograficaDocumentResponse;

		} catch (RestClientException e) {
			log.error("prepararSignaturaCriptograficaDocument(PrepararSignaturaCriptograficaDocumentMassiu)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback preparar signatura criptografica document.
	 *
	 * @param prepararSignaturaCriptograficaDocumentMassiu
	 *            the preparar signatura criptografica document massiu
	 * @param e
	 *            the e
	 * @return the preparar signatura criptografica document response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PrepararSignaturaCriptograficaDocumentResponse fallbackPrepararSignaturaCriptograficaDocument(
	        PrepararSignaturaCriptograficaDocumentMassiu prepararSignaturaCriptograficaDocumentMassiu, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackPrepararSignaturaCriptograficaDocument(PrepararSignaturaCriptograficaDocumentMassiu, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * signarCriptograficaDocument(es.bcn.gpa.gpaserveis.rest.client.api.model.
	 * gpadocumentacio.SignarCriptograficaDocument)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackSignarCriptograficaDocument")
	public SignarCriptograficaDocumentResponse signarCriptograficaDocument(SignarCriptograficaDocument signarCriptograficaDocument)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("signarCriptograficaDocument(SignarCriptograficaDocument) - inici"); //$NON-NLS-1$
		}

		try {
			SignarCriptograficaDocumentResponse signarCriptograficaDocumentResponse = signaturesApi
			        .signarCriptografica(signarCriptograficaDocument);

			if (log.isDebugEnabled()) {
				log.debug("signarCriptograficaDocument(SignarCriptograficaDocument) - fi"); //$NON-NLS-1$
			}

			return signarCriptograficaDocumentResponse;

		} catch (RestClientException e) {
			log.error("signarCriptograficaDocument(SignarCriptograficaDocument)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback signar criptografica document.
	 *
	 * @param signarCriptograficaDocument
	 *            the signar criptografica document
	 * @param e
	 *            the e
	 * @return the signar criptografica document response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public SignarCriptograficaDocumentResponse fallbackSignarCriptograficaDocument(SignarCriptograficaDocument signarCriptograficaDocument,
	        Throwable e) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSignarCriptograficaDocument(SignarCriptograficaDocument, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * consultarDadesDocumentGeneratPerIdGestorDocumental(java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarDadesDocumentGeneratPerIdGestorDocumental")
	public DocsTramitacioRDTO consultarDadesDocumentGeneratPerIdGestorDocumental(String idDocumentGestorDocumental)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarDadesDocumentGeneratPerIdGestorDocumental(String) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi
			        .consultarDadesDocumentGeneratPerIdGestorDocumental(idDocumentGestorDocumental);

			if (log.isDebugEnabled()) {
				log.debug("consultarDadesDocumentGeneratPerIdGestorDocumental(String) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;

		} catch (RestClientException e) {
			log.error("consultarDadesDocumentGeneratPerIdGestorDocumental(String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback consultar dades document generat per id gestor documental.
	 *
	 * @param idDocumentGestorDocumental
	 *            the id document gestor documental
	 * @param e
	 *            the e
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackConsultarDadesDocumentGeneratPerIdGestorDocumental(String idDocumentGestorDocumental, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocumentGeneratPerIdGestorDocumental(String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#consultarSignatura(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackConsultarSignatura")
	public ConsultarSignaturaResponse consultarSignatura(String idPeticio, String idDocumentGestorDocumental)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("consultarSignatura(String, String) - inici"); //$NON-NLS-1$
		}

		try {
			ConsultarSignaturaResponse consultarSignaturaResponse = signaturesApi.consultarSignatura(idDocumentGestorDocumental, idPeticio);

			if (log.isDebugEnabled()) {
				log.debug("consultarSignatura(String, String) - fi"); //$NON-NLS-1$
			}
			return consultarSignaturaResponse;

		} catch (RestClientException e) {
			log.error("consultarSignatura(String, String)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produ??t una incid??ncia", e);
		}
	}

	/**
	 * Fallback consultar signatura.
	 *
	 * @param idPeticio
	 *            the id peticio
	 * @param idDocumentGestorDocumental
	 *            the id document gestor documental
	 * @param e
	 *            the e
	 * @return the consultar signatura response
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public ConsultarSignaturaResponse fallbackConsultarSignatura(String idPeticio, String idDocumentGestorDocumental, Throwable e)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarSignatura(String, String, Throwable) - inici"); //$NON-NLS-1$
		}

		ServeisServiceExceptionHandler.handleException(e);

		return null;
	}

}
