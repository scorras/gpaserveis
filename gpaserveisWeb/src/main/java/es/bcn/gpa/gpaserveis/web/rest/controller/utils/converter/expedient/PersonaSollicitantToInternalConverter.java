package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitud;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.RelacioPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusSexeApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusViaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;

/**
 * The Class PersonaSollicitantToInternalConverter.
 */
@Component("expedientPersonaSollicitantToInternalConverter")
public class PersonaSollicitantToInternalConverter extends AbstractConverter<PersonesRDTO, PersonesSollicitud> {

	@Autowired
	@Qualifier("expedientTipusPersonaApiParamValueTranslator")
	private TipusPersonaApiParamValueTranslator tipusPersonaApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusDocumentIdentitatApiParamValueTranslator")
	private TipusDocumentIdentitatApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusSexeApiParamValueTranslator")
	private TipusSexeApiParamValueTranslator tipusSexeApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusViaApiParamValueTranslator")
	private TipusViaApiParamValueTranslator tipusViaApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected PersonesSollicitud convert(PersonesRDTO source) {
		return ConverterHelper.buildPersonesSollicitudExpedient(source, RelacioPersonaApiParamValue.SOLLICITANT,
		        tipusPersonaApiParamValueTranslator, tipusDocumentIdentitatApiParamValueTranslator, tipusSexeApiParamValueTranslator,
		        tipusViaApiParamValueTranslator);
	}
}