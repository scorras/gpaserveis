package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;

/**
 * The Class InternalToPersonaListConverter.
 */
@Component("expedientInternalToPersonaListConverter")
public class InternalToPersonaListConverter extends AbstractConverter<List<PersonesSollicitudRDTO>, List<PersonesRDTO>> {

	@Autowired
	@Qualifier("expedientTipusPersonaApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusDocumentIdentitatApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusSexeApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusSexeApiParamValueTranslator;

	@Autowired
	@Qualifier("booleanApiParamValueTranslator")
	private BooleanApiParamValueTranslator booleanApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<PersonesRDTO> convert(List<PersonesSollicitudRDTO> source) {
		ArrayList<PersonesRDTO> personesRDTOList = null;
		if (CollectionUtils.isNotEmpty(source)) {
			personesRDTOList = new ArrayList<PersonesRDTO>();
			PersonesRDTO personesRDTO = null;
			for (PersonesSollicitudRDTO personesSollicitudRDTO : source) {
				personesRDTO = ConverterHelper.buildPersonesRDTOExpedient(personesSollicitudRDTO.getPersones(),
						tipusPersonaApiParamValueTranslator, tipusDocumentIdentitatApiParamValueTranslator,
						tipusSexeApiParamValueTranslator, booleanApiParamValueTranslator);

				personesRDTO.setVisibilitatOvt(booleanApiParamValueTranslator
						.getApiParamValueAsBooleanByInternalValue(personesSollicitudRDTO.getVisibilitatOvt()));
				personesRDTO.setRelacioTerceraPersona(personesSollicitudRDTO.getRelacioImplicada());
				personesRDTOList.add(personesRDTO);
			}
		}
		return personesRDTOList;
	}
}