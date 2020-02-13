package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToTramitOvtConverter.
 */
@Component("sollicitudTramitOvtToInternalConverter")
public class TramitOvtToInternalConverter extends AbstractConverter<String, BigDecimal> {

	/** The tramit ovt api param value translator. */
	@Autowired
	@Qualifier("procedimentTramitOvtApiParamValueTranslator")
	private BaseApiParamValueTranslator tramitOvtApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected BigDecimal convert(String source) {
		return tramitOvtApiParamValueTranslator.getInternalValueByApiParamValue(source);
	}
}