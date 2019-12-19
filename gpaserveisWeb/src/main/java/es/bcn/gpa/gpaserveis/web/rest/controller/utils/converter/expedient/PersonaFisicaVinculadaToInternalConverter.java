package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.Persones;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar.PersonesNotificacioRDTO;

/**
 * The Class PersonaNotificacioToInternalListConverter.
 */
@Component("expedientPersonaFisicaVinculadaToInternalListConverter")
public class PersonaFisicaVinculadaToInternalConverter extends AbstractConverter<PersonesNotificacioRDTO, Persones> {

	@Autowired
	@Qualifier("expedientTipusPersonaApiParamValueTranslator")
	private TipusPersonaApiParamValueTranslator tipusPersonaApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientTipusDocumentIdentitatApiParamValueTranslator")
	private TipusDocumentIdentitatApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected Persones convert(PersonesNotificacioRDTO source) {
		Persones persona = null;
		if (source != null) {
			persona = ConverterHelper.buildPersonesNotificacioExpedient(source, tipusPersonaApiParamValueTranslator,
					tipusDocumentIdentitatApiParamValueTranslator);
		}
		return persona;
	}
}