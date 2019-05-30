package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.DocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToBigDecimalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.OrigenToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.digitalitzar.DocumentDigitalitzarCrearRDTO;

/**
 * The Class DocumentDigitalitzarCrearRDTOToDocsEntradaRDTOMapper.
 */
@Component("documentDigitalitzarCrearRDTOToDocsEntradaRDTOMapper")
public class DocumentDigitalitzarCrearRDTOToDocsEntradaRDTOMapper extends PropertyMap<DocumentDigitalitzarCrearRDTO, DocsEntradaRDTO> {

	/** The internal to big decimal converter. */
	private InternalToBigDecimalConverter internalToBigDecimalConverter;

	/** The origen to internal converter. */
	private OrigenToInternalConverter origenToInternalConverter;

	/**
	 * Instantiates a new document digitalitzar crear RDTO to docs entrada RDTO
	 * mapper.
	 *
	 * @param internalToBigDecimalConverter
	 *            the internal to big decimal converter
	 * @param origenToInternalConverter
	 *            the origen to internal converter
	 */
	@Autowired
	public DocumentDigitalitzarCrearRDTOToDocsEntradaRDTOMapper(
			@Qualifier("internalToBigDecimalConverter") InternalToBigDecimalConverter internalToBigDecimalConverter,
			@Qualifier("origenToInternalConverter") OrigenToInternalConverter origenToInternalConverter) {
		this.internalToBigDecimalConverter = internalToBigDecimalConverter;
		this.origenToInternalConverter = origenToInternalConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToBigDecimalConverter).map(source.getConfiguracioDocumentacio()).setConfigDocEntrada(null);
		using(origenToInternalConverter).map(source.getOrigen()).setOrigen(null);
		map().setComentari(source.getComentari());
	}
}
