package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;

/**
 * The Class InternalToCodiConverter.
 */
@Component("expedientInternalToCodiConverter")
public class InternalToCodiConverter extends AbstractConverter<ExpedientsRDTO, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(ExpedientsRDTO source) {
		return ConverterHelper.buildCodiExpedient(source.getCodi(), source.getIdEstat());
	}
}