package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.DocumentAportatAccioRDTO;

/**
 * The Class InternalToDocumentAportatAccioListConverter.
 */
@Component("internalToDocumentAportatAccioListConverter")
public class InternalToDocumentAportatAccioListConverter extends AbstractConverter<List<DocsEntradaRDTO>, List<DocumentAportatAccioRDTO>> {

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
	protected List<DocumentAportatAccioRDTO> convert(List<DocsEntradaRDTO> docsEntradaRDTOList) {
		ArrayList<DocumentAportatAccioRDTO> documentAportatAccioRDTOList = null;
		if (CollectionUtils.isNotEmpty(docsEntradaRDTOList)) {
			documentAportatAccioRDTOList = ConverterHelper.buildDocumentsAportatsAccioRDTOListExpedient(docsEntradaRDTOList,
			        origenApiParamValueTranslator, revisioApiParamValueTranslator);
		}

		return documentAportatAccioRDTOList;
	}
}