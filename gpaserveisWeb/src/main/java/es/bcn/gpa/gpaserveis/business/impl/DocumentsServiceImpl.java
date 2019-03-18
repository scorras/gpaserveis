package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.dto.documents.AportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.SubstituirDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioRequeritApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaSubstituirDocumentExpedientRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class DocumentsServiceImpl.
 */
@Service

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.business.DocumentsService#cercaDocumentsEntrada(es.
	 * bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO)
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackCercaDocumentsEntrada")
	public PageDataOfConfiguracioDocsEntradaRDTO cercaDocumentsEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("cercaDocumentsEntrada(DocumentsEntradaCercaBDTO) - inici"); //$NON-NLS-1$
		}

		try {
			PageDataOfConfiguracioDocsEntradaRDTO pageDataOfConfiguracioDocsEntradaRDTO = configuracioDocumentacioApi
			        .cercaConfiguracioDocumentacioEntradaPerTramitOvt(documentsEntradaCercaBDTO.getIdConfiguracioDocumentacio(),
			                documentsEntradaCercaBDTO.getIdTramitOvt(), null, null, null, null, null, null, null, null, null, null, null,
			                null, null, null);

			if (log.isDebugEnabled()) {
				log.debug("cercaDocumentsEntrada(DocumentsEntradaCercaBDTO) - fi"); //$NON-NLS-1$
			}
			return pageDataOfConfiguracioDocsEntradaRDTO;
		} catch (ApiException e) {
			log.error("cercaDocumentsEntrada(DocumentsEntradaCercaBDTO)", e); //$NON-NLS-1$

			throw new GPAServeisServiceException("S'ha produït una incidència", e);
		}
	}

	/**
	 * Fallback cerca documents entrada.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	public PageDataOfConfiguracioDocsEntradaRDTO fallbackCercaDocumentsEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException {
		if (log.isDebugEnabled()) {
			log.debug("fallbackCercaDocumentsEntrada(DocumentsEntradaCercaBDTO) - inici"); //$NON-NLS-1$
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

}
