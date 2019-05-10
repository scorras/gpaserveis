package es.bcn.gpa.gpaserveis.business.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.dto.documents.AportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DescarregarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsTramitacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.IncorporarNouDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.IncorporarNouDocumentTramitacioExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.PrepararRequerimentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.SubstituirDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.UploadDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DocumentAportatValidarBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioRequeritApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DownloadEntradaApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaPlantillaDocVinculada;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaUploadDocumentExpedient;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class DocumentsServiceImpl.
 */
@Service

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

	/** The download entrada api. */
	@Autowired
	private DownloadEntradaApi downloadEntradaApi;

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
		} catch (ApiException e) {
			log.error("cercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio entrada.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfConfiguracioDocsEntradaRDTO fallbackCercaConfiguracioDocumentacioEntrada(
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioEntrada(DocumentsEntradaCercaBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
		} catch (ApiException e) {
			log.error("cercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsEntradaCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio entrada per tramit ovt.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfConfiguracioDocsEntradaRDTO fallbackCercaConfiguracioDocumentacioEntradaPerTramitOvt(
	        DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioEntradaPerTramitOvt(DocumentsEntradaCercaBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
			        .getConfiguracioDocumentacioTramitacioUsingGET(documentsTramitacioCercaBDTO.getIdConfiguracioDocumentacio(), null, null,
			                null, null, null, null, null, null, null, null, null, null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfConfiguracioDocsTramitacioRDTO;
		} catch (ApiException e) {
			log.error("cercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio tramitacio.
	 *
	 * @param documentsTramitacioCercaBDTO
	 *            the documents tramitacio cerca BDTO
	 * @return the page data of configuracio docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfConfiguracioDocsTramitacioRDTO fallbackCercaConfiguracioDocumentacioTramitacio(
	        DocumentsTramitacioCercaBDTO documentsTramitacioCercaBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioTramitacio(DocumentsTramitacioCercaBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
		} catch (ApiException e) {
			log.error("cercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca documents entrada agrupats per tramit ovt.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<DocsEntradaRDTO> fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal idDocumentacio)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDocumentsEntradaAgrupatsPerTramitOvt(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
		} catch (ApiException e) {
			log.error("cercaConfiguracioDocumentacioEntradaRequerida(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca configuracio documentacio entrada requerida.
	 *
	 * @param idDocumentacio
	 *            the id documentacio
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<ConfDocEntradaRequeritRDTO> fallbackCercaConfiguracioDocumentacioEntradaRequerida(BigDecimal idDocumentacio)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaConfiguracioDocumentacioEntradaRequerida(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * aportarDocumentacioExpedient(es.bcn.gpa.gpaserveis.business.dto.documents
	 * .AportarDocumentExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackAportarDocumentacioExpedient")
	public RespostaAportarDocumentacioExpedientRDTO aportarDocumentacioExpedient(AportarDocumentExpedientBDTO aportarDocumentExpedientBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("aportarDocumentacioExpedient(AportarDocumentacioExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			RespostaAportarDocumentacioExpedientRDTO respostaAportarDocumentacioExpedientRDTO = documentacioApi
			        .aportarDocumentacioExpedient(aportarDocumentExpedientBDTO.getAportarDocumentacioExpedient(),
			                aportarDocumentExpedientBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("aportarDocumentacioExpedient(AportarDocumentacioExpedientBDTO) - fi"); //$NON-NLS-1$
			}
			return respostaAportarDocumentacioExpedientRDTO;
		} catch (ApiException e) {
			log.error("aportarDocumentacioExpedient(AportarDocumentacioExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback aportar documentacio expedient.
	 *
	 * @param aportarDocumentExpedientBDTO
	 *            the aportar document expedient BDTO
	 * @return the resposta aportar documentacio expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public RespostaAportarDocumentacioExpedientRDTO fallbackAportarDocumentacioExpedient(
	        AportarDocumentExpedientBDTO aportarDocumentExpedientBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackAportarDocumentacioExpedient(AportarDocumentacioExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.bcn.gpa.gpaserveis.business.DocumentsService#
	 * substituirDocumentExpedient(es.bcn.gpa.gpaserveis.business.dto.documents.
	 * SubstituirDocumentExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackSubstituirDocumentExpedient")
	public RespostaSubstituirDocumentExpedientRDTO substituirDocumentExpedient(
	        SubstituirDocumentExpedientBDTO substituirDocumentExpedientBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("substituirDocumentExpedient(SubstituirDocumentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			RespostaSubstituirDocumentExpedientRDTO respostaSubstituirDocumentExpedientRDTO = documentacioApi.substituirDocumentExpedient(
			        substituirDocumentExpedientBDTO.getIdExpedient(), substituirDocumentExpedientBDTO.getSubstituirDocumentExpedient());

			if (log.isDebugEnabled()) {
				log.debug("substituirDocumentExpedient(SubstituirDocumentExpedientBDTO) - fi"); //$NON-NLS-1$
			}
			return respostaSubstituirDocumentExpedientRDTO;
		} catch (ApiException e) {
			log.error("substituirDocumentExpedient(SubstituirDocumentExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback substituir document expedient.
	 *
	 * @param substituirDocumentExpedientBDTO
	 *            the substituir document expedient BDTO
	 * @return the resposta substituir document expedient RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public RespostaSubstituirDocumentExpedientRDTO fallbackSubstituirDocumentExpedient(
	        SubstituirDocumentExpedientBDTO substituirDocumentExpedientBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSubstituirDocumentExpedient(SubstituirDocumentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#esborrarDocumentExpedient
	 * (es.bcn.gpa.gpaserveis.business.dto.documents.
	 * EsborrarDocumentExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackEsborrarDocumentExpedient")
	public void esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO esborrarDocumentExpedientBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			documentacioApi.esborrarDocumentExpedient(esborrarDocumentExpedientBDTO.getIdDocumentList(),
			        esborrarDocumentExpedientBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO) - fi"); //$NON-NLS-1$
			}
		} catch (ApiException e) {
			log.error("esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback esborrar document expedient.
	 *
	 * @param esborrarDocumentExpedientBDTO
	 *            the esborrar document expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackEsborrarDocumentExpedient(EsborrarDocumentExpedientBDTO esborrarDocumentExpedientBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackEsborrarDocumentExpedient(EsborrarDocumentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
		} catch (ApiException e) {
			log.error("consultarDadesDocumentAportat(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades document aportat.
	 *
	 * @param id
	 *            the id
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackConsultarDadesDocumentAportat(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocumentAportat(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
		} catch (ApiException e) {
			log.error("consultarDadesDocumentGenerat(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback consultar dades document generat.
	 *
	 * @param id
	 *            the id
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackConsultarDadesDocumentGenerat(BigDecimal id) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackConsultarDadesDocumentGenerat(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
			log.debug("descarregarDocumentExpedient(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		try {
			byte[] documentByteArray = downloadEntradaApi.descarregarDocumentExpedient(descarregarDocumentExpedientBDTO.getIdDocument(),
			        descarregarDocumentExpedientBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("descarregarDocumentExpedient(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}
			return documentByteArray;
		} catch (ApiException e) {
			log.error("descarregarDocumentExpedient(BigDecimal, BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback descarregar document expedient.
	 *
	 * @param descarregarDocumentExpedientBDTO
	 *            the descarregar document expedient BDTO
	 * @return the byte[]
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public byte[] fallbackDescarregarDocumentExpedient(DescarregarDocumentExpedientBDTO descarregarDocumentExpedientBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackDescarregarDocumentExpedient(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#uploadDocumentExpedient(
	 * es.bcn.gpa.gpaserveis.business.dto.documents.UploadDocumentExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackUploadDocumentExpedient")
	public RespostaUploadDocumentExpedient uploadDocumentExpedient(UploadDocumentExpedientBDTO uploadDocumentExpedientRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("uploadDocumentExpedient(UploadDocumentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			RespostaUploadDocumentExpedient respostaUploadDocumentExpedient = documentacioApi.uploadDocumentExpedient(
			        uploadDocumentExpedientRDTO.getIdExpedient(), uploadDocumentExpedientRDTO.getUploadDocumentExpedient());

			if (log.isDebugEnabled()) {
				log.debug("uploadDocumentExpedient(UploadDocumentExpedientBDTO) - fi"); //$NON-NLS-1$
			}
			return respostaUploadDocumentExpedient;
		} catch (ApiException e) {
			log.error("uploadDocumentExpedient(UploadDocumentExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e.getMessage());
		}
	}

	/**
	 * Fallback upload document expedient.
	 *
	 * @param uploadDocumentExpedientRDTO
	 *            the upload document expedient RDTO
	 * @param e
	 *            the e
	 * @return the resposta upload document expedient
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public RespostaUploadDocumentExpedient fallbackUploadDocumentExpedient(UploadDocumentExpedientBDTO uploadDocumentExpedientRDTO,
	        Throwable e) throws GPAServeisServiceException, JsonParseException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackUploadDocumentExpedient(UploadDocumentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		JsonParser parser = factory.createParser(e.getMessage());
		JsonNode actualObj = mapper.readTree(parser);
		ObjectReader reader = mapper.readerFor(new TypeReference<String>() {
		});
		String message = String.valueOf(reader.readValue(actualObj.get("errorMessage")));

		throw new GPAServeisServiceException(message);
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
		} catch (ApiException e) {
			log.error("cercaDadesOperacioRequerits(BigDecimal)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca dades operacio requerits.
	 *
	 * @param documentacioIdext
	 *            the documentacio idext
	 * @return the list
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public List<BigDecimal> fallbackCercaDadesOperacioRequerits(BigDecimal documentacioIdext) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDadesOperacioRequerits(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
		} catch (ApiException e) {
			log.error("revisarDocumentacioEntrada(DocumentAportatValidarBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback revisar documentacio entrada.
	 *
	 * @param documentAportatValidarBDTO
	 *            the document aportat validar BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackRevisarDocumentacioEntrada(DocumentAportatValidarBDTO documentAportatValidarBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackRevisarDocumentacioEntrada(DocumentAportatValidarBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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
			RespostaPlantillaDocVinculada respostaPlantillaDocVinculada = configuracioDocumentacioApi.getPlantillaDocVinculada(idConfDoc,
			        idDocVinculada);

			if (log.isDebugEnabled()) {
				log.debug("getPlantillaDocVinculada(BigDecimal, BigDecimal) - fi"); //$NON-NLS-1$
			}

			return respostaPlantillaDocVinculada;
		} catch (ApiException e) {
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
	 * @return the resposta plantilla doc vinculada
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public RespostaPlantillaDocVinculada fallbackGetPlantillaDocVinculada(BigDecimal idConfDoc, BigDecimal idDocVinculada)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGetPlantillaDocVinculada(BigDecimal, BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#guardarDocumentEntrada(es
	 * .bcn.gpa.gpaserveis.business.dto.documents.
	 * IncorporarNouDocumentEntradaExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentEntrada")
	public DocsEntradaRDTO guardarDocumentEntrada(IncorporarNouDocumentEntradaExpedientBDTO incorporarNouDocumentEntradaExpedientBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentEntrada(IncorporarNouDocumentEntradaExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsEntradaRDTO docsEntradaRDTO = documentacioApi.guardarDocumentEntrada(
			        incorporarNouDocumentEntradaExpedientBDTO.getDocsEntradaRDTO(),
			        incorporarNouDocumentEntradaExpedientBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentEntrada(IncorporarNouDocumentEntradaExpedientBDTO) - fi"); //$NON-NLS-1$
			}
			return docsEntradaRDTO;
		} catch (ApiException e) {
			log.error("guardarDocumentEntrada(IncorporarNouDocumentEntradaExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback guardar document entrada.
	 *
	 * @param incorporarNouDocumentEntradaExpedientBDTO
	 *            the incorporar nou document entrada expedient BDTO
	 * @return the docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsEntradaRDTO fallbackGuardarDocumentEntrada(
	        IncorporarNouDocumentEntradaExpedientBDTO incorporarNouDocumentEntradaExpedientBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentEntrada(IncorporarNouDocumentEntradaExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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

		} catch (ApiException e) {
			log.error("associarRegistreDocumentacioExpedient(DocumentActualizarRegistre)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException(e);
		}

	}

	/**
	 * Fallback associar registre documentacio expedient.
	 *
	 * @param documentActualizarRegistreRDTO
	 *            the document actualizar registre RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackAssociarRegistreDocumentacioExpedient(DocumentActualizarRegistre documentActualizarRegistreRDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackaAssociarRegistreDocumentacioExpedient(DocumentActualizarRegistre) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
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

		} catch (ApiException e) {
			log.error("associarRegistreDocsEnt(DocsEntActualizarRegistre)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback associar registre docs ent.
	 *
	 * @param docsEntActualizarRegistre
	 *            the docs ent actualizar registre
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackAssociarRegistreDocsEnt(DocsEntActualizarRegistre docsEntActualizarRegistre) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackaAssociarRegistreDocsEnt(DocsEntActualizarRegistre) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#signarDocument(java.math.
	 * BigDecimal)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackSignarDocument")
	public void signarDocument(BigDecimal idDocument) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("signarDocument(BigDecimal) - inici"); //$NON-NLS-1$
		}

		// TODO: IMPLEMENTAR LLAMADA A DOCUMENTS

		if (log.isDebugEnabled()) {
			log.debug("signarDocument(BigDecimal) - fi"); //$NON-NLS-1$
		}
	}

	/**
	 * Fallback signar document.
	 *
	 * @param idDocument
	 *            the id document
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public void fallbackSignarDocument(BigDecimal idDocument) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackSignarDocument(BigDecimal) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#guardarDocumentTramitacio
	 * (es.bcn.gpa.gpaserveis.business.dto.documents.
	 * IncorporarNouDocumentTramitacioExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarDocumentTramitacio")
	public DocsTramitacioRDTO guardarDocumentTramitacio(
	        IncorporarNouDocumentTramitacioExpedientBDTO incorporarNouDocumentTramitacioExpedientBDTO) throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarDocumentTramitacio(IncorporarNouDocumentTramitacioExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.guardarDocumentTramitacio(
			        incorporarNouDocumentTramitacioExpedientBDTO.getDocsTramitacioRDTO(),
			        incorporarNouDocumentTramitacioExpedientBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("guardarDocumentTramitacio(IncorporarNouDocumentTramitacioExpedientBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (ApiException e) {
			log.error("guardarDocumentTramitacio(IncorporarNouDocumentTramitacioExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback guardar document tramitacio.
	 *
	 * @param incorporarNouDocumentTramitacioExpedientBDTO
	 *            the incorporar nou document tramitacio expedient BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackGuardarDocumentTramitacio(
	        IncorporarNouDocumentTramitacioExpedientBDTO incorporarNouDocumentTramitacioExpedientBDTO, Throwable e)
	        throws GPAServeisServiceException, JsonParseException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarDocumentTramitacio(IncorporarNouDocumentTramitacioExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getFactory();
		JsonParser parser = factory.createParser(e.getMessage());
		JsonNode actualObj = mapper.readTree(parser);
		ObjectReader reader = mapper.readerFor(new TypeReference<String>() {
		});
		String message = String.valueOf(reader.readValue(actualObj.get("errorMessage")));

		throw new GPAServeisServiceException(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#guardarRequeriment(es.bcn
	 * .gpa.gpaserveis.business.dto.documents.PrepararRequerimentExpedientBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackGuardarRequeriment")
	public DocsTramitacioRDTO guardarRequeriment(PrepararRequerimentExpedientBDTO prepararRequerimentExpedientBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("guardarRequeriment(PrepararRequerimentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			DocsTramitacioRDTO docsTramitacioRDTO = documentacioApi.guardarRequeriment(
			        prepararRequerimentExpedientBDTO.getGuardarRequerimentExpedient(), prepararRequerimentExpedientBDTO.getIdExpedient());

			if (log.isDebugEnabled()) {
				log.debug("guardarRequeriment(PrepararRequerimentExpedientBDTO) - fi"); //$NON-NLS-1$
			}
			return docsTramitacioRDTO;
		} catch (ApiException e) {
			log.error("guardarRequeriment(PrepararRequerimentExpedientBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback guardar requeriment.
	 *
	 * @param prepararRequerimentExpedientBDTO
	 *            the preparar requeriment expedient BDTO
	 * @return the docs tramitacio RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public DocsTramitacioRDTO fallbackGuardarRequeriment(PrepararRequerimentExpedientBDTO prepararRequerimentExpedientBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackGuardarRequeriment(PrepararRequerimentExpedientBDTO) - inici"); //$NON-NLS-1$
		}

		throw new GPAServeisServiceException("El servei de documentacio no està disponible");
	}
}
