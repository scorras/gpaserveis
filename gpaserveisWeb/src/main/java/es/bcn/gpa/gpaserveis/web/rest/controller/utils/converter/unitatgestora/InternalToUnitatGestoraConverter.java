package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
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
		return ConverterHelper.buildUnitatGestoraRDTOUnitats(unitatsGestoresRDTO);
	}
}