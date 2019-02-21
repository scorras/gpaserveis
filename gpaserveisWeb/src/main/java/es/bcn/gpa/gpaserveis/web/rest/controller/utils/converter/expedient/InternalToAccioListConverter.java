package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToAccioListConverter.
 */
@Component("expedientInternalToAccioListConverter")
public class InternalToAccioListConverter extends AbstractConverter<List<AccionsEstatsRDTO>, List<String>> {

	@Autowired
	@Qualifier("expedientAccioApiParamValueTranslator")
	private BaseApiParamValueTranslator accioApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<String> convert(List<AccionsEstatsRDTO> source) {
		ArrayList<String> accioList = new ArrayList<String>();
		if (CollectionUtils.isNotEmpty(source)) {
			for (AccionsEstatsRDTO accionsEstatsRDTO : source) {
				accioList.addAll(accioApiParamValueTranslator.getApiParamValueListByInternalValue(accionsEstatsRDTO.getAccio()));
			}
		}
		return accioList;
	}
}