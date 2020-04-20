package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.consultar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsTramitacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentGeneratConsultaConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.RespostaConsultaDocumentacioRDTO;

/**
 * The Class DocsTramitacioRDTOToRespostaConsultaDocumentacioRDTOMapper.
 */
@Component("documentGeneratConsultaRDTOToRespostaConsultaDocumentacioRDTOMapper")
public class DocsTramitacioRDTOToRespostaConsultaDocumentacioRDTOMapper
		extends PropertyMap<DocsTramitacioRDTO, RespostaConsultaDocumentacioRDTO> {

	/** The internal to document generat consulta converter. */
	private InternalToDocumentGeneratConsultaConverter internalToDocumentGeneratConsultaConverter;

	/**
	 * Instantiates a new docs tramitacio RDTO to resposta consulta documentacio
	 * RDTO mapper.
	 *
	 * @param internalToDocumentGeneratConsultaConverter
	 *            the internal to document generat consulta converter
	 */
	@Autowired
	public DocsTramitacioRDTOToRespostaConsultaDocumentacioRDTOMapper(
			@Qualifier("internalToDocumentGeneratConsultaConverter") InternalToDocumentGeneratConsultaConverter internalToDocumentGeneratConsultaConverter) {
		this.internalToDocumentGeneratConsultaConverter = internalToDocumentGeneratConsultaConverter;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToDocumentGeneratConsultaConverter).map(source).setDocument(null);
	}

}
