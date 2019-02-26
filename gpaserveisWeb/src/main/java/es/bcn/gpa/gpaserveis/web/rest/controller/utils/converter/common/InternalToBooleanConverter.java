package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;

/**
 * The Class InternalToBooleanConverter.
 */
@Component("internalToBooleanConverter")
public class InternalToBooleanConverter extends AbstractConverter<Integer, Boolean> {

	/** The boolean api param value translator. */
	@Autowired
	@Qualifier("booleanApiParamValueTranslator")
	private BooleanApiParamValueTranslator booleanApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected Boolean convert(Integer source) {
		return booleanApiParamValueTranslator.getApiParamValueAsBooleanByInternalValue(source);
	}
}