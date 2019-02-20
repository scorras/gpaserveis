package es.bcn.gpa.gpaserveis.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.bcn.gpa.gpaserveis.business.DocumentsService;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.ConfiguracioDocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.gpadocumentacio.DocumentacioApi;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.invoker.gpadocumentacio.ApiException;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class DocumentsServiceImpl.
 */
@Service

/** The Constant log. */
@CommonsLog
public class DocumentsServiceImpl implements DocumentsService {

	/** The configuracio documentacio api. */
	@Autowired
	private ConfiguracioDocumentacioApi configuracioDocumentacioApi;

	/** The documentacio api. */
	@Autowired
	private DocumentacioApi documentacioApi;

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
			        .cercaConfiguracioDocumentacioEntrada1(documentsEntradaCercaBDTO.getIdConfiguracioDocumentacio(),
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
}
