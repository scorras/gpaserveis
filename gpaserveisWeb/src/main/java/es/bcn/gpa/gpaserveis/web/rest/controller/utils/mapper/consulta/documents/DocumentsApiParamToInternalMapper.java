package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.documents;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class DocumentsApiParamToInternalMapper.
 */
@Component
public class DocumentsApiParamToInternalMapper {

	private static BaseApiParamValueTranslator tramitOvtApiParamValueTranslator;

	@Autowired
	public DocumentsApiParamToInternalMapper(
	        @Qualifier("procedimentTramitOvtApiParamValueTranslator") BaseApiParamValueTranslator tramitOvtApiParamValueTranslator) {
		DocumentsApiParamToInternalMapper.tramitOvtApiParamValueTranslator = tramitOvtApiParamValueTranslator;
	}

	public static BigDecimal getTramitOvtInternalValue(String tramitOvt) {
		return tramitOvtApiParamValueTranslator.getInternalValueByApiParamValue(tramitOvt);
	}

}
