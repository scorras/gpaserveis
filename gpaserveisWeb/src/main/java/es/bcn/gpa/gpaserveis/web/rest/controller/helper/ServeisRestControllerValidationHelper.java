package es.bcn.gpa.gpaserveis.web.rest.controller.helper;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesSollicitudBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesRepetiblesRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValors;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DadesEspecifiquesValorsJson;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentamentRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperValidVal;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacionsValidacio;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersonesTramOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ReqOperatiusTramOvt;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UsuarisRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.initialization.interceptor.ClientEntity;
import es.bcn.gpa.gpaserveis.web.rest.controller.helper.bean.ValidateDadesOperacioResultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.common.BooleanApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.document.TipusSignaturaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusRelacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.EstatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusCampApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TipusValidacioApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitOvtApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusRelacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusCampApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TipusValidacioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar.AtributsActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.DocumentAportatCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.digitalitzar.DocumentDigitalitzarCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.SignaturaValidDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.DocumentAportatSubstituirRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.AtributRequeritRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.DocumentRequeritCrearRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.actualitzar.SollicitudActualitzarRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.RespostaConsultaTramitProcedimentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar.DocumentCompletatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.DocumentDigitalitzatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.DocumentIncorporatNouRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.intraoperabilitat.DocumentIntraoperabilitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.ConfiguracioDocumentacioRequeridaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.DadaOperacioRequeritRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.RequerimentPreparatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.presentar.declaracio.responsable.DeclaracioResponsablePresentadaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.convidar.ExpedientConvidarTramitarRDTO;
import lombok.extern.apachecommons.CommonsLog;

/**
 * The Class ServeisRestControllerValidationHelper.
 */
@CommonsLog
public class ServeisRestControllerValidationHelper {

	private static final Pattern JWT_PATTERN = Pattern.compile("^[a-zA-Z0-9-_=-]+(?:\\.[a-zA-Z0-9-_=-]+){2}$");

	/**
	 * Validate procediment crear solicitud expedient.
	 *
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateProcedimentCrearSolicitudExpedient(DadesProcedimentBDTO dadesProcedimentBDTO)
	        throws GPAApiParamValidationException {
		if (dadesProcedimentBDTO.getProcedimentsRDTO() == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_FOUND);
		}

		if (dadesProcedimentBDTO.getProcedimentsRDTO().getEstatsProcediment().getEstat()
		        .compareTo(EstatApiParamValue.PUBLICAT.getInternalValue()) != INTEGER_ZERO) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_PUBLICAT);
		}
	}

	/**
	 * Validate unitat gestora.
	 *
	 * @param unitatsGestoresRDTO
	 *            the unitats gestores RDTO
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateUnitatGestora(UnitatsGestoresRDTO unitatsGestoresRDTO, DadesProcedimentBDTO dadesProcedimentBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		// La Unitat Gestora debe existir, estar vigente y estar asociada al
		// procedimiento
		if (unitatsGestoresRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_NOT_FOUND);
		}

		if (unitatsGestoresRDTO.getVigent() != null && unitatsGestoresRDTO.getVigent().compareTo(INTEGER_ZERO) == 0) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_NOT_VIGENT);
		}

		boolean unitatAssociadaProcediment = false;
		unitatAssociadaProcediment = unitatsGestoresRDTO.getId()
		        .compareTo(dadesProcedimentBDTO.getProcedimentsRDTO().getUgrIdext()) == INTEGER_ZERO;
		if (!unitatAssociadaProcediment && CollectionUtils.isNotEmpty(dadesProcedimentBDTO.getProcedimentsRDTO().getUgosList())) {
			for (ProcedimentsUgos ugo : dadesProcedimentBDTO.getProcedimentsRDTO().getUgosList()) {
				if (unitatsGestoresRDTO.getId().compareTo(ugo.getUgoIdext()) == INTEGER_ZERO) {
					unitatAssociadaProcediment = true;
					break;
				}
			}
		}
		if (!unitatAssociadaProcediment) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_NOT_IN_PROCEDIMENT);
		}
	}

	/**
	 * Validate unitat gestora convidada.
	 *
	 * @param idUnitatGestoraConvidada
	 *            the id unitat gestora convidada
	 * @param idUnitatGestoraExpedient
	 *            the id unitat gestora expedient
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateUnitatGestoraConvidada(BigDecimal idUnitatGestoraConvidada, BigDecimal idUnitatGestoraExpedient,
	        Resultat resultatError) throws GPAApiParamValidationException {
		// La Unitat Gestora a convidar debe ser diferente a la que tiene
		// asignada el expediente
		if (idUnitatGestoraConvidada.compareTo(idUnitatGestoraExpedient) == NumberUtils.INTEGER_ZERO) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_ASSIGNADA);
		}
	}

	/**
	 * Validate no exist unitat gestora convidada.
	 *
	 * @param idUnitatGestoraConvidada
	 *            the id unitat gestora convidada
	 * @param idUnitatGestoraExpedient
	 *            the id unitat gestora expedient
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateNoExistUnitatGestoraConvidada(ExpedientConvidarTramitarRDTO expedientConvidarTramitarRDTO,
	        DadesExpedientBDTO dadesExpedientBDTO, Resultat resultatError) throws GPAApiParamValidationException {
		// TODO GPA-2901
		// for (EstatsUgConvidada estatsUgConvidada :
		// dadesExpedientBDTO.getExpedientsRDTO().getUgConvidadaIdextList()) {
		// if (expedientConvidarTramitarRDTO.getCodiUnitatGestoraList()
		// .contains(String.valueOf(estatsUgConvidada.getUgConvidadaIdext()))) {
		// throw new GPAApiParamValidationException(resultatError,
		// ErrorPrincipal.ERROR_UNITATS_CONVIDADA_ASSIGNADA);
		// }
		//
		// }

	}

	/**
	 * Validate expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateExpedient(DadesExpedientBDTO dadesExpedientBDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (dadesExpedientBDTO.getExpedientsRDTO() == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_NOT_FOUND);
		}
	}

	/**
	 * Validate sollicitud.
	 *
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateSollicitud(DadesSollicitudBDTO dadesSollicitudBDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (dadesSollicitudBDTO.getSollicitudsRDTO() == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_SOLLICITUDS_NOT_FOUND);
		}

		if (dadesSollicitudBDTO.getSollicitudsRDTO().getRegistre() != null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_SOLLICITUDS_REGISTRADA);
		}

	}

	/**
	 * Validate descarga document sollicitud.
	 *
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDescargaDocumentSollicitud(DadesSollicitudBDTO dadesSollicitudBDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (dadesSollicitudBDTO.getSollicitudsRDTO() == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_SOLLICITUDS_NOT_FOUND);
		}

	}

	/**
	 * Validate registre sollicitud.
	 *
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateRegistreSollicitud(DadesSollicitudBDTO dadesSollicitudBDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		validateSollicitud(dadesSollicitudBDTO, resultatError);
		if (TramitOvtApiParamValue.SOL.getInternalValue().compareTo(dadesSollicitudBDTO.getSollicitudsRDTO().getTramitOvtIdext()) == 0) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_SOLLICITUDS_TIPUS_NOT_VALID);
		}
	}

	/**
	 * Validate tipus sollicitud.
	 *
	 * @param codiTramit
	 *            the codi tramit
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateTipusSollicitud(String codiTramit, Resultat resultatError) throws GPAApiParamValidationException {
		if (StringUtils.equals(codiTramit, TramitOvtApiParamValue.SOL.getApiParamValue())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_SOLLICITUDS_TIPUS_NOT_VALID);
		}
	}

	/**
	 * Validate expedient acumulador.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param expedientsRDTORelacionatsAcumuladorList
	 *            the expedients RDTO relacionats acumulador list
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateExpedientAcumulador(DadesExpedientBDTO dadesExpedientBDTO,
	        List<ExpedientsRDTO> expedientsRDTORelacionatsAcumuladorList, Resultat resultatError) throws GPAApiParamValidationException {
		if (dadesExpedientBDTO.getExpedientsRDTO() == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACUMULADOR_NOT_FOUND);
		}

		TipusRelacioApiParamValueTranslator tipusRelacioApiParamValueTranslator = new TipusRelacioApiParamValueTranslator();
		TipusRelacioApiParamValue tipusRelacioApiParamValue = null;
		if (CollectionUtils.isNotEmpty(expedientsRDTORelacionatsAcumuladorList)) {
			for (ExpedientsRDTO expedientsRDTO : expedientsRDTORelacionatsAcumuladorList) {
				tipusRelacioApiParamValue = tipusRelacioApiParamValueTranslator
				        .getEnumByInternalValue(expedientsRDTO.getRelacioTipusRelacio());
				switch (tipusRelacioApiParamValue) {
				case OBJECTE_D_ACUMULACIO:
					throw new GPAApiParamValidationException(resultatError,
					        ErrorPrincipal.ERROR_EXPEDIENTS_ACUMULADOR_NOT_VALID_JA_ACUMULAT);
				default:
					break;
				}
			}
		}
	}

	/**
	 * Validate expedient acumular.
	 *
	 * @param dadesExpedientBDTOAcumulador
	 *            the dades expedient BDTO acumulador
	 * @param dadesExpedientBDTOAcumular
	 *            the dades expedient BDTO acumular
	 * @param expedientsRDTORelacionatsAcumularList
	 *            the expedients RDTO relacionats acumular list
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateExpedientAcumular(DadesExpedientBDTO dadesExpedientBDTOAcumulador,
	        DadesExpedientBDTO dadesExpedientBDTOAcumular, List<ExpedientsRDTO> expedientsRDTORelacionatsAcumularList,
	        Resultat resultatError) throws GPAApiParamValidationException {
		if (dadesExpedientBDTOAcumular.getExpedientsRDTO() == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACUMULAT_NOT_FOUND);
		}

		if (dadesExpedientBDTOAcumulador.getExpedientsRDTO().getId()
		        .compareTo(dadesExpedientBDTOAcumular.getExpedientsRDTO().getId()) == NumberUtils.INTEGER_ZERO) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACUMULAT_NOT_VALID_MATEIX_EXPEDIENT);
		}

		if (dadesExpedientBDTOAcumulador.getExpedientsRDTO().getProcedimentIdext()
		        .compareTo(dadesExpedientBDTOAcumular.getExpedientsRDTO().getProcedimentIdext()) != NumberUtils.INTEGER_ZERO) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACUMULAT_NOT_VALID_MATEIX_PROCEDIMENT);
		}

		TipusRelacioApiParamValueTranslator tipusRelacioApiParamValueTranslator = new TipusRelacioApiParamValueTranslator();
		TipusRelacioApiParamValue tipusRelacioApiParamValue = null;
		if (CollectionUtils.isNotEmpty(expedientsRDTORelacionatsAcumularList)) {
			for (ExpedientsRDTO expedientsRDTO : expedientsRDTORelacionatsAcumularList) {
				tipusRelacioApiParamValue = tipusRelacioApiParamValueTranslator
				        .getEnumByInternalValue(expedientsRDTO.getRelacioTipusRelacio());
				switch (tipusRelacioApiParamValue) {
				case ACUMULAT:
					throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACUMULAT_NOT_VALID_JA_ACUMULAT);
				default:
					break;
				}
			}
		}
	}

	/**
	 * Validate accio disponible expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param accioTramitadorApiParamValue
	 *            the accio tramitador api param value
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateAccioDisponibleExpedient(DadesExpedientBDTO dadesExpedientBDTO,
	        AccioTramitadorApiParamValue accioTramitadorApiParamValue, Resultat resultatError) throws GPAApiParamValidationException {
		for (AccionsEstatsRDTO accionsEstatsRDTO : dadesExpedientBDTO.getAccionsDisponibles()) {
			if (accionsEstatsRDTO.getAccio().compareTo(accioTramitadorApiParamValue.getInternalValue()) == INTEGER_ZERO) {
				return;
			}
		}
		throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACCIO_NOT_AVAILABLE,
		        accioTramitadorApiParamValue.getApiParamValue());
	}

	/**
	 * Validate accio tornar enrere disponible expedient.
	 *
	 * @param idEstat
	 *            the id estat
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateAccioTornarEnrereDisponibleExpedient(BigDecimal idEstat, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if ((idEstat == null) || (Constants.ESTAT_EXPEDIENT_EN_PREPARACIO.compareTo(idEstat) == INTEGER_ZERO)
		        || (Constants.ESTAT_EXPEDIENT_SOLLICITUD_EN_REVISIO.compareTo(idEstat) == INTEGER_ZERO)) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ACCIO_NOT_AVAILABLE);
		}
	}

	/**
	 * Validate sollicitant actualitzar solicitud expedient.
	 *
	 * @param sollicitant
	 *            the sollicitant
	 * @param representant
	 *            the representant
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateSollicitantActualitzarSolicitudExpedient(PersonesRDTO sollicitant, PersonesRDTO representant)
	        throws GPAApiParamValidationException {
		if (representant != null && sollicitant == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
			        ErrorPrincipal.ERROR_EXPEDIENTS_SOLLICITANT_REQUIRED);
		}
	}

	/**
	 * Validate sollicitant crear solicitud expedient.
	 *
	 * @param sollicitant
	 *            the sollicitant
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateSollicitantCrearSolicitudExpedient(PersonesRDTO sollicitant, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (sollicitant == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_SOLLICITANT_OBLIGATORI);
		}
	}

	/**
	 * Validate dades operacio actualitzar solicitud expedient.
	 *
	 * @param dadesOperacio
	 *            the dades operacio
	 * @param dadesGrupsRDTOList
	 *            the dades grups RDTO list
	 * @param idExpedient
	 *            the id expedient
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param isPortal
	 *            the is portal
	 * @return the validate dades operacio resultat
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static ValidateDadesOperacioResultat validateDadesOperacioActualitzarSolicitudExpedient(
	        List<AtributsActualitzarRDTO> dadesOperacio, List<DadesGrupsRDTO> dadesGrupsRDTOList, BigDecimal idExpedient,
	        BigDecimal idSollicitud, boolean isPortal) throws GPAApiParamValidationException {
		ValidateDadesOperacioResultat validateDadesOperacioResultat = null;
		HashMap<String, List<String>> atributsMap = new HashMap<String, List<String>>();
		HashMap<String, List<List<String>>> atributsMapListaMultiple = new HashMap<String, List<List<String>>>();
		if (CollectionUtils.isNotEmpty(dadesOperacio)) {
			for (AtributsActualitzarRDTO atributsActualitzarRDTO : dadesOperacio) {
				atributsMap.put(atributsActualitzarRDTO.getCodi(), atributsActualitzarRDTO.getValor());
				atributsMapListaMultiple.put(atributsActualitzarRDTO.getCodi(), atributsActualitzarRDTO.getValorLlistaMultipleRepetible());
			}
			validateDadesOperacioResultat = validateDadesOperacio(atributsMap, atributsMapListaMultiple, dadesGrupsRDTOList, idExpedient,
			        idSollicitud, isPortal);
		}
		return validateDadesOperacioResultat;
	}

	/**
	 * Validate dades operacio preparar requeriment expedient.
	 *
	 * @param dadesOperacioRequerits
	 *            the dades operacio requerits
	 * @param dadesOperacionsRDTOList
	 *            the dades operacions RDTO list
	 * @return the array list
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static ArrayList<BigDecimal> validateDadesOperacioPrepararRequerimentExpedient(
	        List<DadaOperacioRequeritRDTO> dadesOperacioRequerits, List<DadesOperacionsRDTO> dadesOperacionsRDTOList)
	        throws GPAApiParamValidationException {
		ArrayList<BigDecimal> idDadesOperacionsList = null;
		if (CollectionUtils.isNotEmpty(dadesOperacioRequerits)) {
			idDadesOperacionsList = new ArrayList<BigDecimal>();
			HashMap<String, DadesOperacionsRDTO> dadesOperacionsMap = new HashMap<String, DadesOperacionsRDTO>();
			if (CollectionUtils.isNotEmpty(dadesOperacionsRDTOList)) {
				for (DadesOperacionsRDTO dadesOperacionsRDTO : dadesOperacionsRDTOList) {
					dadesOperacionsMap.put(dadesOperacionsRDTO.getCodi(), dadesOperacionsRDTO);
				}
			}
			for (DadaOperacioRequeritRDTO dadaOperacioRequeritRDTO : dadesOperacioRequerits) {
				if (!dadesOperacionsMap.containsKey(dadaOperacioRequeritRDTO.getCodi())) {
					throw new GPAApiParamValidationException(Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT,
					        ErrorPrincipal.ERROR_EXPEDIENTS_DADA_OPERACIO_REQUERIMENT_NOT_AVAILABLE, dadaOperacioRequeritRDTO.getCodi());
				}
				idDadesOperacionsList.add(dadesOperacionsMap.get(dadaOperacioRequeritRDTO.getCodi()).getId());
			}
		}
		return idDadesOperacionsList;
	}

	/**
	 * Validate dades operacio esmenar expedient.
	 *
	 * @param dadesOperacio
	 *            the dades operacio
	 * @param dadesGrupsRDTOList
	 *            the dades grups RDTO list
	 * @param idExpedient
	 *            the id expedient
	 * @return the array list
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static ValidateDadesOperacioResultat validateDadesOperacioEsmenarExpedient(List<AtributRequeritRDTO> dadesOperacio,
	        List<DadesGrupsRDTO> dadesGrupsRDTOList, BigDecimal idExpedient) throws GPAApiParamValidationException {
		ValidateDadesOperacioResultat validateDadesOperacioResultat = null;
		HashMap<String, List<String>> atributsMap = new HashMap<String, List<String>>();
		if (CollectionUtils.isNotEmpty(dadesOperacio)) {
			for (AtributRequeritRDTO atributRequeritRDTO : dadesOperacio) {
				atributsMap.put(atributRequeritRDTO.getCodi(), atributRequeritRDTO.getValor());

			}
			// dadesEspecifiquesRDTOList = validateDadesOperacio(atributsMap,
			// null, dadesGrupsRDTOList, idExpedient, null, true);
		}
		return validateDadesOperacioResultat;
	}

	/**
	 * Validate dades operacio.
	 *
	 * @param atributsMap
	 *            the atributs map
	 * @param atributsMapListaMultiple
	 *            the atributs map lista multiple
	 * @param dadesGrupsRDTOList
	 *            the dades grups RDTO list
	 * @param idExpedient
	 *            the id expedient
	 * @param idSollicitud
	 *            the id sollicitud
	 * @param isPortal
	 *            the is portal
	 * @return the validate dades operacio resultat
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static ValidateDadesOperacioResultat validateDadesOperacio(Map<String, List<String>> atributsMap,
	        Map<String, List<List<String>>> atributsMapListaMultiple, List<DadesGrupsRDTO> dadesGrupsRDTOList, BigDecimal idExpedient,
	        BigDecimal idSollicitud, boolean isPortal) throws GPAApiParamValidationException {
		ValidateDadesOperacioResultat validateDadesOperacioResultat = new ValidateDadesOperacioResultat();
		ArrayList<DadesEspecifiquesRDTO> dadesEspecifiquesRDTOList = null;
		ArrayList<DadesEspecifiquesRepetiblesRDTO> dadesEspecifiquesRepetiblesRDTOList = null;

		HashMap<String, DadesGrupsRDTO> dadesGrupsMap = new HashMap<String, DadesGrupsRDTO>();
		HashMap<String, DadesOperacions> dadesOperacionsMap = new HashMap<String, DadesOperacions>();
		if (CollectionUtils.isNotEmpty(dadesGrupsRDTOList)) {
			for (DadesGrupsRDTO dadesGrupsRDTO : dadesGrupsRDTOList) {
				dadesGrupsMap.put("GRUP_" + dadesGrupsRDTO.getId().toString(), dadesGrupsRDTO);
				if (CollectionUtils.isNotEmpty(dadesGrupsRDTO.getDadesOperacionsList())) {
					for (DadesOperacions dadesOperacions : dadesGrupsRDTO.getDadesOperacionsList()) {
						dadesOperacionsMap.put(dadesOperacions.getCodi(), dadesOperacions);
					}
				}
			}
		}
		dadesEspecifiquesRDTOList = new ArrayList<DadesEspecifiquesRDTO>();
		dadesEspecifiquesRepetiblesRDTOList = new ArrayList<DadesEspecifiquesRepetiblesRDTO>();
		DadesEspecifiquesRDTO dadesEspecifiquesRDTO = null;
		DadesEspecifiquesRepetiblesRDTO dadesEspecifiquesRepetiblesRDTO = null;
		DadesOperacions dadesOperacions = null;
		List<DadesEspecifiquesValors> dadesEspecifiquesValorsList = null;
		List<DadesEspecifiquesValorsJson> dadesEspecifiquesValorsJsonList = null;
		DadesEspecifiquesValors dadesEspecifiquesValors = null;
		DadesEspecifiquesValorsJson dadesEspecifiquesValorsJson = null;
		DateTimeFormatter dataFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
		DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		DateTimeFormatter horaFormatter = DateTimeFormat.forPattern(Constants.TIME_PATTERN);
		NumberFormat numberFormat = NumberFormat.getInstance(LocaleContextHolder.getLocale());
		TipusCampApiParamValueTranslator tipusCampApiParamValueTranslator = new TipusCampApiParamValueTranslator();
		TipusCampApiParamValue tipusCampApiParamValue = null;

		if (CollectionUtils.isNotEmpty(atributsMap.values())) {
			for (Entry<String, List<String>> atributEntry : atributsMap.entrySet()) {
				if (atributEntry.getValue() != null) {
					if (!dadesGrupsMap.containsKey(atributEntry.getKey()) && !dadesOperacionsMap.containsKey(atributEntry.getKey())
					        && !StringUtils.equals(atributEntry.getKey(), Constants.CODI_DADA_OPERACIO_DADES_EXTERNES)) {
						throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
						        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_FOUND, atributEntry.getKey());
					}

					// GRUP_XX ó dato de operación con subgrupo asociado
					if (dadesGrupsMap.containsKey(atributEntry.getKey()) || (dadesOperacionsMap.containsKey(atributEntry.getKey())
					        && dadesOperacionsMap.get(atributEntry.getKey()).getIdDefinicioGrup() != null)) {
						dadesEspecifiquesRepetiblesRDTO = new DadesEspecifiquesRepetiblesRDTO();
						dadesEspecifiquesValorsJsonList = new ArrayList<DadesEspecifiquesValorsJson>();
						dadesEspecifiquesValorsJson = new DadesEspecifiquesValorsJson();
						dadesEspecifiquesRepetiblesRDTO.setExpedient(idExpedient);
						dadesEspecifiquesRepetiblesRDTO.setNou(isPortal ? INTEGER_ONE : INTEGER_ZERO);
						if (dadesGrupsMap.containsKey(atributEntry.getKey())) {
							dadesEspecifiquesRepetiblesRDTO.setGrupIdext(dadesGrupsMap.get(atributEntry.getKey()).getId());
						} else {
							dadesEspecifiquesRepetiblesRDTO.setCampIdext(dadesOperacionsMap.get(atributEntry.getKey()).getId());
						}

						// Dato de operación de tipo grupo repetible. Valor en
						// formato
						// JSON
						String valorGrupRepetible = atributEntry.getValue().get(INTEGER_ZERO);
						// Se valida que el dato en String tenga formato JSON,
						// que cumpla con el esquema codisColumnes y
						// valorsColumnes, que los codisColumnes se correspondan
						// con los datos de operación configurados en el grupo
						// repetible y que los valorsColumnes sean válidos según
						// las validaciones configuradas
						validateDadesOperacioGrupRepetible(atributEntry.getKey(), valorGrupRepetible,
						        dadesGrupsMap.get(atributEntry.getKey()));

						dadesEspecifiquesValorsJson.setValorJson(valorGrupRepetible);
						dadesEspecifiquesValorsJson.setSollicitud(idSollicitud);
						dadesEspecifiquesValorsJsonList.add(dadesEspecifiquesValorsJson);

						dadesEspecifiquesRepetiblesRDTO.setDadesEspecifiquesValorsJsonList(dadesEspecifiquesValorsJsonList);
						dadesEspecifiquesRepetiblesRDTOList.add(dadesEspecifiquesRepetiblesRDTO);
					} else {
						dadesEspecifiquesRDTO = new DadesEspecifiquesRDTO();
						dadesEspecifiquesValorsList = new ArrayList<DadesEspecifiquesValors>();
						dadesEspecifiquesValors = new DadesEspecifiquesValors();
						dadesEspecifiquesRDTO.setExpedient(idExpedient);
						dadesEspecifiquesRDTO.setNou(isPortal ? INTEGER_ONE : INTEGER_ZERO);

						if (StringUtils.equals(atributEntry.getKey(), Constants.CODI_DADA_OPERACIO_DADES_EXTERNES)) {
							// Dato de operación genérico DADES_EXTERNES
							String valorDadesExternes = atributEntry.getValue().get(INTEGER_ZERO);
							// Se valida que el dato en String tenga formato
							// JSON
							validateDadesOperacioDadesExternes(valorDadesExternes);
							dadesEspecifiquesValors.setValorClob(valorDadesExternes);
							dadesEspecifiquesValors.setSollicitud(idSollicitud);
							dadesEspecifiquesValorsList.add(dadesEspecifiquesValors);
						} else {
							// Resto de datos de operación
							dadesOperacions = dadesOperacionsMap.get(atributEntry.getKey());
							dadesEspecifiquesRDTO.setCampIdext(dadesOperacions.getId());

							tipusCampApiParamValue = tipusCampApiParamValueTranslator.getEnumByInternalValue(dadesOperacions.getTipus());

							if (dadesOperacions.getTipusDadaOperacio().equals(Constants.DADES_OPERACIONS_REPETIBLE)) {
								dadesEspecifiquesValorsList = obtenirDadesEspecifiquesValorsRepetiblesList(atributEntry, dadesOperacions,
								        tipusCampApiParamValue, idSollicitud, false);
							} else {

								try {
									switch (tipusCampApiParamValue) {
									case NUMERIC:
										if (atributEntry.getValue().get(0) != null) {
											Long valorInteger = Long.valueOf(atributEntry.getValue().get(INTEGER_ZERO));
											validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorInteger));
											dadesEspecifiquesValors.setValorInteger(valorInteger);
										}
										break;
									case DECIMAL:
										if (atributEntry.getValue().get(0) != null) {
											Double valorDouble = Double.valueOf(atributEntry.getValue().get(INTEGER_ZERO));
											validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorDouble));
											dadesEspecifiquesValors.setValorDouble(valorDouble);
										}
										break;
									case MONEDA:
										if (atributEntry.getValue().get(0) != null) {
											Double valorMoneda = Double.valueOf(atributEntry.getValue().get(INTEGER_ZERO));
											validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorMoneda));
											dadesEspecifiquesValors.setValorMoneda(valorMoneda);
										}
										break;
									case DATA:
										if (atributEntry.getValue().get(0) != null) {
											DateTime valorData = DateTime.parse(atributEntry.getValue().get(INTEGER_ZERO), dataFormatter);
											validateDadesOperacioDataGeneral(dadesOperacions, valorData, tipusCampApiParamValue);
											dadesEspecifiquesValors.setValorCalendar(valorData);
										}
										break;
									case DATA_HORA:
										if (atributEntry.getValue().get(0) != null) {
											DateTime valorDataHora = DateTime.parse(atributEntry.getValue().get(INTEGER_ZERO),
											        dataHoraFormatter);
											validateDadesOperacioDataGeneral(dadesOperacions, valorDataHora, tipusCampApiParamValue);
											dadesEspecifiquesValors.setValorCalendar(valorDataHora);
										}
										break;
									case HORA:
										if (atributEntry.getValue().get(0) != null) {
											DateTime valorHora = DateTime.parse(atributEntry.getValue().get(INTEGER_ZERO), horaFormatter);
											validateDadesOperacioDataGeneral(dadesOperacions, valorHora, tipusCampApiParamValue);
											dadesEspecifiquesValors.setValorCalendar(valorHora);
										}
										break;
									case TEXT:
										if (atributEntry.getValue().get(0) != null) {
											String valorText = atributEntry.getValue().get(INTEGER_ZERO);
											validateDadesOperacioCadenaGeneral(dadesOperacions, valorText);
											dadesEspecifiquesValors.setValorString(valorText);
										}
										break;
									case TEXT_GRAN:
										if (atributEntry.getValue().get(0) != null) {
											String valorTextGran = atributEntry.getValue().get(INTEGER_ZERO);
											validateDadesOperacioCadenaGeneral(dadesOperacions, valorTextGran);
											dadesEspecifiquesValors.setValorClob(valorTextGran);
										}
										break;
									case LITERAL:
										break;
									case LLISTA_SIMPLE:
										if (atributEntry.getValue().get(0) != null) {
											Integer valorLlistaSimple = Integer.valueOf(atributEntry.getValue().get(INTEGER_ZERO));
											validateDadesOperacioNumericGeneral(dadesOperacions, BigDecimal.valueOf(valorLlistaSimple));
											dadesEspecifiquesValors.setValorListaSimple(valorLlistaSimple);
										}
										break;
									case LLISTA_MULTIPLE:
										if (atributEntry.getValue().get(0) != null) {
											ArrayList<Integer> integerList = new ArrayList<Integer>();
											if (CollectionUtils.isNotEmpty(atributEntry.getValue())) {
												for (String valor : atributEntry.getValue()) {
													integerList.add(Integer.valueOf(valor));
												}
											}
											dadesEspecifiquesValors.setValorListaMultipleList(integerList);
										}
										break;
									case MARCADOR:
										// Debe funcionar independientemente de
										// lo
										// que se envíe
										// (1/0, true/false)
										Boolean valorBoolean = null;
										try {
											valorBoolean = BooleanUtils.toBoolean(
											        Integer.valueOf(atributEntry.getValue().get(INTEGER_ZERO)), NumberUtils.INTEGER_ONE,
											        NumberUtils.INTEGER_ZERO);
										} catch (IllegalArgumentException e) {
											log.info("Valor booleà no informat com Integer. Provant com a cadena...", e);
											valorBoolean = BooleanUtils.toBoolean(atributEntry.getValue().get(INTEGER_ZERO),
											        Boolean.TRUE.toString(), Boolean.FALSE.toString());
										}
										dadesEspecifiquesValors.setValorBoolean(BooleanUtils.toIntegerObject(valorBoolean,
										        NumberUtils.INTEGER_ONE, NumberUtils.INTEGER_ZERO));
										break;
									case PAIS:
										if (atributEntry.getValue().get(0) != null) {
											String valorPaisCodiIne = atributEntry.getValue().get(INTEGER_ZERO);
											validateDadesOperacioCadenaGeneral(dadesOperacions, valorPaisCodiIne);
											dadesEspecifiquesValors.setValorPais(valorPaisCodiIne);
										}
										break;
									case PROVINCIA:
										if (atributEntry.getValue().get(0) != null) {
											String valorProvinciaCodiIne = atributEntry.getValue().get(INTEGER_ZERO);
											validateDadesOperacioCadenaGeneral(dadesOperacions, valorProvinciaCodiIne);
											dadesEspecifiquesValors.setValorProvincia(valorProvinciaCodiIne);
										}
										break;
									case MUNICIPI:
										if (atributEntry.getValue().get(0) != null) {
											String valorMunicipiCodiIne = atributEntry.getValue().get(INTEGER_ZERO);
											validateDadesOperacioCadenaGeneral(dadesOperacions, valorMunicipiCodiIne);
											dadesEspecifiquesValors.setValorMunicipi(valorMunicipiCodiIne);
										}
										break;
									default:
										break;
									}
								} catch (GPAApiParamValidationException e) {
									throw e;
								} catch (Exception e) {
									throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
									        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_CORRECT_VALUE,
									        StringUtils.join(atributEntry.getValue(), ", "), e);
								}

							}

							if (!dadesOperacions.getTipusDadaOperacio().equals(Constants.DADES_OPERACIONS_REPETIBLE)) {
								if (CollectionUtils.isNotEmpty(dadesEspecifiquesValors.getValorListaMultipleList())) {
									DadesEspecifiquesValors dadesEspecifiquesValorsListaMultiple = null;
									for (Integer valor : dadesEspecifiquesValors.getValorListaMultipleList()) {
										dadesEspecifiquesValorsListaMultiple = new DadesEspecifiquesValors();
										dadesEspecifiquesValorsListaMultiple.setValorListaMultiple(valor);
										dadesEspecifiquesValorsListaMultiple.setSollicitud(idSollicitud);
										dadesEspecifiquesValorsList.add(dadesEspecifiquesValorsListaMultiple);
									}
								} else {
									dadesEspecifiquesValors.setSollicitud(idSollicitud);
									dadesEspecifiquesValorsList.add(dadesEspecifiquesValors);
								}
							}
						}
						dadesEspecifiquesRDTO.setDadesEspecifiquesValorsList(dadesEspecifiquesValorsList);
						dadesEspecifiquesRDTOList.add(dadesEspecifiquesRDTO);
					}
				}
			}

		}

		if (CollectionUtils.isNotEmpty(atributsMapListaMultiple.values())) {
			for (Entry<String, List<List<String>>> atributLlistaMultipleRepetibleEntry : atributsMapListaMultiple.entrySet()) {
				if (atributLlistaMultipleRepetibleEntry.getValue() != null) {
					if (!dadesOperacionsMap.containsKey(atributLlistaMultipleRepetibleEntry.getKey()) && !StringUtils
					        .equals(atributLlistaMultipleRepetibleEntry.getKey(), Constants.CODI_DADA_OPERACIO_DADES_EXTERNES)) {
						throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
						        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_FOUND, atributLlistaMultipleRepetibleEntry.getKey());
					}

					dadesEspecifiquesRDTO = new DadesEspecifiquesRDTO();
					dadesEspecifiquesValorsList = new ArrayList<DadesEspecifiquesValors>();
					dadesEspecifiquesValors = new DadesEspecifiquesValors();
					dadesEspecifiquesRDTO.setExpedient(idExpedient);
					dadesEspecifiquesRDTO.setNou(isPortal ? INTEGER_ONE : INTEGER_ZERO);

					// Por aquí sólo pasaremos para tratar los datos repetibles
					// para listas múltiples
					dadesOperacions = dadesOperacionsMap.get(atributLlistaMultipleRepetibleEntry.getKey());
					dadesEspecifiquesRDTO.setCampIdext(dadesOperacions.getId());

					tipusCampApiParamValue = tipusCampApiParamValueTranslator.getEnumByInternalValue(dadesOperacions.getTipus());

					int ordreRepeticio = 1;
					for (List<String> llistaMultiple : atributLlistaMultipleRepetibleEntry.getValue()) {

						Map.Entry<String, List<String>> atributsMapValorsLlistaMultiple = new java.util.AbstractMap.SimpleEntry<String, List<String>>(
						        atributLlistaMultipleRepetibleEntry.getKey(), llistaMultiple);

						List<DadesEspecifiquesValors> dadesEspecifiquesValorsListAux = obtenirDadesEspecifiquesValorsRepetiblesList(
						        atributsMapValorsLlistaMultiple, dadesOperacions, tipusCampApiParamValue, idSollicitud, true);

						if (CollectionUtils.isNotEmpty(dadesEspecifiquesValorsListAux)) {
							for (DadesEspecifiquesValors dadesEspecValors : dadesEspecifiquesValorsListAux) {
								dadesEspecValors.setOrdreRepeticio(ordreRepeticio);
								dadesEspecValors.setValorListaMultiple(dadesEspecValors.getValorListaMultipleList().get(0));
								dadesEspecifiquesValorsList.add(dadesEspecValors);
							}
						}
						dadesEspecifiquesRDTO.setDadesEspecifiquesValorsList(dadesEspecifiquesValorsList);
						dadesEspecifiquesRDTOList.add(dadesEspecifiquesRDTO);
						ordreRepeticio++;
					}

				}
			}
		}

		validateDadesOperacioResultat.setDadesEspecifiquesRDTOList(dadesEspecifiquesRDTOList);
		validateDadesOperacioResultat.setDadesEspecifiquesRepetiblesRDTOList(dadesEspecifiquesRepetiblesRDTOList);

		return validateDadesOperacioResultat;
	}

	/**
	 * Validate dades operacio grup repetible.
	 *
	 * @param codiDadaOperacio
	 *            the codi dada operacio
	 * @param valorGrupRepetible
	 *            the valor grup repetible
	 * @param dadesGrupsRDTO
	 *            the dades grups RDTO
	 * @throws GPAApiParamValidationException
	 */
	private static void validateDadesOperacioGrupRepetible(String codiDadaOperacio, String valorGrupRepetible,
	        DadesGrupsRDTO dadesGrupsRDTO) throws GPAApiParamValidationException {
		try {

			// TODO Se valida que el dato en String tenga formato JSON,
			// que cumpla con el esquema codisColumnes y
			// valorsColumnes, que los codisColumnes se correspondan
			// con los datos de operación configurados en el grupo
			// repetible y que los valorsColumnes sean válidos según
			// las validaciones configuradas

			ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(valorGrupRepetible);
		} catch (JsonParseException jpe) {
			log.info("El valor de la Dada d'operació " + codiDadaOperacio + " no té format JSON", jpe);
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
			        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_GRUP_REPETIBLE_NOT_VALID_VALUE, codiDadaOperacio);
		} catch (IOException ioe) {
			log.info("El valor de la Dada d'operació " + codiDadaOperacio + " no té format JSON", ioe);
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
			        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_GRUP_REPETIBLE_NOT_VALID_VALUE, codiDadaOperacio);
		}
	}

	private static List<DadesEspecifiquesValors> obtenirDadesEspecifiquesValorsRepetiblesList(Entry<String, List<String>> atributEntry,
	        DadesOperacions dadesOperacions, TipusCampApiParamValue tipusCampApiParamValue, BigDecimal idSollicitud,
	        boolean isLlistaMultipleRepetible) throws GPAApiParamValidationException {

		DateTimeFormatter dataFormatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
		DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		DateTimeFormatter horaFormatter = DateTimeFormat.forPattern(Constants.TIME_PATTERN);

		List<DadesEspecifiquesValors> dadesEspecifiquesValorsList = new ArrayList<DadesEspecifiquesValors>();

		try {

			List<String> valorsRepetiblesList = atributEntry.getValue();
			if (CollectionUtils.isNotEmpty(valorsRepetiblesList)) {
				if (dadesOperacions.getRepeticions() != null) {
					if (dadesOperacions.getRepeticions().intValue() < valorsRepetiblesList.size()) {
						throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
						        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_CORRECT_VALUE, StringUtils.join(atributEntry.getValue(), ", "));
					}
				}

				int ordreRepeticio = 1;
				int ordreRepeticioMultiple = 1;

				DadesEspecifiquesValors dadesEspecifiquesValors = null;

				for (String valorRepetible : valorsRepetiblesList) {
					if (StringUtils.isNotEmpty(valorRepetible)) {

						dadesEspecifiquesValors = new DadesEspecifiquesValors();

						validateDadesOperacioCadenaGeneral(dadesOperacions, valorRepetible);

						dadesEspecifiquesValors.setSollicitud(idSollicitud);

						switch (tipusCampApiParamValue) {

						case NUMERIC:
							Long valorInteger = Long.valueOf(valorRepetible);
							dadesEspecifiquesValors.setValorInteger(valorInteger);
							break;

						case DECIMAL:
							Double valorDouble = Double.valueOf(valorRepetible);
							dadesEspecifiquesValors.setValorDouble(valorDouble);
							break;

						case MONEDA:
							Double valorMoneda = Double.valueOf(valorRepetible);
							dadesEspecifiquesValors.setValorMoneda(valorMoneda);
							break;

						case DATA:
							DateTime valorData = DateTime.parse(valorRepetible, dataFormatter);
							dadesEspecifiquesValors.setValorCalendar(valorData);
							break;

						case DATA_HORA:
							DateTime valorDataHora = DateTime.parse(valorRepetible, dataHoraFormatter);
							dadesEspecifiquesValors.setValorCalendar(valorDataHora);
							break;

						case HORA:
							DateTime valorHora = DateTime.parse(valorRepetible, horaFormatter);
							dadesEspecifiquesValors.setValorCalendar(valorHora);
							break;

						case TEXT:
							dadesEspecifiquesValors.setValorString(valorRepetible);
							break;

						case TEXT_GRAN:
							dadesEspecifiquesValors.setValorClob(valorRepetible);
							break;

						case LITERAL:
							break;

						case LLISTA_SIMPLE:
							Integer valorLlistaSimple = Integer.valueOf(valorRepetible);
							dadesEspecifiquesValors.setValorListaSimple(valorLlistaSimple);
							break;

						case LLISTA_MULTIPLE:
							List<String> valorsLlistMultipleRepetiblesList = new ArrayList<String>(
							        Arrays.asList(valorRepetible.split(",")));

							ArrayList<Integer> integerList = new ArrayList<Integer>();
							if (CollectionUtils.isNotEmpty(valorsLlistMultipleRepetiblesList)) {
								for (String valor : valorsLlistMultipleRepetiblesList) {
									integerList.add(Integer.valueOf(valor));
								}
							}
							dadesEspecifiquesValors.setValorListaMultipleList(integerList);
							break;

						case MARCADOR:
							// Debe funcionar independientemente de lo que se
							// envíe
							// (1/0, true/false)
							Boolean valorBoolean = null;
							try {
								valorBoolean = BooleanUtils.toBoolean(Integer.valueOf(valorRepetible), NumberUtils.INTEGER_ONE,
								        NumberUtils.INTEGER_ZERO);
							} catch (IllegalArgumentException e) {
								log.info("Valor booleà no informat com Integer. Provant com a cadena...", e);
								valorBoolean = BooleanUtils.toBoolean(valorRepetible, Boolean.TRUE.toString(), Boolean.FALSE.toString());
							}
							dadesEspecifiquesValors.setValorBoolean(
							        BooleanUtils.toIntegerObject(valorBoolean, NumberUtils.INTEGER_ONE, NumberUtils.INTEGER_ZERO));
							break;

						case PAIS:
							dadesEspecifiquesValors.setValorPais(valorRepetible);
							break;
						case PROVINCIA:
							dadesEspecifiquesValors.setValorProvincia(valorRepetible);
							break;
						case MUNICIPI:
							dadesEspecifiquesValors.setValorMunicipi(valorRepetible);
							break;
						default:
							break;
						}

						if (isLlistaMultipleRepetible) {
							dadesEspecifiquesValors.setOrdreRepeticioMultiple(ordreRepeticioMultiple);
							ordreRepeticioMultiple++;
						} else {
							dadesEspecifiquesValors.setOrdreRepeticio(ordreRepeticio);
							ordreRepeticio++;
						}

						dadesEspecifiquesValorsList.add(dadesEspecifiquesValors);
					}

				}
			}
		} catch (GPAApiParamValidationException e) {
			throw e;
		} catch (Exception e) {
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
			        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_CORRECT_VALUE, StringUtils.join(atributEntry.getValue(), ", "), e);
		}
		return dadesEspecifiquesValorsList;
	}

	/**
	 * Validate dades operacio numeric general.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param valor
	 *            the valor
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 * @throws ParseException
	 *             the parse exception
	 */
	private static void validateDadesOperacioNumericGeneral(DadesOperacions dadesOperacions, BigDecimal valor)
	        throws GPAApiParamValidationException, ParseException {
		NumberFormat numberFormat = NumberFormat.getInstance(LocaleContextHolder.getLocale());
		TipusValidacioApiParamValueTranslator tipusValidacioApiParamValueTranslator = new TipusValidacioApiParamValueTranslator();
		TipusValidacioApiParamValue tipusValidacioApiParamValue = null;
		boolean valid = true;
		for (DadesOperacionsValidacio dadesOperacionsValidacio : dadesOperacions.getDadesOperacionsValidacio()) {
			tipusValidacioApiParamValue = tipusValidacioApiParamValueTranslator
			        .getEnumByInternalValue(dadesOperacionsValidacio.getTipusValidacio());
			DadesOperValidVal dadesOperValidVal0 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ZERO);
			BigDecimal validVal0 = new BigDecimal(numberFormat.parse(dadesOperValidVal0.getValor()).toString());
			DadesOperValidVal dadesOperValidVal1 = null;
			BigDecimal validVal1 = null;
			BigDecimal[] validValArray = null;
			if (dadesOperacionsValidacio.getDadesOperacionsValidValors().size() > INTEGER_ONE) {
				// Es necesario comprobar la validación atendiendo al ordre
				dadesOperValidVal1 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ONE);
				validVal1 = new BigDecimal(numberFormat.parse(dadesOperValidVal1.getValor()).toString());
				if (dadesOperValidVal0.getOrdre().longValue() < dadesOperValidVal1.getOrdre().longValue()) {
					validValArray = new BigDecimal[] { validVal0, validVal1 };
				} else {
					validValArray = new BigDecimal[] { validVal1, validVal0 };
				}
			}
			switch (tipusValidacioApiParamValue) {
			case OBLIGATORI:
				valid = valor != null;
				break;
			case MENOR:
				valid = valor.compareTo(validVal0) < INTEGER_ZERO;
				break;
			case MAJOR:
				valid = valor.compareTo(validVal0) > INTEGER_ZERO;
				break;
			case IGUAL:
				valid = valor.compareTo(validVal0) == INTEGER_ZERO;
				break;
			case MENOR_IGUAL:
				valid = valor.compareTo(validVal0) <= INTEGER_ZERO;
				break;
			case MAJOR_IGUAL:
				valid = valor.compareTo(validVal0) >= INTEGER_ZERO;
				break;
			case INTERVAL_TANCAT:
				if (validValArray != null && validValArray.length > 1) {
					valid = valor.compareTo(validValArray[0]) >= INTEGER_ZERO && valor.compareTo(validValArray[1]) <= INTEGER_ZERO;
				}
				break;
			case INTERVAL_OBERT:
				if (validValArray != null && validValArray.length > 1) {
					valid = valor.compareTo(validValArray[0]) > INTEGER_ZERO && valor.compareTo(validValArray[1]) < INTEGER_ZERO;
				}
				break;
			case URL:
				// TODO Aún no tenemos mecanismo para la validación contra URL
				break;
			default:
				break;
			}

			if (!valid) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_VALID_VALUE, String.valueOf(valor));
			}
		}
	}

	/**
	 * Validate dades operacio data general.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param valor
	 *            the valor
	 * @param tipusCampApiParamValue
	 *            the tipus camp api param value
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static void validateDadesOperacioDataGeneral(DadesOperacions dadesOperacions, DateTime valor,
	        TipusCampApiParamValue tipusCampApiParamValue) throws GPAApiParamValidationException {
		TipusValidacioApiParamValueTranslator tipusValidacioApiParamValueTranslator = new TipusValidacioApiParamValueTranslator();
		TipusValidacioApiParamValue tipusValidacioApiParamValue = null;
		DateTimeFormatter formatter = null;
		DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
		switch (tipusCampApiParamValue) {
		case DATA:
			formatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
			break;
		case DATA_HORA:
			formatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			break;
		case HORA:
			formatter = DateTimeFormat.forPattern(Constants.TIME_PATTERN);
			break;
		default:
			formatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			break;
		}
		boolean valid = true;
		for (DadesOperacionsValidacio dadesOperacionsValidacio : dadesOperacions.getDadesOperacionsValidacio()) {
			tipusValidacioApiParamValue = tipusValidacioApiParamValueTranslator
			        .getEnumByInternalValue(dadesOperacionsValidacio.getTipusValidacio());
			DadesOperValidVal dadesOperValidVal0 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ZERO);
			DateTime validVal0 = obetenirDateTime(tipusCampApiParamValue, dadesOperValidVal0);
			validVal0 = formatter.parseDateTime(formatter.print(validVal0));
			DadesOperValidVal dadesOperValidVal1 = null;
			DateTime validVal1 = null;
			DateTime[] validValArray = null;
			if (dadesOperacionsValidacio.getDadesOperacionsValidValors().size() > INTEGER_ONE) {
				// Es necesario comprobar la validación atendiendo al ordre
				dadesOperValidVal1 = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ONE);
				validVal1 = obetenirDateTime(tipusCampApiParamValue, dadesOperValidVal1);
				validVal1 = formatter.parseDateTime(formatter.print(validVal1));
				if (dadesOperValidVal0.getOrdre().longValue() < dadesOperValidVal1.getOrdre().longValue()) {
					validValArray = new DateTime[] { validVal0, validVal1 };
				} else {
					validValArray = new DateTime[] { validVal1, validVal0 };
				}
			}
			switch (tipusValidacioApiParamValue) {
			case OBLIGATORI:
				valid = valor != null;
				break;
			case MENOR:
				valid = valor.isBefore(validVal0);
				break;
			case MAJOR:
				valid = valor.isAfter(validVal0);
				break;
			case IGUAL:
				valid = valor.isEqual(validVal0);
				break;
			case MENOR_IGUAL:
				valid = (valor.isBefore(validVal0) || valor.isEqual(validVal0));
				break;
			case MAJOR_IGUAL:
				valid = (valor.isAfter(validVal0) || valor.isEqual(validVal0));
				break;
			case INTERVAL_TANCAT:
				if (validValArray != null && validValArray.length > 1) {
					valid = (valor.isAfter(validValArray[0]) || valor.isEqual(validValArray[0]))
					        && (valor.isBefore(validValArray[1]) || valor.isEqual(validValArray[1]));
				}
				break;
			case INTERVAL_OBERT:
				if (validValArray != null && validValArray.length > 1) {
					valid = (valor.isAfter(validValArray[0]) && valor.isBefore(validValArray[1]));
				}
				break;
			case URL:
				// TODO Aún no tenemos mecanismo para la validación contra URL
				break;
			default:
				break;
			}

			if (!valid) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_VALID_VALUE, formatter.print(valor));
			}
		}
	}

	/**
	 * Validate dades operacio dades externes.
	 *
	 * @param dadesExternes
	 *            the dades externes
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static void validateDadesOperacioDadesExternes(String dadesExternes) throws GPAApiParamValidationException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(dadesExternes);
		} catch (JsonParseException jpe) {
			log.info("El valor de la Dada d'operació DADES_EXTERNES no té format JSON", jpe);
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
			        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_DADES_EXTERNES_NOT_VALID_VALUE, String.valueOf(dadesExternes));
		} catch (IOException ioe) {
			log.info("El valor de la Dada d'operació DADES_EXTERNES no té format JSON", ioe);
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
			        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_DADES_EXTERNES_NOT_VALID_VALUE, String.valueOf(dadesExternes));
		}
	}

	/**
	 * @param tipusCampApiParamValue
	 * @param dataHoraFormatter
	 * @param dadesOperValidVal0
	 * @return
	 */
	private static DateTime obetenirDateTime(TipusCampApiParamValue tipusCampApiParamValue, DadesOperValidVal dadesOperValidVal0) {

		DateTime result = null;
		DateTimeFormatter formatter = DateTimeFormat.forPattern(Constants.DATE_PATTERN);
		DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);

		switch (tipusCampApiParamValue) {
		case DATA:
			result = formatter.parseDateTime(dadesOperValidVal0.getValor());
			break;
		case DATA_HORA:
			result = dataHoraFormatter.parseDateTime(dadesOperValidVal0.getValor().split(",")[0]);
			break;
		case HORA:
			result = dataHoraFormatter
			        .parseDateTime(formatter.print(new Date().getTime()).concat(" ").concat(dadesOperValidVal0.getValor()));
			break;
		default:
			result = dataHoraFormatter.parseDateTime(dadesOperValidVal0.getValor().split(",")[0]);
			break;
		}

		return result;
	}

	/**
	 * Validate dades operacio cadena general.
	 *
	 * @param dadesOperacions
	 *            the dades operacions
	 * @param valor
	 *            the valor
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static void validateDadesOperacioCadenaGeneral(DadesOperacions dadesOperacions, String valor)
	        throws GPAApiParamValidationException {
		TipusValidacioApiParamValueTranslator tipusValidacioApiParamValueTranslator = new TipusValidacioApiParamValueTranslator();
		TipusValidacioApiParamValue tipusValidacioApiParamValue = null;
		boolean valid = true;
		for (DadesOperacionsValidacio dadesOperacionsValidacio : dadesOperacions.getDadesOperacionsValidacio()) {
			tipusValidacioApiParamValue = tipusValidacioApiParamValueTranslator
			        .getEnumByInternalValue(dadesOperacionsValidacio.getTipusValidacio());
			DadesOperValidVal dadesOperValidVal = dadesOperacionsValidacio.getDadesOperacionsValidValors().get(INTEGER_ZERO);
			String validVal = dadesOperValidVal.getValor();
			switch (tipusValidacioApiParamValue) {
			case OBLIGATORI:
				valid = StringUtils.isNotEmpty(valor);
				break;
			case IGUAL:
				valid = StringUtils.equalsIgnoreCase(valor, validVal);
				break;
			case LONGITUD_MAXIMA:
				valid = valor.length() <= Long.valueOf(validVal).longValue();
				break;
			case MASCARA:
				// TODO Pendiente de formato para las máscaras
				break;
			case URL:
				// TODO Aún no tenemos mecanismo para la validación contra URL
				break;
			default:
				break;
			}

			if (!valid) {
				throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT,
				        ErrorPrincipal.ERROR_EXPEDIENTS_ATRIBUT_NOT_VALID_VALUE, String.valueOf(valor));
			}
		}
	}

	/**
	 * Validate document.
	 *
	 * @param docsRDTO
	 *            the docs RDTO
	 * @param expedientsRDTO
	 *            the expedients RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocument(DocsRDTO docsRDTO, ExpedientsRDTO expedientsRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (docsRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_FOUND);
		}

		if (!docsRDTO.getDocumentacio().equals(expedientsRDTO.getDocumentacioIdext())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_IN_EXPEDIENT);
		}
	}

	/**
	 * Validate document aportat.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param expedientsRDTO
	 *            the expedients RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentAportat(DocsEntradaRDTO docsEntradaRDTO, ExpedientsRDTO expedientsRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (docsEntradaRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_FOUND);
		}

		if (docsEntradaRDTO.getDocumentacio() == null || !docsEntradaRDTO.getDocumentacio().equals(expedientsRDTO.getDocumentacioIdext())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_IN_EXPEDIENT);
		}
	}

	/**
	 * Validate document aportat.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentAportat(DocsEntradaRDTO docsEntradaRDTO, DadesSollicitudBDTO dadesSollicitudBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		if (docsEntradaRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_FOUND);
		}

		if (!docsEntradaRDTO.getSollicitudIdext().equals(dadesSollicitudBDTO.getSollicitudsRDTO().getId())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_IN_SOLLICITUD);
		}
	}

	/**
	 * Validate document aportat esborrar.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentAportatEsborrar(DocsEntradaRDTO docsEntradaRDTO, DadesExpedientBDTO dadesExpedientBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		if (NumberUtils.INTEGER_ONE.compareTo(docsEntradaRDTO.getOrigen()) != 0) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_ORIGEN_EXTERN);
		}
	}

	/**
	 * Validate document generat esborrar.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentGeneratEsborrar(DocsTramitacioRDTO docsTramitacioRDTO, DadesExpedientBDTO dadesExpedientBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		if (NumberUtils.INTEGER_ONE.compareTo(docsTramitacioRDTO.getOrigen()) != 0) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_ORIGEN_EXTERN);
		}
	}

	/**
	 * Validate document upload.
	 *
	 * @param docsEntradaRDTO
	 *            the docs entrada RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentUpload(DocsEntradaRDTO docsEntradaRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (docsEntradaRDTO.getDeclaracioResponsable() != null && docsEntradaRDTO.getDeclaracioResponsable()
		        .compareTo(BooleanApiParamValue.TRUE.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
			throw new GPAApiParamValidationException(resultatError,
			        ErrorPrincipal.ERROR_DOCUMENTS_UPLOAD_DECLARACIO_RESPONSABLE_NOT_AVAILABLE);
		}
	}

	/**
	 * Validate document generat.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentGenerat(DocsTramitacioRDTO docsTramitacioRDTO, DadesExpedientBDTO dadesExpedientBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		if (docsTramitacioRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_FOUND);
		}

		if (!docsTramitacioRDTO.getDocumentacio().equals(dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_IN_EXPEDIENT);
		}
	}

	/**
	 * Validate document generat.
	 *
	 * @param idDocument
	 *            the id document
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentGenerat(BigDecimal idDocument, DocsTramitacioRDTO docsTramitacioRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (docsTramitacioRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_FOUND, ": " + idDocument);
		}
	}

	/**
	 * Validate document generat signat.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentGeneratSignat(DocsTramitacioRDTO docsTramitacioRDTO, DadesExpedientBDTO dadesExpedientBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		if (docsTramitacioRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_FOUND);
		}

		if (!docsTramitacioRDTO.getDocumentacio().equals(dadesExpedientBDTO.getExpedientsRDTO().getDocumentacioIdext())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_IN_EXPEDIENT);
		}

		if (docsTramitacioRDTO.getUltimaSignatura() == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_NOT_SIGNAT);
		}
	}

	/**
	 * Validate configuracio documentacio aportada.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentAportatCrearRDTOList
	 *            the document aportat crear RDTO list
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioAportada(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList, List<DocumentAportatCrearRDTO> documentAportatCrearRDTOList,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (CollectionUtils.isNotEmpty(documentAportatCrearRDTOList)) {
			ArrayList<String> uniqueIdConfiguracioDocumentacioList = new ArrayList<String>();
			for (DocumentAportatCrearRDTO documentAportatCrearRDTO : documentAportatCrearRDTOList) {
				uniqueIdConfiguracioDocumentacioList.add(documentAportatCrearRDTO.getConfiguracioDocumentacio());
			}
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        uniqueIdConfiguracioDocumentacioList, resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio digitalitzada.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentDigitalitzarCrearRDTOList
	 *            the document digitalitzar crear RDTO list
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioDigitalitzada(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList,
	        List<DocumentDigitalitzarCrearRDTO> documentDigitalitzarCrearRDTOList, Resultat resultatError)
	        throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (CollectionUtils.isNotEmpty(documentDigitalitzarCrearRDTOList)) {
			ArrayList<String> uniqueIdConfiguracioDocumentacioList = new ArrayList<String>();
			for (DocumentDigitalitzarCrearRDTO documentDigitalitzarCrearRDTO : documentDigitalitzarCrearRDTOList) {
				uniqueIdConfiguracioDocumentacioList.add(documentDigitalitzarCrearRDTO.getConfiguracioDocumentacio());
			}
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        uniqueIdConfiguracioDocumentacioList, resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio substituir.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentAportatSubstituirRDTO
	 *            the document aportat substituir RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioSubstituir(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList, DocumentAportatSubstituirRDTO documentAportatSubstituirRDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (documentAportatSubstituirRDTO != null) {
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        Arrays.asList(documentAportatSubstituirRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio esmenar.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentRequeritCrearRDTOList
	 *            the document requerit crear RDTO list
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioEsmenar(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList,
	        List<DocumentRequeritCrearRDTO> documentRequeritCrearRDTOList, Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (CollectionUtils.isNotEmpty(documentRequeritCrearRDTOList)) {
			ArrayList<String> idConfiguracioDocumentacioList = new ArrayList<String>();
			for (DocumentRequeritCrearRDTO documentRequeritCrearRDTO : documentRequeritCrearRDTOList) {
				idConfiguracioDocumentacioList.add(documentRequeritCrearRDTO.getConfiguracioDocumentacio());
			}
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        idConfiguracioDocumentacioList, resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio entrada incorporat nou.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentIncorporatNouRDTO
	 *            the document incorporat nou RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioEntradaIncorporatNou(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList, DocumentIncorporatNouRDTO documentIncorporatNouRDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (documentIncorporatNouRDTO != null) {
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        Arrays.asList(documentIncorporatNouRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio tramitacio incorporat nou.
	 *
	 * @param configuracioDocsTramitacioRDTOList
	 *            the configuracio docs tramitacio RDTO list
	 * @param documentIncorporatNouRDTO
	 *            the document incorporat nou RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsTramitacioRDTO> validateConfiguracioDocumentacioTramitacioIncorporatNou(
	        List<ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOList, DocumentIncorporatNouRDTO documentIncorporatNouRDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOMap = new HashMap<>();
		if (documentIncorporatNouRDTO != null) {
			configuracioDocsTramitacioRDTOMap = validateConfiguracioDocumentacioTramitacio(configuracioDocsTramitacioRDTOList,
			        Arrays.asList(documentIncorporatNouRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsTramitacioRDTOMap;
	}

	/**
	 * Validate configuracio documentacio entrada completat.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentCompletatRDTO
	 *            the document completat RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioEntradaCompletat(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList, DocumentCompletatRDTO documentCompletatRDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (documentCompletatRDTO != null) {
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        Arrays.asList(documentCompletatRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio tramitacio completat.
	 *
	 * @param configuracioDocsTramitacioRDTOList
	 *            the configuracio docs tramitacio RDTO list
	 * @param documentCompletatRDTO
	 *            the document completat RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsTramitacioRDTO> validateConfiguracioDocumentacioTramitacioCompletat(
	        List<ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOList, DocumentCompletatRDTO documentCompletatRDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOMap = new HashMap<>();
		if (documentCompletatRDTO != null) {
			configuracioDocsTramitacioRDTOMap = validateConfiguracioDocumentacioTramitacio(configuracioDocsTramitacioRDTOList,
			        Arrays.asList(documentCompletatRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsTramitacioRDTOMap;
	}

	/**
	 * Validate configuracio documentacio entrada declaracio responsable
	 * presentada.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param declaracioResponsablePresentadaRDTO
	 *            the declaracio responsable presentada RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioEntradaDeclaracioResponsablePresentada(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList,
	        DeclaracioResponsablePresentadaRDTO declaracioResponsablePresentadaRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (declaracioResponsablePresentadaRDTO != null) {
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        Arrays.asList(declaracioResponsablePresentadaRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio preparar requeriment expedient.
	 *
	 * @param documentacioRequerida
	 *            the documentacio requerida
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @return the array list
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static ArrayList<BigDecimal> validateConfiguracioDocumentacioPrepararRequerimentExpedient(
	        List<ConfiguracioDocumentacioRequeridaRDTO> documentacioRequerida,
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList) throws GPAApiParamValidationException {
		ArrayList<BigDecimal> idConfiguracioDocsEntradaList = null;
		if (CollectionUtils.isNotEmpty(documentacioRequerida)) {
			idConfiguracioDocsEntradaList = new ArrayList<BigDecimal>();
			HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<String, ConfiguracioDocsEntradaRDTO>();
			if (CollectionUtils.isNotEmpty(configuracioDocsEntradaRDTOList)) {
				for (ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO : configuracioDocsEntradaRDTOList) {
					configuracioDocsEntradaRDTOMap.put(configuracioDocsEntradaRDTO.getUniqueId().toString(), configuracioDocsEntradaRDTO);
				}
			}
			for (ConfiguracioDocumentacioRequeridaRDTO configuracioDocumentacioRequeridaRDTO : documentacioRequerida) {
				if (!configuracioDocsEntradaRDTOMap.containsKey(configuracioDocumentacioRequeridaRDTO.getConfiguracioDocumentacio())) {
					throw new GPAApiParamValidationException(Resultat.ERROR_PREPARAR_REQUERIMENT_EXPEDIENT,
					        ErrorPrincipal.ERROR_CONFIGURACIO_DOCUMENTACIO_REQUERIMENT_NOT_AVAILABLE,
					        configuracioDocumentacioRequeridaRDTO.getConfiguracioDocumentacio());
				}
				idConfiguracioDocsEntradaList.add(
				        configuracioDocsEntradaRDTOMap.get(configuracioDocumentacioRequeridaRDTO.getConfiguracioDocumentacio()).getId());
			}
		}
		return idConfiguracioDocsEntradaList;
	}

	/**
	 * Validate configuracio documentacio tramitacio requeriment preparat.
	 *
	 * @param configuracioDocsTramitacioRDTOList
	 *            the configuracio docs tramitacio RDTO list
	 * @param requerimentPreparatRDTO
	 *            the requeriment preparat RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsTramitacioRDTO> validateConfiguracioDocumentacioTramitacioRequerimentPreparat(
	        List<ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOList, RequerimentPreparatRDTO requerimentPreparatRDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOMap = new HashMap<>();
		if (requerimentPreparatRDTO != null) {
			configuracioDocsTramitacioRDTOMap = validateConfiguracioDocumentacioTramitacio(configuracioDocsTramitacioRDTOList,
			        Arrays.asList(requerimentPreparatRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsTramitacioRDTOMap;
	}

	/**
	 * Validate configuracio documentacio entrada.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param uniqueIdConfiguracioDocumentacioList
	 *            the unique id configuracio documentacio list
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioEntrada(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList, List<String> uniqueIdConfiguracioDocumentacioList,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<String, ConfiguracioDocsEntradaRDTO>();
		for (ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO : configuracioDocsEntradaRDTOList) {
			configuracioDocsEntradaRDTOMap.put(String.valueOf(configuracioDocsEntradaRDTO.getUniqueId()), configuracioDocsEntradaRDTO);
		}

		for (String idConfiguracioDocumentacio : uniqueIdConfiguracioDocumentacioList) {
			if (!configuracioDocsEntradaRDTOMap.containsKey(idConfiguracioDocumentacio)) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_CONFIGURACIO_DOCUMENTACIO_NOT_IN_EXPEDIENT,
				        idConfiguracioDocumentacio);
			}
		}

		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio tramitacio.
	 *
	 * @param configuracioDocsTramitacioRDTOList
	 *            the configuracio docs tramitacio RDTO list
	 * @param uniqueIdConfiguracioDocumentacioList
	 *            the unique id configuracio documentacio list
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	private static HashMap<String, ConfiguracioDocsTramitacioRDTO> validateConfiguracioDocumentacioTramitacio(
	        List<ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOList, List<String> uniqueIdConfiguracioDocumentacioList,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOMap = new HashMap<String, ConfiguracioDocsTramitacioRDTO>();
		for (ConfiguracioDocsTramitacioRDTO configuracioDocsTramitacioRDTO : configuracioDocsTramitacioRDTOList) {
			configuracioDocsTramitacioRDTOMap.put(String.valueOf(configuracioDocsTramitacioRDTO.getUniqueId()),
			        configuracioDocsTramitacioRDTO);
		}

		for (String idConfiguracioDocumentacio : uniqueIdConfiguracioDocumentacioList) {
			if (!configuracioDocsTramitacioRDTOMap.containsKey(idConfiguracioDocumentacio)) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_CONFIGURACIO_DOCUMENTACIO_NOT_IN_EXPEDIENT,
				        idConfiguracioDocumentacio);
			}
		}

		return configuracioDocsTramitacioRDTOMap;
	}

	/**
	 * Validate registre assentament.
	 *
	 * @param registreAssentamentRDTO
	 *            the registre assentament RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateRegistreAssentament(RegistreAssentamentRDTO registreAssentamentRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (registreAssentamentRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_REGISTRE_ASSENTAMENT_NOT_FOUND);
		}
	}

	/**
	 * Validate persona implicada expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param numeroDocumentIdentitat
	 *            the numero document identitat
	 * @param resultatError
	 *            the resultat error
	 * @return the persones sollicitud RDTO
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static PersonesSollicitudRDTO validatePersonaImplicada(List<PersonesSollicitudRDTO> personesImplicades,
	        String numeroDocumentIdentitat, Resultat resultatError) throws GPAApiParamValidationException {
		for (PersonesSollicitudRDTO personesSollicitudRDTO : personesImplicades) {
			if (personesSollicitudRDTO.getPersones().getDocumentsIdentitat() != null && StringUtils
			        .equals(personesSollicitudRDTO.getPersones().getDocumentsIdentitat().getNumeroDocument(), numeroDocumentIdentitat)) {
				return personesSollicitudRDTO;
			}
		}
		throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_IMPLICADA_NOT_FOUND);
	}

	/**
	 * Validate data limit.
	 *
	 * @param dataLimit
	 *            the data limit
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDataLimit(String dataLimit, Resultat resultatError) throws GPAApiParamValidationException {
		if (StringUtils.isNotEmpty(dataLimit)) {
			DateTimeFormatter dataHoraFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			DateTime valorDataHora = DateTime.parse(dataLimit, dataHoraFormatter);
			if (valorDataHora.isBeforeNow()) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_DATA_LIMIT_NOT_VALID);
			}
		}
	}

	/**
	 * Validate configuracio documentacio entrada digitalitzar.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param document
	 *            the document
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioEntradaDigitalitzar(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList, DocumentDigitalitzatRDTO document, Resultat resultatError)
	        throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (document != null) {
			ArrayList<String> uniqueIdConfiguracioDocumentacioList = new ArrayList<String>();
			uniqueIdConfiguracioDocumentacioList.add(document.getConfiguracioDocumentacio());
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        uniqueIdConfiguracioDocumentacioList, resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate configuracio documentacio tramitacio digitalitzar.
	 *
	 * @param configuracioDocsTramitacioRDTOList
	 *            the configuracio docs tramitacio RDTO list
	 * @param document
	 *            the document
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsTramitacioRDTO> validateConfiguracioDocumentacioTramitacioDigitalitzar(
	        List<ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOList, DocumentDigitalitzatRDTO document,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsTramitacioRDTO> configuracioDocsTramitacioRDTOMap = new HashMap<>();
		if (document != null) {
			ArrayList<String> uniqueIdConfiguracioDocumentacioList = new ArrayList<String>();
			uniqueIdConfiguracioDocumentacioList.add(document.getConfiguracioDocumentacio());
			configuracioDocsTramitacioRDTOMap = validateConfiguracioDocumentacioTramitacio(configuracioDocsTramitacioRDTOList,
			        uniqueIdConfiguracioDocumentacioList, resultatError);
		}
		return configuracioDocsTramitacioRDTOMap;
	}

	/**
	 * Validate configuracio documentacio entrada intraoperabilitat.
	 *
	 * @param configuracioDocsEntradaRDTOList
	 *            the configuracio docs entrada RDTO list
	 * @param documentIntraoperabilitatRDTO
	 *            the document intraoperabilitat RDTO
	 * @param resultatError
	 *            the resultat error
	 * @return the hash map
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static HashMap<String, ConfiguracioDocsEntradaRDTO> validateConfiguracioDocumentacioEntradaIntraoperabilitat(
	        List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList, DocumentIntraoperabilitatRDTO documentIntraoperabilitatRDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {
		HashMap<String, ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOMap = new HashMap<>();
		if (documentIntraoperabilitatRDTO != null) {
			configuracioDocsEntradaRDTOMap = validateConfiguracioDocumentacioEntrada(configuracioDocsEntradaRDTOList,
			        Arrays.asList(documentIntraoperabilitatRDTO.getConfiguracioDocumentacio()), resultatError);
		}
		return configuracioDocsEntradaRDTOMap;
	}

	/**
	 * Validate transicio accio disponible expedient.
	 *
	 * @param accionsEstatsRDTOList
	 *            the accions estats RDTO list
	 * @param accioTramitadorApiParamValue
	 *            the accio tramitador api param value
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateTransicioAccioDisponibleExpedient(List<AccionsEstatsRDTO> accionsEstatsRDTOList,
	        AccioTramitadorApiParamValue accioTramitadorApiParamValue, Resultat resultatError) throws GPAApiParamValidationException {

		if (accionsEstatsRDTOList == null || accionsEstatsRDTOList.size() == 0) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_TRANSICION_ESTAT_NOT_VALID,
			        accioTramitadorApiParamValue.getApiParamValue());
		}

	}

	/**
	 * Validate canviar estat expedient.
	 *
	 * @param accionsEstatsRDTOList
	 *            the accions estats RDTO list
	 * @param accioTramitadorApiParamValue
	 *            the accio tramitador api param value
	 * @param resultatError
	 *            the resultat error
	 * @return true, if successful
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static boolean validateCanviarEstatExpedient(List<AccionsEstatsRDTO> accionsEstatsRDTOList,
	        AccioTramitadorApiParamValue accioTramitadorApiParamValue, Resultat resultatError) throws GPAApiParamValidationException {
		if (accionsEstatsRDTOList == null || accionsEstatsRDTOList.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate documents signats expedient.
	 *
	 * @param documentsSignats
	 *            the documents signats
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateDocumentsSignatsExpedient(Boolean documentsSignats) throws GPAApiParamValidationException {
		if (!documentsSignats) {
			throw new GPAApiParamValidationException(Resultat.ERROR_DOCUMENT_SIGNAT_EXPEDIENT,
			        ErrorPrincipal.ERROR_DOCUMENTS_EXPEDIENTS_NO_SIGNATS);
		}
	}

	/**
	 * Valida que uno de los dos parametros no sea nulo.
	 *
	 * @param file
	 *            the file
	 * @param idGestorDocumental
	 *            the id gestor documental
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateEntradaUpload(MultipartFile file, String idGestorDocumental, Resultat resultatError)
	        throws GPAApiParamValidationException {

		if (null == file && StringUtils.isEmpty(idGestorDocumental)) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_ENTRADA_DOCUMENTS_UPLOAD);
		}

	}

	/**
	 * Validate actualitzar sollicitud.
	 *
	 * @param dadesSollicitudBDTO
	 *            the dades sollicitud BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateActualitzarSollicitud(DadesSollicitudBDTO dadesSollicitudBDTO,
	        SollicitudActualitzarRDTO sollicitudActualitzar, Resultat resultatError) throws GPAApiParamValidationException {

		validateSollicitud(dadesSollicitudBDTO, resultatError);

		if (dadesSollicitudBDTO.getSollicitudsRDTO().getTramitOvtIdext()
		        .compareTo(TramitOvtApiParamValue.APO.getInternalValue()) == NumberUtils.INTEGER_ZERO
		        && CollectionUtils.isNotEmpty(sollicitudActualitzar.getDadesOperacio())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_SOLLICITUDS_DADES_OPERACIO_APO);
		}
	}

	public static void validatePersonesInteressadesExpedient(List<PersonesRDTO> personesInteressades, Resultat resultatError)
	        throws GPAApiParamValidationException {

		if (personesInteressades != null) {
			for (PersonesRDTO personeRDTO : personesInteressades) {
				if (personeRDTO.getRelacio() != null
				        && personeRDTO.getRelacio().compareTo(RelacioPersonaApiParamValue.SOLLICITANT.getApiParamValue()) != 0
				        && personeRDTO.getRelacio().compareTo(RelacioPersonaApiParamValue.REPRESENTANT.getApiParamValue()) != 0) {

					throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_INTERESADA_RELACIO);
				}
			}
		}

	}

	/**
	 * Validate usuari logueado expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static PersonesSollicitudRDTO validateUsuariLogueadoExpedient(String nifInteressat,
	        List<PersonesSollicitudRDTO> personesInteressades, List<PersonesSollicitudRDTO> personesImplicades,
	        Persones sollicitantPrincipal, Persones representantPrincipal, Resultat resultatError) throws GPAApiParamValidationException {

		// Comprobar que la persona que realiza la accion pertenece al
		// expediente (El documento de identidad debe corresponderse con el
		// de una
		// persona implicada en el expediente)

		PersonesSollicitudRDTO interesado = null;
		PersonesSollicitudRDTO implicado = null;

		if (personesInteressades != null) {
			interesado = validateUsuariLogueadoInteressadesExpedient(nifInteressat, personesInteressades, sollicitantPrincipal,
			        representantPrincipal, resultatError);
		}

		if (personesImplicades != null) {
			implicado = validateUsuariLogueadoImplicadesExpedient(nifInteressat, personesImplicades, resultatError);
		}

		if (interesado == null && implicado == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_LOGUEADA_NOT_FOUND);
		}
		// se entiende que si es solicitante o representante, si puede hacer
		// cualquier accion

		return implicado;
	}

	/**
	 * Validate usuari logueado interessades en expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static PersonesSollicitudRDTO validateUsuariLogueadoInteressadesExpedient(String nifInteressat,
	        List<PersonesSollicitudRDTO> personesInteressades, Persones sollicitantPrincipal, Persones representantPrincipal,
	        Resultat resultatError) throws GPAApiParamValidationException {

		for (PersonesSollicitudRDTO personesSollicitud : personesInteressades) {
			if (personesSollicitud.getPersones().getDocumentsIdentitat() != null
			        && StringUtils.equals(personesSollicitud.getPersones().getDocumentsIdentitat().getNumeroDocument(), nifInteressat)
			        && personesSollicitud.getVisibilitatOvt() == NumberUtils.INTEGER_ONE) {
				return personesSollicitud;
			}
		}

		// solo necesitamos comprobar que existe
		if (sollicitantPrincipal.getDocumentsIdentitat() != null
		        && StringUtils.equals(sollicitantPrincipal.getDocumentsIdentitat().getNumeroDocument(), nifInteressat)) {
			return new PersonesSollicitudRDTO();
		}

		if (representantPrincipal != null && representantPrincipal.getDocumentsIdentitat() != null
		        && StringUtils.equals(representantPrincipal.getDocumentsIdentitat().getNumeroDocument(), nifInteressat)) {
			return new PersonesSollicitudRDTO();
		}

		return null;
	}

	/**
	 * Validate usuari logueado interessades en expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static PersonesSollicitudRDTO validateUsuariLogueadoInteressades(ClientEntity clientEntity,
	        List<PersonesSollicitudRDTO> personesInteressades, Persones sollicitantPrincipal, Persones representantPrincipal,
	        Resultat resultatError) throws GPAApiParamValidationException {

		ServeisRestControllerVisibilitatHelper.validarCapçaleresUsuari(clientEntity, Resultat.ERROR_OBTENIR_EXPEDIENT);

		String nifInteressat = clientEntity.getUsuariInteressat();

		PersonesSollicitudRDTO personesSollicitudRDTO = null;
		// Portal siempre filtrara por el ciudadado y el Portal del informador
		// cuando actuen en nombre del ciudadano
		if (!StringUtils.isEmpty(nifInteressat)) {
			personesSollicitudRDTO = validateUsuariLogueadoInteressadesExpedient(nifInteressat, personesInteressades, sollicitantPrincipal,
			        representantPrincipal, resultatError);

			if (personesSollicitudRDTO == null) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_LOGUEADA_NOT_FOUND);
			}
		}

		return personesSollicitudRDTO;
	}

	/**
	 * Validate usuari logueado interessades en expedient.
	 * 
	 * @param idTramitOvt
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static PersonesRDTO validateUsuariLogueadoInteressadesExpedient(ClientEntity clientEntity,
	        DadesProcedimentBDTO dadesProcedimentBDTO, List<PersonesRDTO> personesInteressades, List<PersonesRDTO> personesImplicades,
	        PersonesRDTO sollicitantPrincipal, PersonesRDTO representantPrincipal, BigDecimal idTramitOvt, Resultat resultatError)
	        throws GPAApiParamValidationException {

		ServeisRestControllerVisibilitatHelper.validarCapçaleresUsuari(clientEntity, resultatError);

		String nifInteressat = clientEntity.getUsuariInteressat();

		if (!StringUtils.isEmpty(nifInteressat)) {

			if (personesInteressades != null) {
				for (PersonesRDTO personesSollicitud : personesInteressades) {
					if (personesSollicitud.getDocumentIndentitat() != null
					        && StringUtils.equals(personesSollicitud.getDocumentIndentitat().getNumeroDocument(), nifInteressat)) {
						return personesSollicitud;
					}
				}
			}

			if (sollicitantPrincipal != null && sollicitantPrincipal.getDocumentIndentitat() != null
			        && StringUtils.equals(sollicitantPrincipal.getDocumentIndentitat().getNumeroDocument(), nifInteressat)) {
				return sollicitantPrincipal;
			}

			if (representantPrincipal != null && representantPrincipal.getDocumentIndentitat() != null
			        && StringUtils.equals(representantPrincipal.getDocumentIndentitat().getNumeroDocument(), nifInteressat)) {
				return representantPrincipal;
			}

			if (personesImplicades != null) {
				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ServeisRestControllerValidationHelper.validateTerceresPersonesImplicadesExpedient(nifInteressat, personesImplicades,
				        procedimentPersonesList, idTramitOvt, resultatError);

				// valido
				return new PersonesRDTO();
			}

			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_LOGUEADA_NOT_FOUND);

		} else {
			// validamos si vienen implicados para ver si la relacion es
			// correcta
			if (personesImplicades != null) {
				List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

				ServeisRestControllerValidationHelper.validateTerceresPersonesImplicadesExpedient(nifInteressat, personesImplicades,
				        procedimentPersonesList, idTramitOvt, resultatError);
			}
			// valido
			return new PersonesRDTO();
		}

	}

	/**
	 * Validate terceres persones implicades en expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateTerceresPersonesImplicadesExpedient(String nifInteressat, List<PersonesRDTO> personesImplicades,
	        List<ProcedimentPersones> procedimentPersonesList, BigDecimal idTramitOvt, Resultat resultatError)
	        throws GPAApiParamValidationException {

		if (procedimentPersonesList == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT);
		}

		// tiene que existir y coincidir un tipo de relacion del procedimiento
		// con cada una de las personas para darlo por valido
		boolean existeRelacion = false;
		for (PersonesRDTO personesRDTO : personesImplicades) {
			existeRelacion = false;
			if (StringUtils.isEmpty(personesRDTO.getRelacioTerceraPersona())) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES);
			}
			for (ProcedimentPersones procedimentPersones : procedimentPersonesList) {
				if (procedimentPersones.getRelacio().equalsIgnoreCase(personesRDTO.getRelacioTerceraPersona())) {
					existeRelacion = true;
				}
			}
		}

		if (!existeRelacion) {
			throw new GPAApiParamValidationException(resultatError,
			        ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT_NOT_FOUND);
		}

		// identificacion de si la persona interesada es implicada y tiene
		// habilitado el tramite ovt
		if (idTramitOvt != null && !StringUtils.isEmpty(nifInteressat)) {
			boolean tramitOvtValido = false;
			for (PersonesRDTO personesRDTO : personesImplicades) {
				for (ProcedimentPersones procedimentPersones : procedimentPersonesList) {
					if (procedimentPersones.getRelacio().equalsIgnoreCase(personesRDTO.getRelacioTerceraPersona())
					        && nifInteressat.equalsIgnoreCase(personesRDTO.getDocumentIndentitat().getNumeroDocument())) {
						// en funcion del tramite que se vaya a realizar,
						// comprobar
						// si esa persona lo tiene definido para poder
						// ejecutarlo
						for (ProcedimentPersonesTramOvt procedimentPersonesTramOvt : procedimentPersones.getTramitsOvtList()) {
							if (procedimentPersonesTramOvt.getTramitOvtIdext().compareTo(idTramitOvt) == NumberUtils.INTEGER_ZERO) {
								tramitOvtValido = true;
							}
						}
					}
				}
			}
			if (!tramitOvtValido) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_LOGUEADA_NOT_PERMIS);
			}
		}
	}

	/**
	 * Validate terceres persones implicades en expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateTerceresPersonesImplicadesExpedient(List<PersonesRDTO> personesImplicades,
	        List<ProcedimentPersones> procedimentPersonesList, Resultat resultatError) throws GPAApiParamValidationException {

		if (procedimentPersonesList == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT);
		}

		// tiene que existir y coincidir un tipo de relacion del procedimiento
		// con cada una de las personas para darlo por valido
		boolean existeRelacion = false;
		for (PersonesRDTO personesRDTO : personesImplicades) {
			existeRelacion = false;
			if (StringUtils.isEmpty(personesRDTO.getRelacioTerceraPersona())) {
				throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES);
			}
			for (ProcedimentPersones procedimentPersones : procedimentPersonesList) {
				if (procedimentPersones.getRelacio().equalsIgnoreCase(personesRDTO.getRelacioTerceraPersona())) {
					existeRelacion = true;
				}
			}
		}

		if (!existeRelacion) {
			throw new GPAApiParamValidationException(resultatError,
			        ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT_NOT_FOUND);
		}
	}

	/**
	 * Validate usuari logueado implicades en expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static PersonesSollicitudRDTO validateUsuariLogueadoImplicadesExpedient(String nifInteressat,
	        List<PersonesSollicitudRDTO> personesImplicades, Resultat resultatError) throws GPAApiParamValidationException {

		for (PersonesSollicitudRDTO personesSollicitud : personesImplicades) {
			if (personesSollicitud.getPersones().getDocumentsIdentitat() != null
			        && StringUtils.equals(personesSollicitud.getPersones().getDocumentsIdentitat().getNumeroDocument(), nifInteressat)
			        && personesSollicitud.getVisibilitatOvt() != null
			        && personesSollicitud.getVisibilitatOvt().intValue() == NumberUtils.INTEGER_ONE.intValue()) {
				return personesSollicitud;
			}
		}

		return null;
	}

	/**
	 * validateVisibilitatImplicado
	 * 
	 * @param implicado
	 * @param respostaDadesOperacioCercaBDTO
	 * @param respostaDocumentsEntradaCercaBDTO
	 * @param docsEntradaRDTO
	 * @param docsTramitacioRDTO
	 * @param procedimentPersonesList
	 */
	public static ProcedimentPersones validateVisibilitatImplicado(PersonesSollicitudRDTO implicado, List<DadesOperacions> dadesActualizar,
	        List<ConfiguracioDocsEntradaRDTO> configuacioActualizar, DocsEntradaRDTO docsEntradaRDTO, DocsTramitacioRDTO docsTramitacioRDTO,
	        List<ProcedimentPersones> procedimentPersonesList, BigDecimal idTramitOvt, Resultat resultatError)
	        throws GPAApiParamValidationException {

		boolean tramitOvtValido = false;
		if (procedimentPersonesList == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT);
		}

		if (StringUtils.isEmpty(implicado.getRelacioImplicada())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES);
		}
		ProcedimentPersones procedimentPersonesFind = null;
		for (ProcedimentPersones procedimentPersones : procedimentPersonesList) {
			if (procedimentPersones.getRelacio().equalsIgnoreCase(implicado.getRelacioImplicada())) {

				procedimentPersonesFind = procedimentPersones;

				// en funcion del tramite que se vaya a realizar, comprobar
				// si esa persona lo tiene definido para poder ejecutarlo
				if (idTramitOvt != null && procedimentPersones.getTramitsOvtList() != null) {
					for (ProcedimentPersonesTramOvt procedimentPersonesTramOvt : procedimentPersones.getTramitsOvtList()) {
						if (procedimentPersonesTramOvt.getTramitOvtIdext().compareTo(idTramitOvt) == NumberUtils.INTEGER_ZERO) {
							tramitOvtValido = true;
						}
					}
					if (!tramitOvtValido) {
						throw new GPAApiParamValidationException(resultatError,
						        ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_LOGUEADA_NOT_PERMIS);
					}
				}

				if (procedimentPersones.getNivellVisibilitat().compareTo(Constants.NIVELL_VISIBILITAT_NULLA) == 0) {
					throw new GPAApiParamValidationException(resultatError,
					        ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT_VISIBILITAT);
				}

				if (dadesActualizar != null) {
					for (DadesOperacions dadesOperacions : dadesActualizar) {
						if (dadesOperacions.getVisibilitatPortal().compareTo(INTEGER_ZERO) == 0) {
							throw new GPAApiParamValidationException(resultatError,
							        ErrorPrincipal.ERROR_EXPEDIENTS_DADES_OPERACIO_PROCEDIMENT_VISIBILITAT_PORTAL);
						} else if (procedimentPersonesFind.getNivellVisibilitat().compareTo(Constants.NIVELL_VISIBILITAT_BAIXA) == 0
						        && dadesOperacions.getNivellCriticitat().compareTo(Constants.NIVELL_CRITICITAT_ALT) == 0) {
							throw new GPAApiParamValidationException(resultatError,
							        ErrorPrincipal.ERROR_EXPEDIENTS_DADES_OPERACIO_PROCEDIMENT_CRITICITAT);
						}
					}
				}
				if (configuacioActualizar != null) {
					for (ConfiguracioDocsEntradaRDTO configuracioDocsEntradaRDTO : configuacioActualizar) {
						if (configuracioDocsEntradaRDTO.getVisibilitatPortal() != null
						        && configuracioDocsEntradaRDTO.getVisibilitatPortal().compareTo(INTEGER_ZERO) == 0) {
							throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_DOC_VISIBILITAT_PORTAL);
						} else if (procedimentPersonesFind.getNivellVisibilitat().compareTo(Constants.NIVELL_VISIBILITAT_BAIXA) == 0
						        && configuracioDocsEntradaRDTO.getCriticitatIdext().compareTo(Constants.NIVELL_CRITICITAT_ALT) == 0) {
							throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_DOC_CRITICITAT);
						}
					}
				}

				if (docsEntradaRDTO != null && docsEntradaRDTO.getConfiguracioDocsEntrada() != null
				        && docsEntradaRDTO.getConfiguracioDocsEntrada().getVisibilitatPortal() != null) {
					if (docsEntradaRDTO.getConfiguracioDocsEntrada().getVisibilitatPortal().compareTo(INTEGER_ZERO) == 0) {
						throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_DOC_VISIBILITAT_PORTAL);
					} else if (procedimentPersonesFind.getNivellVisibilitat().compareTo(Constants.NIVELL_VISIBILITAT_BAIXA) == 0
					        && docsEntradaRDTO.getConfiguracioDocsEntrada().getCriticitatIdext() != null && docsEntradaRDTO
					                .getConfiguracioDocsEntrada().getCriticitatIdext().compareTo(Constants.NIVELL_CRITICITAT_ALT) == 0) {
						throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_DOC_CRITICITAT);
					}
				}

				if (docsTramitacioRDTO != null && docsTramitacioRDTO.getConfiguracioDocsTramitacio() != null
				        && docsTramitacioRDTO.getConfiguracioDocsTramitacio().getVisibilitatPortal() != null) {
					if (docsTramitacioRDTO.getConfiguracioDocsTramitacio().getVisibilitatPortal().compareTo(INTEGER_ZERO) == 0) {
						throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_DOC_VISIBILITAT_PORTAL);
					} else if (procedimentPersonesFind.getNivellVisibilitat().compareTo(Constants.NIVELL_VISIBILITAT_BAIXA) == 0
					        && docsTramitacioRDTO.getConfiguracioDocsTramitacio().getCriticitatIdext() != null && docsTramitacioRDTO
					                .getConfiguracioDocsTramitacio().getCriticitatIdext().compareTo(Constants.NIVELL_CRITICITAT_ALT) == 0) {
						throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_DOC_CRITICITAT);
					}
				}
			}
		}
		if (procedimentPersonesFind == null) {
			throw new GPAApiParamValidationException(resultatError,
			        ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT_NOT_FOUND);
		} else {
			return procedimentPersonesFind;
		}
	}

	/**
	 * 
	 * @param solicitudExpedient
	 * @param dadesProcedimentBDTO
	 * @throws GPAApiParamValidationException
	 */
	public static void validateRelacioTerceresPersones(PersonesRDTO personaImplicada, DadesProcedimentBDTO dadesProcedimentBDTO,
	        Resultat resultatError) throws GPAApiParamValidationException {

		if (personaImplicada != null && personaImplicada.getRelacioTerceraPersona() != null) {
			List<ProcedimentPersones> procedimentPersonesList = dadesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();

			ServeisRestControllerValidationHelper.validateTerceresPersonesImplicadesExpedient(Arrays.asList(personaImplicada),
			        procedimentPersonesList, resultatError);
		} else {
			throw new GPAApiParamValidationException(resultatError,
			        ErrorPrincipal.ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT_NOT_FOUND);
		}

	}

	/**
	 * Validate signatura valid.
	 *
	 * @param signaturaValidDocumentRDTO
	 *            the signatura valid document RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateSignaturaValid(SignaturaValidDocumentRDTO signaturaValidDocumentRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {

		// Se valida el formato del token JWT
		if (StringUtils.isBlank(signaturaValidDocumentRDTO.getInformacioToken())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_TOKEN_JWT_SIGNAR_VALID);
		}

		String value = null;
		String posibleToken = signaturaValidDocumentRDTO.getInformacioToken().trim();
		for (Matcher matcher = JWT_PATTERN.matcher(posibleToken); matcher.find(); value = posibleToken.trim()) {
			;
		}

		if (value == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_TOKEN_JWT_SIGNAR_VALID);
		}
	}

	/**
	 * Validate usuari.
	 *
	 * @param usuarisRDTO
	 *            the usuaris RDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateUsuari(UsuarisRDTO usuarisRDTO, Resultat resultatError) throws GPAApiParamValidationException {
		if (usuarisRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_UNITATS_USUARI_NOT_FOUND);
		}
	}

	/**
	 * Validate peticio amb documents signats.
	 *
	 * @param peticioAmbDocumentsSignats
	 *            the peticio amb documents signats
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validatePeticioAmbDocumentsSignats(Boolean peticioAmbDocumentsSignats, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (BooleanUtils.isFalse(peticioAmbDocumentsSignats)) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_PETICIO_SIGNATURA_SENSE_DOCUMENTS_SIGNATS);
		}
	}

	/**
	 * Validate seguent signatura manuscrita.
	 *
	 * @param docsTramitacioRDTO
	 *            the docs tramitacio RDTO
	 * @param errorSignarDocument
	 *            the error signar document
	 * @throws GPAApiParamValidationException
	 */
	public static void validateSeguentSignaturaManuscrita(DocsTramitacioRDTO docsTramitacioRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (CollectionUtils.isEmpty(docsTramitacioRDTO.getDocsSignaturesPendents())
		        || docsTramitacioRDTO.getDocsSignaturesPendents().get(0).getConfDocsTramPolitiquesSigEntity() == null
		        || docsTramitacioRDTO.getDocsSignaturesPendents().get(0).getConfDocsTramPolitiquesSigEntity().getModalitatIdext()
		                .compareTo(TipusSignaturaApiParamValue.MANUSCRITA.getInternalValue()) != NumberUtils.INTEGER_ZERO) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_SENSE_PETICIO_SIGNATURA_MANUSCRITA);
		}
	}

	public static void validateDocumentPoliticaSignatura(String politicaSignatura, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if (StringUtils.isEmpty(politicaSignatura)) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_DOCUMENTS_POLITICA_SIGNATURA);
		}
	}

	/**
	 * @param respostaConsultaTramitProcedimentRDTO
	 * @param dadesProcedimentBDTO
	 * @param iinternalIdTramitOvt
	 * @throws GPAServeisServiceException
	 */
	public static void validateTramitOvtRequerimentOperatiu(RespostaConsultaTramitProcedimentRDTO respostaConsultaTramitProcedimentRDTO,
	        DadesProcedimentBDTO dadesProcedimentBDTO, BigDecimal iinternalIdTramitOvt) throws GPAServeisServiceException {

		if (dadesProcedimentBDTO.getProcedimentsRDTO().getReqOperatius() != null
		        && dadesProcedimentBDTO.getProcedimentsRDTO().getReqOperatius().getReqOperatiusTramOvtList() != null) {
			for (ReqOperatiusTramOvt reqOperatiusTramOvt : dadesProcedimentBDTO.getProcedimentsRDTO().getReqOperatius()
			        .getReqOperatiusTramOvtList()) {
				if (reqOperatiusTramOvt.getTramitOvtIdext().compareTo(iinternalIdTramitOvt) == 0) {
					// Trámite genérico
					if (reqOperatiusTramOvt.getTramitGeneric() != null && reqOperatiusTramOvt.getTramitGeneric().intValue() == 1) {
						respostaConsultaTramitProcedimentRDTO.setTramitGeneric("SI");
					} else {
						respostaConsultaTramitProcedimentRDTO.setTramitGeneric("NO");
						respostaConsultaTramitProcedimentRDTO.setDetallIdentificador(reqOperatiusTramOvt.getIdentificadorTramit());
					}
					// Firma
					if (reqOperatiusTramOvt.getTramitSignaturaCiutada() != null && reqOperatiusTramOvt.getTramitSignaturaCiutada() == 1) {
						respostaConsultaTramitProcedimentRDTO.setSignatura("SI");
					} else {
						respostaConsultaTramitProcedimentRDTO.setSignatura("NO");
					}
					// Registro
					if (reqOperatiusTramOvt.getTramitRegistre() != null && reqOperatiusTramOvt.getTramitRegistre() == 1) {
						respostaConsultaTramitProcedimentRDTO.setRegistre("SI");
					} else {
						respostaConsultaTramitProcedimentRDTO.setRegistre("NO");
					}
				}
			}
		}

		if (StringUtils.isEmpty(respostaConsultaTramitProcedimentRDTO.getTramitGeneric())) {
			throw new GPAServeisServiceException(ErrorPrincipal.ERROR_PROCEDIMENTS_TRAM_OVT_NOT_FOUND.getDescripcio());
		}
	}

	/**
	 * Validate persona sol·licitant principal.
	 *
	 * @param Persones
	 *            the Persones sollicitant
	 * @param idPersona
	 *            idPersona
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validatePersonaSollicitantprincipal(PersonesSollicitudRDTO personesSollicitudRDTO, Resultat resultatError)
	        throws GPAApiParamValidationException {
		if ((personesSollicitudRDTO.getEsInteressada() != null
		        && personesSollicitudRDTO.getEsInteressada().intValue() == NumberUtils.INTEGER_ONE.intValue())
		        && (personesSollicitudRDTO.getRelacio() != null
		                && personesSollicitudRDTO.getRelacio().intValue() == NumberUtils.INTEGER_ONE.intValue())
		        && (personesSollicitudRDTO.getRelacioPrincipal() != null
		                && personesSollicitudRDTO.getRelacioPrincipal().intValue() == NumberUtils.INTEGER_ONE.intValue())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_PERSONA_SOLLICITANT_PRINCIPAL);
		}
	}

	/**
	 * Validate persones sollicitud Is Not Null.
	 *
	 * @param PersonesSollicitudRDTO
	 *            the Persones sollicitud RDTO
	 * @param idPersona
	 *            idPersona
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validatePersonesSollicitudIsNotNull(PersonesSollicitudRDTO personesSollicitudRDTO, String idPersona,
	        Resultat resultatError) throws GPAApiParamValidationException {
		if (personesSollicitudRDTO == null) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_PERSONES_SOLLICITUD_NOT_FOUND, idPersona);
		}
	}
	
	/**
	 * validateIsTancat.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param transicioAccioTancarExpedient
	 *            the numero document identitat
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateIsTancat(DadesExpedientBDTO dadesExpedientBDTO,
	        AccioTramitadorApiParamValue transicioAccioTancarExpedient, Resultat resultatError) throws GPAApiParamValidationException {
		if (dadesExpedientBDTO.getExpedientsRDTO() != null && dadesExpedientBDTO.getExpedientsRDTO().getEstat() != null && 
				!dadesExpedientBDTO.getExpedientsRDTO().getEstat().getAccioEstatIdext().equals(transicioAccioTancarExpedient.getInternalValue())) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_NO_TANCAT);
		}
	}
	
	/**
	 * validateIsTancamentAutomatic.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param resultatError
	 *            the resultat error
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateIsTancamentAutomatic(DadesExpedientBDTO dadesExpedientBDTO, Resultat resultatError) throws GPAApiParamValidationException {
		if (dadesExpedientBDTO.getExpedientsRDTO() != null && dadesExpedientBDTO.getExpedientsRDTO().getEstat() != null && 
				!dadesExpedientBDTO.getExpedientsRDTO().getEstat().getTancamentAutomatic().equals(NumberUtils.INTEGER_ONE)) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_NO_TANCAMENT_AUTOMATIC);
		}
	}
	
	
	/**
	 * get id usuari interessat.
	 *
	 * @param clientEntity
	 * 			the clientEntity
	 * @param personesInteressades
	 * 			the personesInteressades
	 * @param sollicitantPrincipal
	 * 			the sollicitantPrincipal
	 * @param representantPrincipal
	 * 			the representantPrincipal
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static BigDecimal getIdUsuariInteressat(ClientEntity clientEntity,
	        List<PersonesSollicitudRDTO> personesInteressades, Persones sollicitantPrincipal, Persones representantPrincipal) throws GPAApiParamValidationException {

		String nifInteressat = clientEntity.getUsuariInteressat();
		
		if (!StringUtils.isEmpty(nifInteressat)) {
			for (PersonesSollicitudRDTO personesSollicitud : personesInteressades) {
				if (personesSollicitud.getPersones().getDocumentsIdentitat() != null
				        && StringUtils.equals(personesSollicitud.getPersones().getDocumentsIdentitat().getNumeroDocument(), nifInteressat)) {
					return personesSollicitud.getId();
				}
			}
	
			if (sollicitantPrincipal.getDocumentsIdentitat() != null
			        && StringUtils.equals(sollicitantPrincipal.getDocumentsIdentitat().getNumeroDocument(), nifInteressat)) {
				return sollicitantPrincipal.getId();
			}
	
			if (representantPrincipal != null && representantPrincipal.getDocumentsIdentitat() != null
			        && StringUtils.equals(representantPrincipal.getDocumentsIdentitat().getNumeroDocument(), nifInteressat)) {
				return representantPrincipal.getId();
			}
		}

		return null;
	}

	public static void validateExpedientIsBorrant(DadesExpedientBDTO dadesExpedientBDTO,
			Resultat resultatError) throws GPAApiParamValidationException {
		if (dadesExpedientBDTO.getExpedientsRDTO().getIdEstat().equals(BigDecimal.ONE)) {
			throw new GPAApiParamValidationException(resultatError, ErrorPrincipal.ERROR_EXPEDIENTS_ESTA_EN_BORRADOR);
		}
		
	}
}