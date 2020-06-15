package es.bcn.gpa.gpaserveis.web.rest.controller.helper;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.documents.EsborrarDocumentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.ExpedientsRegistrarSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocumentActualizarRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearRegistre;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.CrearSollicitud;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RespostaCrearRegistreExpedient;

public class ServeisRestControllerSagaHelper {

	/** Logger for this class. */
	private static final Log LOGGER = LogFactory.getLog(ServeisRestControllerSagaHelper.class);

	public static void sagaRegistrarSolicitudExpedient(ServeisService serveisService, DadesExpedientBDTO dadesExpedientBDTO,
			RespostaCrearRegistreExpedient respostaCrearRegistreExpedient, boolean registreSollicitudAssociat,
			DocsTramitacioRDTO respostaCrearJustificant, DocumentActualizarRegistre documentActualizarRegistreRDTO,
			boolean registreDocumentacioAssociat) {

		try {
			if (registreSollicitudAssociat && respostaCrearRegistreExpedient != null
					&& respostaCrearRegistreExpedient.getRegistreAssentament() != null
					&& StringUtils.isNotEmpty(respostaCrearRegistreExpedient.getRegistreAssentament().getCodi())) {

				CrearRegistre registreCreacioSolicitudExpedient = new CrearRegistre();
				registreCreacioSolicitudExpedient.setExpedient(dadesExpedientBDTO.getExpedientsRDTO());
				ExpedientsRegistrarBDTO expedientsRegistrarBDTO = new ExpedientsRegistrarBDTO(registreCreacioSolicitudExpedient);

				serveisService.esborrarRegistre(expedientsRegistrarBDTO);
				// ponemos a nulo los valores para no incluirlos en la respuesta
				respostaCrearRegistreExpedient.getRegistreAssentament().setCodi(null);
				respostaCrearRegistreExpedient.getRegistreAssentament().setDataRegistre(null);
			}
			if (registreDocumentacioAssociat) {
				serveisService.desassociarRegistreDocumentacioExpedient(documentActualizarRegistreRDTO);
			}

			if (respostaCrearJustificant != null) {
				EsborrarDocumentBDTO esborrarDocumentExpedientBDTO = new EsborrarDocumentBDTO(
						dadesExpedientBDTO.getExpedientsRDTO().getId(), respostaCrearJustificant.getId());
				serveisService.esBorrarDocumentacioTramitacio(esborrarDocumentExpedientBDTO);

				// ponemos a nulo los valores para no incluirlos en la respuesta
				// (comprovant)
				respostaCrearJustificant.setId(null);

			}

		} catch (GPAServeisServiceException e1) {
			LOGGER.error(
					"sagaRegistrarSolicitudExpedient(DadesExpedientBDTO, RespostaCrearRegistreExpedient, DocsTramitacioRDTO, ExpedientsRegistrarBDTO, DocumentActualizarRegistre)",
					e1);// $NON-NLS-1$
		}
	}

	public static void sagaRegistrarSolicitud(ServeisService serveisService, DadesSollicitudBDTO dadesSollicitudBDTO,
			RespostaCrearRegistreExpedient respostaCrearRegistreExpedient, boolean registreSollicitudAssociat,
			DocsTramitacioRDTO respostaCrearJustificant, DocsEntActualizarRegistre docsEntActualizarRegistre,
			boolean registreDocumentacioAssociat, ArrayList<BigDecimal> idDocsEntradaList) {

		try {
			if (registreSollicitudAssociat && respostaCrearRegistreExpedient != null
					&& respostaCrearRegistreExpedient.getRegistreAssentament() != null
					&& StringUtils.isNotEmpty(respostaCrearRegistreExpedient.getRegistreAssentament().getCodi())) {

				CrearSollicitud registreCreacioSolicitud = new CrearSollicitud();
				registreCreacioSolicitud.setSollicitud(dadesSollicitudBDTO.getSollicitudsRDTO());
				ExpedientsRegistrarSollicitudBDTO expedientsRegistrarSollicitudBDTO = new ExpedientsRegistrarSollicitudBDTO(
						registreCreacioSolicitud);

				serveisService.esborrarRegistreSollicitud(expedientsRegistrarSollicitudBDTO);
				// ponemos a nulo los valores para no incluirlos en la respuesta
				respostaCrearRegistreExpedient.getRegistreAssentament().setCodi(null);
				respostaCrearRegistreExpedient.getRegistreAssentament().setDataRegistre(null);
			}
			if (registreDocumentacioAssociat && CollectionUtils.isNotEmpty(idDocsEntradaList) && respostaCrearRegistreExpedient != null) {

				// no borramos documentos, solo desasociamos el id de registro
				DocumentActualizarRegistre documentActualizarRegistreRDTO = null;
				for (BigDecimal idDocument : idDocsEntradaList) {

					documentActualizarRegistreRDTO = new DocumentActualizarRegistre();
					documentActualizarRegistreRDTO.setIdDoc(idDocument);
					documentActualizarRegistreRDTO.setIdRegistre(respostaCrearRegistreExpedient.getRegistreAssentament().getId());

					serveisService.desassociarRegistreDocumentacioExpedient(documentActualizarRegistreRDTO);
				}
			}

			if (respostaCrearJustificant != null) {
				EsborrarDocumentBDTO esborrarDocumentExpedientBDTO = new EsborrarDocumentBDTO(
						dadesSollicitudBDTO.getExpedientsRDTO().getId(), respostaCrearJustificant.getId());
				serveisService.esBorrarDocumentacioTramitacio(esborrarDocumentExpedientBDTO);

				// ponemos a nulo los valores para no incluirlos en la respuesta
				// (comprovant)
				respostaCrearJustificant.setId(null);

			}

		} catch (GPAServeisServiceException e1) {
			LOGGER.error(
					"sagaRegistrarSolicitud(DadesSollicitudBDTO , RespostaCrearRegistreExpedient, boolean, DocsTramitacioRDTO, DocsEntActualizarRegistre, boolean, ArrayList<BigDecimal>)",
					e1);// $NON-NLS-1$
		}
	}
}
