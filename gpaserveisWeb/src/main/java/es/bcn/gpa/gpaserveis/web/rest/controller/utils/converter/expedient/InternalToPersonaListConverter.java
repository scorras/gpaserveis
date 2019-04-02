package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;

/**
 * The Class InternalToPersonaListConverter.
 */
@Component("expedientInternalToPersonaListConverter")
public class InternalToPersonaListConverter extends AbstractConverter<List<Persones>, List<PersonesRDTO>> {

	@Autowired
	@Qualifier("expedientTipusPersonaApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusDocumentIdentitatApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusSexeApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusSexeApiParamValueTranslator;

	/** The tipus via api param value translator. */
	@Autowired
	@Qualifier("expedientTipusViaApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusViaApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<PersonesRDTO> convert(List<Persones> source) {
		ArrayList<PersonesRDTO> personesRDTOList = null;
		if (CollectionUtils.isNotEmpty(source)) {
			personesRDTOList = new ArrayList<PersonesRDTO>();
			for (Persones persones : source) {
				personesRDTOList.add(ConverterHelper.buildPersonesRDTOExpedient(persones, tipusPersonaApiParamValueTranslator,
				        tipusDocumentIdentitatApiParamValueTranslator, tipusSexeApiParamValueTranslator, tipusViaApiParamValueTranslator));
			}
		}
		return personesRDTOList;
	}
}