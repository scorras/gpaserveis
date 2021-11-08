package es.bcn.gpa.gpaserveis.web.rest.controller.helper;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

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
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.initialization.interceptor.ClientEntity;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.ExpedientsApiParamToInternalMapper;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class ServeisRestControllerVisibilitatHelper {

	public static BigDecimal obtenirVisibilitatExpedient(ClientEntity clientEntity, ServeisService serveisService, String codiExpedient,
	        String expedientsIdOrgan, Resultat resultatError) throws GPAServeisServiceException, GPAApiParamValidationException {

		BigDecimal visibilitat = BigDecimal.ONE;

		validarCapsUsuari(clientEntity, Resultat.ERROR_OBTENIR_EXPEDIENT);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			DadesExpedientBDTO dadesExpedientBDTO = serveisService.consultarDadesBasiquesPerVisibilitatExpedient(
			        ExpedientsApiParamToInternalMapper.getCodiInternalValue(codiExpedient, expedientsIdOrgan));

			// validamos que el usuario logado pertenezca al expediente
			PersonesSollicitudRDTO implicado = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
			        dadesExpedientBDTO.getPersonesInteressades(), dadesExpedientBDTO.getPersonesImplicades(),
			        dadesExpedientBDTO.getSollicitant(), dadesExpedientBDTO.getRepresentant(), resultatError);

			if (implicado != null && StringUtils.isNotEmpty(implicado.getRelacioImplicada())) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
				        .consultarDadesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ProcedimentPersones procedimentPersones = ServeisRestControllerValidationHelper.validateVisibilitatImplicado(implicado,
				        null, null, null, null, procedimentPersonesList, null, resultatError);

				if (procedimentPersones != null
				        && procedimentPersones.getNivellVisibilitat().compareTo(Constants.NIVELL_VISIBILITAT_BAIXA) == 0) {
					visibilitat = BigDecimal.ZERO;
				}

				// Comprobar si tiene la visibilidadOVT
				// activada
				if (implicado.getVisibilitatOvt() == null || implicado.getVisibilitatOvt().compareTo(INTEGER_ZERO) == 0) {
					// Se habilita un campo Visibilidad a OVT en el detalle de
					// cada persona implicada en el
					// expediente que puede ser activado o desactivado por las
					// unidades gestoras en cualquier momento de la tramitacion
					// y que
					// proporciona o saca respectivamente el acceso a la
					// visibilidad del expediente desde el portal de la
					// documentacion y los datos
					// de operación configuradas con visibilidad.
					visibilitat = BigDecimal.ZERO;
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
	public static BigDecimal obtenirVisibilitatSollicitud(ClientEntity clientEntity, ServeisService serveisService, BigDecimal idSollicitud,
	        Resultat resultatError) throws GPAServeisServiceException, GPAApiParamValidationException {

		BigDecimal visibilitat = BigDecimal.ONE;

		validarCapsUsuari(clientEntity, Resultat.ERROR_OBTENIR_EXPEDIENT);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			DadesSollicitudBDTO dadesSollicitudBDTO = serveisService.consultarDadesSollicitudPerVisibilitat(idSollicitud);

			// validamos que el usuario logado pertenezca al expediente
			PersonesSollicitudRDTO implicado = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
			        dadesSollicitudBDTO.getPersonesInteressades(), dadesSollicitudBDTO.getPersonesImplicades(),
			        dadesSollicitudBDTO.getSollicitant(), dadesSollicitudBDTO.getRepresentant(), resultatError);

			if (implicado != null && StringUtils.isNotEmpty(implicado.getRelacioImplicada())) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
				        .consultarDadesProcediment(dadesSollicitudBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ProcedimentPersones procedimentPersones = ServeisRestControllerValidationHelper.validateVisibilitatImplicado(implicado,
				        null, null, null, null, procedimentPersonesList, null, resultatError);

				if (procedimentPersones != null) {
					visibilitat = procedimentPersones.getNivellVisibilitat();
				}

				// Comprobar si tiene la visibilidadOVT
				// activada
				if (implicado.getVisibilitatOvt() == null || implicado.getVisibilitatOvt().compareTo(INTEGER_ZERO) == 0) {
					// Se habilita un campo Visibilidad a OVT en el detalle de
					// cada persona implicada en el
					// expediente que puede ser activado o desactivado por las
					// unidades gestoras en cualquier momento de la tramitacion
					// y que
					// proporciona o saca respectivamente el acceso a la
					// visibilidad del expediente desde el portal de la
					// documentacion y los datos
					// de operación configuradas con visibilidad.
					visibilitat = BigDecimal.ZERO;
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
	        DocsTramitacioRDTO docsTramitacioRDTO, DadesExpedientBDTO dadesExpedientBDTO, BigDecimal idTramitOvt, Resultat resultatError)
	        throws GPAApiParamValidationException, GPAServeisServiceException {

		validarCapsUsuari(clientEntity, resultatError);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			PersonesSollicitudRDTO implicado = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
			        dadesExpedientBDTO.getPersonesInteressades(), dadesExpedientBDTO.getPersonesImplicades(),
			        dadesExpedientBDTO.getSollicitant(), dadesExpedientBDTO.getRepresentant(), resultatError);

			if (implicado != null && StringUtils.isNotEmpty(implicado.getRelacioImplicada())) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
				        .consultarDadesBasiquesProcediment(dadesExpedientBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ServeisRestControllerValidationHelper.validateVisibilitatImplicado(implicado, dadesActualizar, configuacioActualizar,
				        docsEntradaRDTO, docsTramitacioRDTO, procedimentPersonesList, idTramitOvt, resultatError);
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
	        DocsTramitacioRDTO docsTramitacioRDTO, DadesSollicitudBDTO dadesSollicitudBDTO, BigDecimal idTramitOvt, Resultat resultatError)
	        throws GPAApiParamValidationException, GPAServeisServiceException {

		validarCapsUsuari(clientEntity, resultatError);

		String nifInteressat = clientEntity.getUsuariInteressat();

		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {

			PersonesSollicitudRDTO implicado = ServeisRestControllerValidationHelper.validateUsuariLogueadoExpedient(nifInteressat,
			        dadesSollicitudBDTO.getPersonesInteressades(), dadesSollicitudBDTO.getPersonesImplicades(),
			        dadesSollicitudBDTO.getSollicitant(), dadesSollicitudBDTO.getRepresentant(), resultatError);

			if (implicado != null && StringUtils.isNotEmpty(implicado.getRelacioImplicada())) {
				DadesProcedimentBDTO dadesProcedimentBDTO = serveisService
				        .consultarDadesBasiquesProcediment(dadesSollicitudBDTO.getExpedientsRDTO().getProcedimentIdext());

				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ServeisRestControllerValidationHelper.validateVisibilitatImplicado(implicado, dadesActualizar, configuacioActualizar,
				        docsEntradaRDTO, docsTramitacioRDTO, procedimentPersonesList, idTramitOvt, resultatError);
			}

		}
	}

	public static void validarCapsUsuari(ClientEntity clientEntity, Resultat resultatError) throws GPAApiParamValidationException {

		String usuariInteressat = clientEntity.getUsuariInteressat();
		String usuariAutenticat = clientEntity.getUsuariAutenticat();

		// TODO si no viene ninguna cabecera deberemos luego lanzar error, de
		// momento dejamos que siga funcionando
		if (StringUtils.isEmpty(usuariAutenticat) && StringUtils.isEmpty(usuariInteressat)) {
			// throw new GPAApiParamValidationException(resultatError,
			// ErrorPrincipal.ERROR_EXPEDIENTS_USUARIS_HEADER_NOT_FOUND);
		}
	}

	/**
	 * Es usuari ciutada.
	 *
	 * @param clientEntity
	 *            the client entity
	 * @return true, if successful
	 */
	public static boolean esUsuariCiutada(ClientEntity clientEntity) {
		String usuariInteressat = clientEntity.getUsuariInteressat();
		String usuariAutenticat = clientEntity.getUsuariAutenticat();

		if (usuariInteressat == null && usuariAutenticat == null) {
			return true;
		}

		// Escenarios:
		// - Autenticat: DNI / Interessat: DNI --> Ciudadano
		// - Autenticat: Matrícula / Interessat: DNI --> Informador
		// - Autenticat: Matrícula / Interessat: - --> ?? ¿Nadie en ventanilla?
		// - Autenticat: - / Interessat: DNI --> ?? No tiene sentido
		// - Autenticat: Matrícula / Interessat: Matrícula --> ?? No tiene
		// sentido una matrícula como Solicitante
		boolean esUsuariCiutada = StringUtils.equals(usuariAutenticat, usuariInteressat);

		log.info("esUsuariCiutada: " + esUsuariCiutada);

		return esUsuariCiutada;
	}
}
