package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.documents;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToBooleanConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToStringConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToObligatoriConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToSuportConfeccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioAportadaConsultaRDTO;

@Component
public class ConfiguracioDocsEntradaRDTOToConfiguracioDocumentacioAportadaConsultaRDTOMapper
        extends PropertyMap<ConfiguracioDocsEntradaRDTO, ConfiguracioDocumentacioAportadaConsultaRDTO> {

	/** The internal to string converter. */
	private InternalToStringConverter internalToStringConverter;

	/** The internal to boolean converter. */
	private InternalToBooleanConverter internalToBooleanConverter;

	/** The internal to suport confeccio converter. */
	private InternalToSuportConfeccioConverter internalToSuportConfeccioConverter;

	/** The internal to obligatori converter. */
	private InternalToObligatoriConverter internalToObligatoriConverter;

	@Autowired
	public ConfiguracioDocsEntradaRDTOToConfiguracioDocumentacioAportadaConsultaRDTOMapper(
	        @Qualifier("internalToBooleanConverter") InternalToBooleanConverter internalToBooleanConverter,
	        @Qualifier("internalToSuportConfeccioConverter") InternalToSuportConfeccioConverter internalToSuportConfeccioConverter,
	        @Qualifier("internalToObligatoriConverter") InternalToObligatoriConverter internalToObligatoriConverter,
	        @Qualifier("internalToStringConverter") InternalToStringConverter internalToStringConverter) {
		this.internalToBooleanConverter = internalToBooleanConverter;
		this.internalToSuportConfeccioConverter = internalToSuportConfeccioConverter;
		this.internalToObligatoriConverter = internalToObligatoriConverter;
		this.internalToStringConverter = internalToStringConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToStringConverter).map(source.getId()).setCodi(null);
		map().setDescripcio(source.getNom());
		map().setDescripcioCastella(source.getNomCastella());
		map().setDescripcioAmpliada(source.getDescripcioAmpliada());
		using(internalToObligatoriConverter).map(source).setObligatori(null);
		using(internalToBooleanConverter).map(source.getAtributsDocs().getRepetible()).setRepetible(null);
		using(internalToSuportConfeccioConverter).map(source.getSuportConfeccio()).setSuportConfeccio(null);
		map().setSuportEnllac(source.getSuportEnllac());
	}

}
