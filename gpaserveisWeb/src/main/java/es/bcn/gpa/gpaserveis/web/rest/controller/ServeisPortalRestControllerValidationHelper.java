package es.bcn.gpa.gpaserveis.web.rest.controller;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsUgos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.EstatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;

/**
 * The Class ServeisPortalRestControllerValidationHelper.
 */
public class ServeisPortalRestControllerValidationHelper {

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
		        .compareTo(EstatApiParamValue.PUBLICAT.getInternalValue()) != NumberUtils.INTEGER_ZERO) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_PROCEDIMENTS_NOT_PUBLICAT);
		}
	}

	/**
	 * Validate unitat gestora crear solicitud expedient.
	 *
	 * @param unitatsGestoresRDTO
	 *            the unitats gestores RDTO
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateUnitatGestoraCrearSolicitudExpedient(UnitatsGestoresRDTO unitatsGestoresRDTO,
	        DadesProcedimentBDTO dadesProcedimentBDTO) throws GPAApiParamValidationException {
		// La Unitat Gestora debe existir, estar vigente y estar asociada al
		// procedimiento
		if (unitatsGestoresRDTO == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_FOUND);
		}

		if (unitatsGestoresRDTO.getVigent() == INTEGER_ZERO) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_VIGENT);
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
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_IN_PROCEDIMENT);
		}
	}

	/**
	 * Validate unitat gestora actualitzar solicitud expedient.
	 *
	 * @param unitatsGestoresRDTO
	 *            the unitats gestores RDTO
	 * @param dadesProcedimentBDTO
	 *            the dades procediment BDTO
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	// TODO Unificar código repetido
	public static void validateUnitatGestoraActualitzarSolicitudExpedient(UnitatsGestoresRDTO unitatsGestoresRDTO,
	        DadesProcedimentBDTO dadesProcedimentBDTO) throws GPAApiParamValidationException {
		// La Unitat Gestora debe existir, estar vigente y estar asociada al
		// procedimiento
		if (unitatsGestoresRDTO == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_FOUND);
		}

		if (unitatsGestoresRDTO.getVigent() == INTEGER_ZERO) {
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_VIGENT);
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
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_IN_PROCEDIMENT);
		}
	}

	/**
	 * Validate expedient actualitzar solicitud expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateExpedientActualitzarSolicitudExpedient(DadesExpedientBDTO dadesExpedientBDTO)
	        throws GPAApiParamValidationException {
		if (dadesExpedientBDTO.getExpedientsRDTO() == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, ErrorPrincipal.ERROR_EXPEDIENTS_NOT_FOUND);
		}
	}

	/**
	 * Validate accio disponible expedient.
	 *
	 * @param dadesExpedientBDTO
	 *            the dades expedient BDTO
	 * @param accioTramitadorApiParamValue
	 *            the accio tramitador api param value
	 * @throws GPAApiParamValidationException
	 *             the GPA api param validation exception
	 */
	public static void validateAccioDisponibleExpedient(DadesExpedientBDTO dadesExpedientBDTO,
	        AccioTramitadorApiParamValue accioTramitadorApiParamValue) throws GPAApiParamValidationException {
		for (AccionsEstatsRDTO accionsEstatsRDTO : dadesExpedientBDTO.getAccionsDisponibles()) {
			if (accionsEstatsRDTO.getAccio().compareTo(accioTramitadorApiParamValue.getInternalValue()) == NumberUtils.INTEGER_ZERO) {
				return;
			}
		}
		throw new GPAApiParamValidationException(Resultat.ERROR_ACTUALITZAR_EXPEDIENT, ErrorPrincipal.ERROR_EXPEDIENTS_ACCIO_NOT_AVAILABLE,
		        accioTramitadorApiParamValue.getApiParamValue());
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
}