package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentCompletatAccioRDTO;

/**
 * The Class InternalToDocumentEntradaCompletatAccioConverter.
 */
@Component("internalToDocumentEntradaCompletatAccioConverter")
public class InternalToDocumentEntradaCompletatAccioConverter extends AbstractConverter<DocsEntradaRDTO, DocumentCompletatAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DocumentCompletatAccioRDTO convert(DocsEntradaRDTO docsEntradaRDTO) {
		return ConverterHelper.buildDocumentCompletatAccioRDTOExpedient(docsEntradaRDTO);
	}
}