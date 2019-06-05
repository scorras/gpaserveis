package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentDigitalitzarAccioRDTO;

/**
 * The Class InternalToDocumentAportatAccioConverter.
 */
@Component("internalToDocumentEntradaDigitalitzarConverter")
public class InternalToDocumentEntradaDigitalitzarConverter extends AbstractConverter<DocsEntradaRDTO, DocumentDigitalitzarAccioRDTO> {

	/** The origen api param value translator. */
	@Autowired
	@Qualifier("documentOrigenApiParamValueTranslator")
	private BaseApiParamValueTranslator origenApiParamValueTranslator;

	/** The revisio api param value translator. */
	@Autowired
	@Qualifier("documentRevisioApiParamValueTranslator")
	private BaseApiParamValueTranslator revisioApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DocumentDigitalitzarAccioRDTO convert(DocsEntradaRDTO docsEntradaRDTO) {
		return ConverterHelper.buildDocumentDigitalitzarAccioRDTO(docsEntradaRDTO, origenApiParamValueTranslator,
				revisioApiParamValueTranslator);
	}
}