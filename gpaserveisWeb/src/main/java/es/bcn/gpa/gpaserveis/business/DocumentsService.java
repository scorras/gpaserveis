package es.bcn.gpa.gpaserveis.business;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.dto.documents.AportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.DocumentsEntradaCercaBDTO;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PageDataOfConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.RespostaAportarDocumentacioExpedientRDTO;

/**
 * The Interface DocumentsService.
 */
public interface DocumentsService {

	/**
	 * Cerca documents entrada.
	 *
	 * @param documentsEntradaCercaBDTO
	 *            the documents entrada cerca BDTO
	 * @return the page data of configuracio docs entrada RDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	PageDataOfConfiguracioDocsEntradaRDTO cercaDocumentsEntrada(DocumentsEntradaCercaBDTO documentsEntradaCercaBDTO)
	        throws GPAServeisServiceException;

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
	 * Esborrar document expedient.
	 *
	 * @param esborrarDocumentExpedientBDTO
	 *            the esborrar document expedient BDTO
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 */
	void esborrarDocumentExpedient(EsborrarDocumentExpedientBDTO esborrarDocumentExpedientBDTO) throws GPAServeisServiceException;

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
}
