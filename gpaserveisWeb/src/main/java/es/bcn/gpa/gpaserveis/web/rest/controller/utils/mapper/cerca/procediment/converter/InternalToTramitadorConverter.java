package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.converter;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.TramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToEstatConverter.
 */
@Component
public class InternalToTramitadorConverter extends AbstractConverter<String, String> {

	/** The tramitador api param value translator. */
	@Autowired
	private BaseApiParamValueTranslator tramitadorApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected String convert(String source) {
		Integer internalValue = StringUtils.isEmpty(source) ? TramitadorApiParamValue.OGE.getInternalValue()
		        : TramitadorApiParamValue.APLICACIO_DE_NEGOCI.getInternalValue();

		return tramitadorApiParamValueTranslator.getApiParamValueByInternalValue(internalValue);
	}
}