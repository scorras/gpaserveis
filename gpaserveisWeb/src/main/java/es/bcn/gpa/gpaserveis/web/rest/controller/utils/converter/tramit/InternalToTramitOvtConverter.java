package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.tramit;

import java.math.BigDecimal;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;

@Component("tramitInternalToTramitOvtConverter")
public class InternalToTramitOvtConverter extends AbstractConverter<BigDecimal, TramitsOvtRDTO> {

	@Autowired
	@Qualifier("procedimentTramitOvtApiParamValueTranslator")
	private BaseApiParamValueTranslator tramitOvtApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected TramitsOvtRDTO convert(BigDecimal source) {
		TramitsOvtRDTO tramitsOvtRDTO = new TramitsOvtRDTO();
		tramitsOvtRDTO.setCodi(tramitOvtApiParamValueTranslator.getApiParamValueByInternalValue(source));
		return tramitsOvtRDTO;
	}
}