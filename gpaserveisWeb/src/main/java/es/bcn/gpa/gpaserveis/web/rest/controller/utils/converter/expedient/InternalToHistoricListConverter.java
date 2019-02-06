package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToHistoricListConverter.
 */
@Component("expedientInternalToHistoricListConverter")
public class InternalToHistoricListConverter extends
        AbstractConverter<List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO>, List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO>> {

	@Autowired
	@Qualifier("expedientHistoricEstatApiParamValueTranslator")
	private BaseApiParamValueTranslator historicEstatApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO> convert(
	        List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO> source) {
		ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO> historicsRDTOList = new ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO>();

		if (CollectionUtils.isNotEmpty(source)) {
			for (es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO historicsRDTOApi : source) {
				historicsRDTOList.add(ConverterHelper.buildHistoricsRDTOExpedient(historicsRDTOApi, historicEstatApiParamValueTranslator));
			}
		}

		return historicsRDTOList;
	}

}