package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.UnitatsGestoresService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;

/**
 * The Class InternalToUnitatGestoraConverter.
 */
@Component("internalToUnitatGestoraConverter")
public class InternalToUnitatGestoraConverter extends AbstractConverter<BigDecimal, UnitatGestoraRDTO> {

	/** The unitats gestores service. */
	@Autowired
	private UnitatsGestoresService unitatsGestoresService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected UnitatGestoraRDTO convert(BigDecimal source) {
		UnitatsGestoresRDTO unitatsGestoresRDTO = null;
		try {
			// TODO Quizá este no sea el lugar más adecuado para realizar la
			// llamada al servicio de Unitats Gestores
			unitatsGestoresRDTO = unitatsGestoresService.consultarDadesUnitatGestora(source);
		} catch (GPAServeisServiceException e) {
			throw new GPAServeisRuntimeException(e);
		}
		UnitatGestoraRDTO unitatGestoraRDTO = new UnitatGestoraRDTO();
		unitatGestoraRDTO.setNom(unitatsGestoresRDTO.getNom());
		unitatGestoraRDTO.setDescripcio(unitatsGestoresRDTO.getDescripcio());

		return unitatGestoraRDTO;
	}
}