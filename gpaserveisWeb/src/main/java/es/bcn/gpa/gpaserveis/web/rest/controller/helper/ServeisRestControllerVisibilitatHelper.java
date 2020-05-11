package es.bcn.gpa.gpaserveis.web.rest.controller.helper;

import java.math.BigDecimal;
import java.util.List;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import net.opentrends.openframe.services.security.core.userdetails.ImiUserDetails;
import net.opentrends.openframe.services.security.util.SecurityUtils;

public class ServeisRestControllerVisibilitatHelper {

	public static BigDecimal obtenirVisibilitatExpedient(ServeisService serveisService, String codiExpedient, String expedientsIdOrgan)
			throws GPAServeisServiceException, GPAApiParamValidationException {

		BigDecimal visibilitat = BigDecimal.ONE;

		// TODO GPA-2923 (se controla la ejecucion de la validacion hasta que
		// tengamos datos del usuario)
		ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
		if (imiUser != null && !imiUser.getUsername().equals("T000000")) {

			// TODO GPA-2923 descomentar cuando obtengamos la info del usuario
			// que hace la peticion
			/*
			 * DadesExpedientBDTO dadesExpedientBDTO =
			 * serveisService.consultarDadesBasiquesPerVisibilitatExpedient(
			 * ExpedientsApiParamToInternalMapper.getCodiInternalValue(
			 * codiExpedient, expedientsIdOrgan));
			 * 
			 * // validamos que el usuario logado pertenezca al expediente
			 * String relacioTerceraPersona =
			 * ServeisRestControllerValidationHelper.
			 * validateUsuariLogueadoExpedient(
			 * dadesExpedientBDTO.getPersonesInteressades(),
			 * dadesExpedientBDTO.getPersonesImplicades(),
			 * dadesExpedientBDTO.getExpedientsRDTO().getSollicitantPrincipal(),
			 * dadesExpedientBDTO.getExpedientsRDTO().getRepresentantPrincipal()
			 * , Resultat.ERROR_ACTUALITZAR_EXPEDIENT);
			 * 
			 * if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
			 * DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			 * .consultarDadesProcediment(dadesExpedientBDTO.getExpedientsRDTO()
			 * .getProcedimentIdext());
			 * 
			 * List<ProcedimentPersones> procedimentPersonesList =
			 * dadesProcedimentBDTO.getProcedimentsRDTO().
			 * getProcedimentPersonesList();
			 * 
			 * ProcedimentPersones procedimentPersones =
			 * ServeisRestControllerValidationHelper.
			 * validateVisibilitatImplicado( relacioTerceraPersona, null, null,
			 * null, procedimentPersonesList,
			 * Resultat.ERROR_ACTUALITZAR_EXPEDIENT);
			 * 
			 * if (procedimentPersones != null) { visibilitat =
			 * procedimentPersones.getNivellVisibilitat(); } }
			 */
		}

		return visibilitat;
	}

	/**
	 * Obtenir visibilitat sollicitud.
	 *
	 * @param serveisService
	 *            the serveis service
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param expedientsIdOrgan
	 *            the expedients id organ
	 * @return the big decimal
	 * @throws GPAServeisServiceException
	 *             the GPA serveis service exception
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static BigDecimal obtenirVisibilitatSollicitud(ServeisService serveisService, BigDecimal idSollicitud, String expedientsIdOrgan)
			throws GPAServeisServiceException, GPAApiParamValidationException {

		DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitudPerVisibilitat(idSollicitud);

		return obtenirVisibilitatExpedient(serveisService, dadesSollicitudBDTO.getExpedientsRDTO().getCodi(), expedientsIdOrgan);
	}

	/**
	 * @param respostaDadesOperacioCercaBDTO
	 * @param docsEntradaRDTO
	 * @param dadesExpedientBDTO
	 * @throws GPAApiParamValidationException
	 * @throws GPAServeisServiceException
	 */
	public static void validateVisibilitatTerceresPersones(ServeisService serveisService, List<DadesOperacions> dadesActualizar,
			List<ConfiguracioDocsEntradaRDTO> configuacioActualizar, DocsEntradaRDTO docsEntradaRDTO, DadesExpedientBDTO dadesExpedientBDTO,
			Resultat resultatError) throws GPAApiParamValidationException, GPAServeisServiceException {

		// TODO GPA-2923 (se controla la ejecucion de la validacion hasta que
		// tengamos datos del usuario)
		ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
		if (imiUser != null && !imiUser.getUsername().equals("T000000")) {

			// TODO GPA-2923 descomentar cuando obtengamos la info del usuario
			// que hace la peticion
			/*
			 * String relacioTerceraPersona = "";
			 * 
			 * relacioTerceraPersona = ServeisRestControllerValidationHelper.
			 * validateUsuariLogueadoExpedient(
			 * dadesExpedientBDTO.getPersonesInteressades(),
			 * dadesExpedientBDTO.getPersonesImplicades(),
			 * dadesExpedientBDTO.getExpedientsRDTO().getSollicitantPrincipal(),
			 * dadesExpedientBDTO.getExpedientsRDTO().getRepresentantPrincipal()
			 * , resultatError);
			 * 
			 * // pruebas relacioTerceraPersona = //
			 * dadesExpedientBDTO.getPersonesImplicades().get(0).
			 * getRelacioImplicada();
			 * 
			 * if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
			 * DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
			 * .consultarDadesBasiquesProcediment(dadesExpedientBDTO.
			 * getExpedientsRDTO().getProcedimentIdext());
			 * 
			 * List<ProcedimentPersones> procedimentPersonesList =
			 * dadesProcedimentBDTO.getProcedimentsRDTO().
			 * getProcedimentPersonesList();
			 * 
			 * ServeisRestControllerValidationHelper.
			 * validateVisibilitatImplicado(relacioTerceraPersona,
			 * dadesActualizar, configuacioActualizar, docsEntradaRDTO,
			 * procedimentPersonesList, resultatError); }
			 */
		}
	}
}
