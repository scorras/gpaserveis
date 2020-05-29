package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.NivellCriticitatApiParamValueTranslator;

/**
 * The Class InternalToNivellCriticitatConverter.
 */
@Component("internalToNivellCriticitatConverter")
public class InternalToNivellCriticitatConverter extends AbstractConverter<Integer, String> {

	@Autowired
	@Qualifier("nivellCriticitatApiParamValueTranslator")
	private NivellCriticitatApiParamValueTranslator nivellCriticitatApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(Integer source) {
		return nivellCriticitatApiParamValueTranslator.getApiParamValueByInternalValue(source);
	}
}