package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.documents;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToDocumentsEntradaListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.CercaDocumentsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentsEntradaConsultaRDTO;

/**
 * The Class CercaDocumentsEntradaRDTOToDocumentsEntradaConsultaRDTO.
 */
@Component
public class CercaDocumentsEntradaRDTOToDocumentsEntradaConsultaRDTO
        extends PropertyMap<CercaDocumentsEntradaRDTO, DocumentsEntradaConsultaRDTO> {

	/** The internal to documents entrada list converter. */
	private InternalToDocumentsEntradaListConverter internalToDocumentsEntradaListConverter;

	/**
	 * Instantiates a new cerca documents entrada RDTO to documents entrada
	 * consulta RDTO.
	 *
	 * @param internalToDocumentsEntradaListConverter
	 *            the internal to documents entrada list converter
	 */
	@Autowired
	public CercaDocumentsEntradaRDTOToDocumentsEntradaConsultaRDTO(
	        @Qualifier("procedimentInternalToDocumentsEntradaListConverter") InternalToDocumentsEntradaListConverter internalToDocumentsEntradaListConverter) {
		this.internalToDocumentsEntradaListConverter = internalToDocumentsEntradaListConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToDocumentsEntradaListConverter).map(source.getConfiguracioDocsEntradaRDTOList()).setDocuments(null);
	}

}
