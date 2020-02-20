package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.SollicitudsExpedientRDTO;

/**
 * The Class InternalToTramitOvtConverter.
 */
@Component("procedimentInternalToTramitOvtListConverter")
public class InternalToTramitOvtListConverter extends AbstractConverter<List<SollicitudsRDTO>, List<SollicitudsExpedientRDTO>> {

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
	protected List<SollicitudsExpedientRDTO> convert(List<SollicitudsRDTO> source) {
		ArrayList<SollicitudsExpedientRDTO> sollicitudsExpedientRDTOList = null;
		if (CollectionUtils.isNotEmpty(source)) {
			sollicitudsExpedientRDTOList = new ArrayList<SollicitudsExpedientRDTO>();

			for (SollicitudsRDTO sollicitudsRDTO : source) {
				sollicitudsExpedientRDTOList
						.add(ConverterHelper.buildSollicitudsRDTOExpedient(sollicitudsRDTO, tramitOvtApiParamValueTranslator));
			}
		}
		return sollicitudsExpedientRDTOList;
	}
}