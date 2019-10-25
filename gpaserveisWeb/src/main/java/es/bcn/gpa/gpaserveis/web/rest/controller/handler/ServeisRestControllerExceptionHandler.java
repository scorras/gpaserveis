package es.bcn.gpa.gpaserveis.web.rest.controller.handler;

import es.bcn.gpa.gpaserveis.business.dto.RespostaResultatBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import lombok.extern.apachecommons.CommonsLog;

/** The Constant log. */
@CommonsLog
public class ServeisRestControllerExceptionHandler {

	/**
	 * Handle exception.
	 *
	 * @param errorResultat
	 *            the error resultat
	 * @param e
	 *            the e
	 * @return the resposta resultat BDTO
	 */
	public static RespostaResultatBDTO handleException(Resultat errorResultat, Exception e) {
		if (log.isDebugEnabled()) {
			log.debug("handleException(Resultat, Exception) - inici"); //$NON-NLS-1$
		}
		RespostaResultatBDTO respostaResultatBDTO = null;

		if (e.getMessage() != null) {
			if (e.getMessage().contains(Constants.MISSATGE_ERROR_ARIADNA)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_ARIADNA, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_CATALEG)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_CATALEG, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_CTRLUSER)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_CTRLUSER, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_DIGITALITZACIO)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_DIGITALITZACIO, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_GEOCOD)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_GEOCOD, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_NOTIFICADOR)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_NOTIFICADOR, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_OPENTEXT)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_OPENTEXT, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_PDFGESTOR)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_PDFGESTOR, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_PORTASIG)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_PORTASIG, e.getMessage());

			} else if (e.getMessage().contains(Constants.MISSATGE_ERROR_SIGNATURES)) {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_SIGNATURES, e.getMessage());

			} else {
				respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_GENERIC);
			}
		} else {
			log.warn("handleException", e);
			respostaResultatBDTO = new RespostaResultatBDTO(errorResultat, ErrorPrincipal.ERROR_GENERIC);
		}
		if (log.isDebugEnabled()) {
			log.debug("handleException(Resultat, Exception) - fi"); //$NON-NLS-1$
		}
		return respostaResultatBDTO;

	}

}
