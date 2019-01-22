package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;

/**
 * The Class InternalToSollicitantConverter.
 */
@Component("expedientInternalToSollicitantConverter")
public class InternalToSollicitantConverter extends AbstractConverter<String, PersonesRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected PersonesRDTO convert(String source) {
		PersonesRDTO personesRDTO = new PersonesRDTO();
		personesRDTO.setNomRaoSocial(source);
		return personesRDTO;
	}
}