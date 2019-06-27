package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
@Component("expedientPersonaNotificacioToInternalListConverter")
public class PersonaNotificacioToInternalListConverter extends AbstractConverter<List<PersonesNotificacioRDTO>, List<Persones>> {

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
	protected List<Persones> convert(List<PersonesNotificacioRDTO> source) {
		ArrayList<Persones> personesList = null;
		if (CollectionUtils.isNotEmpty(source)) {
			personesList = new ArrayList<Persones>();
			for (PersonesNotificacioRDTO personesNotificacioRDTO : source) {
				personesList.add(ConverterHelper.buildPersonesNotificacioExpedient(personesNotificacioRDTO,
				        tipusPersonaApiParamValueTranslator, tipusDocumentIdentitatApiParamValueTranslator));
			}
		}
		return personesList;
	}
}