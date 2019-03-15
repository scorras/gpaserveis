package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.DocumentEsborratAccioRDTO;

/**
 * The Class InternalToDocumentEsborratAccioConverter.
 */
@Component("internalToDocumentEsborratAccioConverter")
public class InternalToDocumentEsborratAccioConverter extends AbstractConverter<DocsEntradaRDTO, DocumentEsborratAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DocumentEsborratAccioRDTO convert(DocsEntradaRDTO docsEntradaRDTO) {
		DocumentEsborratAccioRDTO documentEsborratAccioRDTO = new DocumentEsborratAccioRDTO();

		documentEsborratAccioRDTO.setId(docsEntradaRDTO.getId());
		documentEsborratAccioRDTO.setCodi(String.valueOf(docsEntradaRDTO.getConfigDocEntrada()));

		return documentEsborratAccioRDTO;
	}
}