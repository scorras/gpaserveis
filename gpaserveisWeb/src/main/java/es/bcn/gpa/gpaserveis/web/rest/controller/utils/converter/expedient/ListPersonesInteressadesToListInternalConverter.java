package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitud;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.RelacioPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusDocumentIdentitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusPersonaApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusSexeApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;

/**
 * The Class ListPersonesInteressadesToListInternalConverter.
 */
@Component("expedientListPersonesInteressadesToListInternalConverter")
public class ListPersonesInteressadesToListInternalConverter extends AbstractConverter<List<PersonesRDTO>, List<PersonesSollicitud>> {

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
	@Qualifier("booleanApiParamValueTranslator")
	private BooleanApiParamValueTranslator booleanApiParamValueTranslator;

	@Autowired
	@Qualifier("expedientRelacioPersonaApiParamValueTranslator")
	private RelacioPersonaApiParamValueTranslator relacioPersonaApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<PersonesSollicitud> convert(List<PersonesRDTO> source) {
		ArrayList<PersonesSollicitud> personesSollicitudList = null;
		if (CollectionUtils.isNotEmpty(source)) {
			personesSollicitudList = new ArrayList<PersonesSollicitud>();
			PersonesSollicitud personesSollicitud = new PersonesSollicitud();
			for (PersonesRDTO personesRDTO : source) {
				personesSollicitud = ConverterHelper.buildPersonesSollicitudExpedient(personesRDTO,
						relacioPersonaApiParamValueTranslator.getEnumByApiParamValue(personesRDTO.getRelacio()),
						tipusPersonaApiParamValueTranslator, tipusDocumentIdentitatApiParamValueTranslator, booleanApiParamValueTranslator,
						tipusSexeApiParamValueTranslator, false);

				personesSollicitudList.add(personesSollicitud);
			}
		}
		return personesSollicitudList;
	}
}