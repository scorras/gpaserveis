package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;

/**
 * The Class InternalToUgrConverter.
 */
@Component
public class InternalToUgrConverter extends AbstractConverter<String, UnitatGestoraRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected UnitatGestoraRDTO convert(String source) {
		UnitatGestoraRDTO unitatGestoraRDTO = new UnitatGestoraRDTO();
		unitatGestoraRDTO.setNom(source);
		return unitatGestoraRDTO;
	}
}