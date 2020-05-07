package es.bcn.gpa.gpaserveis.web.rest.controller.helper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.RespostaDadesOperacioCercaBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
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

			DadesExpedientBDTO dadesExpedientBDTO = serveisService.consultarDadesBasiquesPerVisibilitatExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));

			// validamos que el usuario logado pertenezca al expediente
			String relacioTerceraPersona = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(
					dadesExpedientBDTO.getPersonesInteressades(), dadesExpedientBDTO.getPersonesImplicades(),
					dadesExpedientBDTO.getExpedientsRDTO().getSollicitantPrincipal(),
					dadesExpedientBDTO.getExpedientsRDTO().getRepresentantPrincipal(), Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

			if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
						.consultarDadesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ProcedimentPersones procedimentPersones = ServeisRestControllerValidationHelper.validateVisibilitatImplicado(
						relacioTerceraPersona, null, procedimentPersonesList, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

				if (procedimentPersones != null) {
					visibilitat = procedimentPersones.getNivellVisibilitat();
				}
			}
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
	 * @param dadesExpedientBDTO
	 * @throws GPAApiParamValidationException
	 * @throws GPAServeisServiceException
	 */
	public static void validateVisibilitatTerceresPersones(ServeisService serveisService,
			RespostaDadesOperacioCercaBDTO respostaDadesOperacioCercaBDTO, DadesExpedientBDTO dadesExpedientBDTO, Resultat resultatError)
			throws GPAApiParamValidationException, GPAServeisServiceException {

		// TODO GPA-2923 (se controla la ejecucion de la validacion hasta que
		// tengamos datos del usuario)
		ImiUserDetails imiUser = SecurityUtils.getLoggedUserDetails();
		if (imiUser != null && !imiUser.getUsername().equals("T000000")) {

			String relacioTerceraPersona = "";

			relacioTerceraPersona = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(
					dadesExpedientBDTO.getPersonesInteressades(), dadesExpedientBDTO.getPersonesImplicades(),
					dadesExpedientBDTO.getExpedientsRDTO().getSollicitantPrincipal(),
					dadesExpedientBDTO.getExpedientsRDTO().getRepresentantPrincipal(), resultatError);

			// pruebas relacioTerceraPersona =
			// dadesExpedientBDTO.getPersonesImplicades().get(0).getRelacioImplicada();

			if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
						.consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ServeisRestControllerValidationHelper.validateVisibilitatImplicado(relacioTerceraPersona, respostaDadesOperacioCercaBDTO,
						procedimentPersonesList, resultatError);
			}
		}
	}
}
