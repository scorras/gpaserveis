package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.DocumentEsborratAccioRDTO;

/**
 * The Class InternalToDocumentTramitacioEsborratAccioConverter.
 */
@Component("internalToDocumentTramitacioEsborratAccioConverter")
public class InternalToDocumentTramitacioEsborratAccioConverter extends AbstractConverter<DocsTramitacioRDTO, DocumentEsborratAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected DocumentEsborratAccioRDTO convert(DocsTramitacioRDTO docsTramitacioRDTO) {
		DocumentEsborratAccioRDTO documentEsborratAccioRDTO = null;

		if (docsTramitacioRDTO != null) {
			documentEsborratAccioRDTO = new DocumentEsborratAccioRDTO();

			documentEsborratAccioRDTO.setId(docsTramitacioRDTO.getId());
			if (docsTramitacioRDTO.getDocsFisics() != null) {
				documentEsborratAccioRDTO.setNom(docsTramitacioRDTO.getDocsFisics().getNom());
			}
		}

		return documentEsborratAccioRDTO;
	}
}