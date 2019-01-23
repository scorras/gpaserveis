package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsIniciacions;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToIniciacioConverter.
 */
@Component("procedimentInternalToIniciacioConverter")
public class InternalToIniciacioConverter extends AbstractConverter<List<ProcedimentsIniciacions>, List<String>> {

	/** The iniciacio api param value translator. */
	@Autowired
	@Qualifier("procedimentIniciacioApiParamValueTranslator")
	private BaseApiParamValueTranslator iniciacioApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<String> convert(List<ProcedimentsIniciacions> source) {
		ArrayList<String> iniciacioList = new ArrayList<String>();
		if (CollectionUtils.isNotEmpty(source)) {
			for (ProcedimentsIniciacions procedimentsIniciacions : source) {
				iniciacioList.add(iniciacioApiParamValueTranslator.getApiParamValueByInternalValue(procedimentsIniciacions.getIniciacio()));
			}
		}
		return iniciacioList;
	}
}