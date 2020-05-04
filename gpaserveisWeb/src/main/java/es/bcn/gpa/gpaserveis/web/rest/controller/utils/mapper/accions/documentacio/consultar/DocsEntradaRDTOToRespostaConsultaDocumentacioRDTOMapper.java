package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.consultar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatConsultaConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.RespostaConsultaDocumentacioRDTO;

@Component("docsEntradaRDTOToRespostaConsultaDocumentacioRDTOMapper")
public class DocsEntradaRDTOToRespostaConsultaDocumentacioRDTOMapper
		extends PropertyMap<DocsEntradaRDTO, RespostaConsultaDocumentacioRDTO> {

	/** The internal to document aportat consulta converter. */
	private InternalToDocumentAportatConsultaConverter internalToDocumentAportatConsultaConverter;

	@Autowired
	public DocsEntradaRDTOToRespostaConsultaDocumentacioRDTOMapper(
			@Qualifier("internalToDocumentAportatConsultaConverter") InternalToDocumentAportatConsultaConverter internalToDocumentAportatConsultaConverter) {
		this.internalToDocumentAportatConsultaConverter = internalToDocumentAportatConsultaConverter;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToDocumentAportatConsultaConverter).map(source).setDocument(null);
	}

}
