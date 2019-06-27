package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentDigitalitzarAccioRDTO;

/**
 * The Class InternalToDocumentAportatAccioConverter.
 */
@Component("internalToDocumentTramitacioDigitalitzarConverter")
public class InternalToDocumentTramitacioDigitalitzarConverter
		extends AbstractConverter<DocsTramitacioRDTO, DocumentDigitalitzarAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DocumentDigitalitzarAccioRDTO convert(DocsTramitacioRDTO docsTramitacioRDTO) {
		return ConverterHelper.buildDocumentDigitalitzarAccioRDTO(docsTramitacioRDTO);
	}
}