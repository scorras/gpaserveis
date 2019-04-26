package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentAportatAccioRDTO;

/**
 * The Class InternalToDocumentAportatAccioConverter.
 */
@Component("internalToDocumentAportatAccioConverter")
public class InternalToDocumentAportatAccioConverter extends AbstractConverter<DocsEntradaRDTO, DocumentAportatAccioRDTO> {

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
	protected DocumentAportatAccioRDTO convert(DocsEntradaRDTO docsEntradaRDTO) {
		return ConverterHelper.buildDocumentsAportatsAccioRDTOExpedient(docsEntradaRDTO, origenApiParamValueTranslator,
		        revisioApiParamValueTranslator);
	}
}