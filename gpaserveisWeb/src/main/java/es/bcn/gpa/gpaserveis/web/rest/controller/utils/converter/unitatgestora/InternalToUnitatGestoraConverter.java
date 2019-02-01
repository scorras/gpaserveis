package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;

/**
 * The Class InternalToUnitatGestoraConverter.
 */
@Component("internalToUnitatGestoraConverter")
public class InternalToUnitatGestoraConverter extends AbstractConverter<UnitatsGestoresRDTO, UnitatGestoraRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected UnitatGestoraRDTO convert(UnitatsGestoresRDTO unitatsGestoresRDTO) {
		UnitatGestoraRDTO unitatGestoraRDTO = new UnitatGestoraRDTO();
		unitatGestoraRDTO.setId(unitatsGestoresRDTO.getId());
		unitatGestoraRDTO.setCodi(unitatsGestoresRDTO.getNom());
		unitatGestoraRDTO.setDescripcio(unitatsGestoresRDTO.getDescripcio());

		return unitatGestoraRDTO;
	}
}