package es.bcn.gpa.gpaserveis.web.rest.controller.helper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import es.bcn.gpa.gpaserveis.business.ServeisService;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.initialization.interceptor.ClientEntity;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;

public class ServeisRestControllerVisibilitatHelper {

	public static BigDecimal obtenirVisibilitatExpedient(ClientEntity clientEntity, ServeisService serveisService, String codiExpedient,
			String expedientsIdOrgan) throws GPAServeisServiceException, GPAApiParamValidationException {

		BigDecimal visibilitat = BigDecimal.ONE;

		validarCapçaleresUsuari(clientEntity, Resultat.ERROR_OBTENIR_EXPEDIENT);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			DadesExpedientBDTO dadesExpedientBDTO = serveisService.consultarDadesBasiquesPerVisibilitatExpedient(
					ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));

			// validamos que el usuario logado pertenezca al expediente
			String relacioTerceraPersona = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
					dadesExpedientBDTO.getPersonesInteressades(), dadesExpedientBDTO.getPersonesImplicades(),
					dadesExpedientBDTO.getSollicitant(), dadesExpedientBDTO.getRepresentant(), Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

			if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
						.consultarDadesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ProcedimentPersones procedimentPersones = ServeisRestControllerValidationHelper.validateVisibilitatImplicado(nifInteressat,
						relacioTerceraPersona, null, null, null, null, procedimentPersonesList, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

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
	public static BigDecimal obtenirVisibilitatSollicitud(ClientEntity clientEntity, ServeisService serveisService, BigDecimal idSollicitud)
			throws GPAServeisServiceException, GPAApiParamValidationException {

		BigDecimal visibilitat = BigDecimal.ONE;

		validarCapçaleresUsuari(clientEntity, Resultat.ERROR_OBTENIR_EXPEDIENT);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitudPerVisibilitat(idSollicitud);

			// validamos que el usuario logado pertenezca al expediente
			String relacioTerceraPersona = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
					dadesSollicitudBDTO.getPersonesInteressades(), dadesSollicitudBDTO.getPersonesImplicades(),
					dadesSollicitudBDTO.getSollicitant(), dadesSollicitudBDTO.getRepresentant(), Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

			if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
						.consultarDadesProcediment(dadesSollicitudBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ProcedimentPersones procedimentPersones = ServeisRestControllerValidationHelper.validateVisibilitatImplicado(nifInteressat,
						relacioTerceraPersona, null, null, null, null, procedimentPersonesList, Resultat.ERROR_ACTUALITZAR_EXPEDIENT);

				if (procedimentPersones != null) {
					visibilitat = procedimentPersones.getNivellVisibilitat();
				}
			}

		}

		return visibilitat;

	}

	/**
	 * @param respostaDadesOperacioCercaBDTO
	 * @param docsEntradaRDTO
	 * @param docsTramitacioRDTO
	 * @param dadesExpedientBDTO
	 * @throws GPAApiParamValidationException
	 * @throws GPAServeisServiceException
	 */
	public static void validateVisibilitatTerceresPersones(ClientEntity clientEntity, ServeisService serveisService,
			List<DadesOperacions> dadesActualizar, List<ConfiguracioDocsEntradaRDTO> configuacioActualizar, DocsEntradaRDTO docsEntradaRDTO,
			DocsTramitacioRDTO docsTramitacioRDTO, DadesExpedientBDTO dadesExpedientBDTO, Resultat resultatError)
			throws GPAApiParamValidationException, GPAServeisServiceException {

		validarCapçaleresUsuari(clientEntity, resultatError);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			String relacioTerceraPersona = "";

			relacioTerceraPersona = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
					dadesExpedientBDTO.getPersonesInteressades(), dadesExpedientBDTO.getPersonesImplicades(),
					dadesExpedientBDTO.getSollicitant(), dadesExpedientBDTO.getRepresentant(), resultatError);

			if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
						.consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ServeisRestControllerValidationHelper.validateVisibilitatImplicado(nifInteressat, relacioTerceraPersona, dadesActualizar,
						configuacioActualizar, docsEntradaRDTO, docsTramitacioRDTO, procedimentPersonesList, resultatError);
			}

		}
	}

	/**
	 * @param respostaDadesOperacioCercaBDTO
	 * @param docsEntradaRDTO
	 * @param dadesExpedientBDTO
	 * @throws GPAApiParamValidationException
	 * @throws GPAServeisServiceException
	 */
	public static void validateVisibilitatTerceresPersonesSollicitud(ClientEntity clientEntity, ServeisService serveisService,
			List<DadesOperacions> dadesActualizar, List<ConfiguracioDocsEntradaRDTO> configuacioActualizar, DocsEntradaRDTO docsEntradaRDTO,
			DocsTramitacioRDTO docsTramitacioRDTO, DadesSollicitudBDTO dadesSollicitudBDTO, Resultat resultatError)
			throws GPAApiParamValidationException, GPAServeisServiceException {

		validarCapçaleresUsuari(clientEntity, resultatError);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			String relacioTerceraPersona = "";

			relacioTerceraPersona = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
					dadesSollicitudBDTO.getPersonesInteressades(), dadesSollicitudBDTO.getPersonesImplicades(),
					dadesSollicitudBDTO.getSollicitant(), dadesSollicitudBDTO.getRepresentant(), resultatError);

			if (StringUtils.isNotEmpty(relacioTerceraPersona)) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
						.consultarDadesBasiquesProcediment(dadesSollicitudBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ServeisRestControllerValidationHelper.validateVisibilitatImplicado(nifInteressat, relacioTerceraPersona, dadesActualizar,
						configuacioActualizar, docsEntradaRDTO, docsTramitacioRDTO, procedimentPersonesList, resultatError);
			}

		}
	}

	public static void validarCapçaleresUsuari(ClientEntity clientEntity, Resultat resultatError) throws GPAApiParamValidationException {

		String usuariInteressat = clientEntity.getUsuariInteressat();
		String usuariAutenticat = clientEntity.getUsuariAutenticat();

		// TODO si no viene ninguna cabecera deberemos luego lanzar error, de
		// momento dejamos que siga funcionando
		if (StringUtils.isEmpty(usuariAutenticat) && StringUtils.isEmpty(usuariInteressat)) {
			// throw new GPAApiParamValidationException(resultatError,
			// ErrorPrincipal.ERROR_EXPEDIENTS_USUARIS_HEADER_NOT_FOUND);
		}
	}
}
