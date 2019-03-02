package es.bcn.gpa.gpaserveis.web.rest.controller;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

import org.apache.commons.collections.CollectionUtils;

import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.exception.GPAApiParamValidationException;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.ErrorPrincipal;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.Resultat;

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
		// La Unitat Gestora debe existir y estar asociada al procedimiento
		if (unitatsGestoresRDTO == null) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_FOUND);
		}

		boolean unitatAssociadaProcediment = false;
		unitatAssociadaProcediment = unitatsGestoresRDTO.getId().compareTo(dadesProcedimentBDTO.getUgrRDTO().getId()) == INTEGER_ZERO;
		if (!unitatAssociadaProcediment && CollectionUtils.isNotEmpty(dadesProcedimentBDTO.getUgoRDTOList())) {
			for (UnitatsGestoresRDTO ugo : dadesProcedimentBDTO.getUgoRDTOList()) {
				if (unitatsGestoresRDTO.getId().compareTo(ugo.getId()) == INTEGER_ZERO) {
					unitatAssociadaProcediment = true;
					break;
				}
			}
		}
		if (!unitatAssociadaProcediment) {
			throw new GPAApiParamValidationException(Resultat.ERROR_CREAR_EXPEDIENT, ErrorPrincipal.ERROR_UNITATS_NOT_IN_PROCEDIMENT);
		}
	}
}