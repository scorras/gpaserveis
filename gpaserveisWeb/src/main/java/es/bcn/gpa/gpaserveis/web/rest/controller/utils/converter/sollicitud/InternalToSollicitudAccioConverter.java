package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds.SollicitudAccioRDTO;

/**
 * The Class InternalToExpedientAccioConverter.
 */
@Component("sollicitudInternalToSollicitudAccioConverter")
public class InternalToSollicitudAccioConverter extends AbstractConverter<SollicitudsRDTO, SollicitudAccioRDTO> {

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
	protected SollicitudAccioRDTO convert(SollicitudsRDTO source) {
		SollicitudAccioRDTO sollicitudAccioRDTO = null;
		if (source != null) {
			sollicitudAccioRDTO = new SollicitudAccioRDTO();

			sollicitudAccioRDTO.setId(source.getId());
			sollicitudAccioRDTO.setTipus(tramitOvtApiParamValueTranslator.getApiParamValueByInternalValue(source.getTramitOvtIdext()));
		}
		return sollicitudAccioRDTO;
	}
}