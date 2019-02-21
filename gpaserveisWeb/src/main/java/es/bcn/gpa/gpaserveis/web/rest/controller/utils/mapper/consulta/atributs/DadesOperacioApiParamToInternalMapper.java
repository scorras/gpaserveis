package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.atributs;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class DadesOperacioApiParamToInternalMapper.
 */
@Component
public class DadesOperacioApiParamToInternalMapper {

	private static BaseApiParamValueTranslator tramitOvtApiParamValueTranslator;

	@Autowired
	public DadesOperacioApiParamToInternalMapper(
	        @Qualifier("procedimentTramitOvtApiParamValueTranslator") BaseApiParamValueTranslator tramitOvtApiParamValueTranslator) {
		DadesOperacioApiParamToInternalMapper.tramitOvtApiParamValueTranslator = tramitOvtApiParamValueTranslator;
	}

	public static BigDecimal getTramitOvtInternalValue(String tramitOvt) {
		return tramitOvtApiParamValueTranslator.getInternalValueByApiParamValue(tramitOvt);
	}

}
