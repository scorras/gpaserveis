package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.expedient.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;

/**
 * The Class InternalToProcedimentConverter.
 */
@Component("expedientInternalToProcedimentConverter")
public class InternalToProcedimentConverter extends AbstractConverter<String, ProcedimentsCercaRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ProcedimentsCercaRDTO convert(String source) {
		ProcedimentsCercaRDTO procedimentsCercaRDTO = new ProcedimentsCercaRDTO();
		procedimentsCercaRDTO.setNom(source);
		return procedimentsCercaRDTO;
	}
}