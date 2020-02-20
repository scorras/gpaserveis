package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

@Component("sollicitudTipusIniciacioSollicitudToInternalConverter")
public class TipusIniciacioSollicitudToInternalConverter extends AbstractConverter<String, BigDecimal> {

	@Autowired
	@Qualifier("expedientTipusIniciacioSollicitudApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusIniciacioSollicitudApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected BigDecimal convert(String source) {
		return tipusIniciacioSollicitudApiParamValueTranslator.getInternalValueByApiParamValue(source);
	}
}