package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.AccioCiutadaApiParamValueTranslator;

/**
 * The Class InternalToAccioCiutadaListConverter.
 */
@Component("expedientInternalToAccioCiutadaListConverter")
public class InternalToAccioCiutadaListConverter extends AbstractConverter<DadesExpedientBDTO, List<String>> {

	@Autowired
	@Qualifier("expedientAccioCiutadaApiParamValueTranslator")
	private AccioCiutadaApiParamValueTranslator accioCiutadaApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<String> convert(DadesExpedientBDTO source) {
		ArrayList<String> accioList = new ArrayList<String>();
		if (CollectionUtils.isNotEmpty(source.getAccionsDisponibles())) {
			String accioCiutadaApiParamValue = null;
			for (AccionsEstatsRDTO accionsEstatsRDTO : source.getAccionsDisponibles()) {
				accioCiutadaApiParamValue = accioCiutadaApiParamValueTranslator
				        .getApiParamValueByInternalValueAndInternalValueIdEstatOrigen(accionsEstatsRDTO.getAccio(),
				                source.getExpedientsRDTO().getIdEstat());
				if (accioCiutadaApiParamValue != null) {
					accioList.add(accioCiutadaApiParamValue);
				}
			}
		}
		return accioList;
	}
}