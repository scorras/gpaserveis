package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.DocumentsIdentitat;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Paisos;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Persones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RegistreAssentament;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusDocumentIdentitatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusPersonaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;

/**
 * The Class InternalToRegistreConverter.
 */
@Component("expedientInternalToRegistreConverter")
public class InternalToRegistreConverter extends AbstractConverter<RegistreAssentament, RegistreRDTO> {

	/** The tipus persona api param value translator. */
	@Autowired
	@Qualifier("expedientTipusPersonaApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusPersonaApiParamValueTranslator;

	/** The tipus document identitat api param value translator. */
	@Autowired
	@Qualifier("expedientTipusDocumentIdentitatApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusDocumentIdentitatApiParamValueTranslator;

	/** The tipus sexe api param value translator. */
	@Autowired
	@Qualifier("expedientTipusSexeApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusSexeApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected RegistreRDTO convert(RegistreAssentament source) {
		// Datos de prueba provisionales //
		source = new RegistreAssentament();
		source.setCodi("0801930008-1-2018-0002094-1");
		source.setDataRegistre(DateTime.now());
		Persones persones = new Persones();
		persones.setTipusPersona(TipusPersonaApiParamValue.FISICA.getInternalValue());
		persones.setNomRaoSocial("Nom");
		persones.setCognom1("Cognom 1");
		persones.setCognom2("Cognom 2");
		DocumentsIdentitat documentsIdentitat = new DocumentsIdentitat();
		documentsIdentitat.setTipus(TipusDocumentIdentitatApiParamValue.NIF.getInternalValue());
		documentsIdentitat.setNumeroDocument("00000000T");
		Paisos paisos = new Paisos();
		paisos.setCodiIne("108");
		documentsIdentitat.setPaisos(paisos);
		persones.setDocumentsIdentitat(documentsIdentitat);
		source.setPersones(persones);
		///////////////////////////////////

		RegistreRDTO registreRDTO = null;
		if (source != null) {
			registreRDTO = new RegistreRDTO();
			registreRDTO.setNumRegistre(source.getCodi());
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			registreRDTO.setDataRegistre((source.getDataRegistre() != null) ? dateTimeFormatter.print(source.getDataRegistre()) : null);
			registreRDTO.setPersona(ConverterHelper.buildPersonesRDTOExpedient(source.getPersones(), tipusPersonaApiParamValueTranslator,
			        tipusDocumentIdentitatApiParamValueTranslator, tipusSexeApiParamValueTranslator));
		}
		return registreRDTO;
	}
}