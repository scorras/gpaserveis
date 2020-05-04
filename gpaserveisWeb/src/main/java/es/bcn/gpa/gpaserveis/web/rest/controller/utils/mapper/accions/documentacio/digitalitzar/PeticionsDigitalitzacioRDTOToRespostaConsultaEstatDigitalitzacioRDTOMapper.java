package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.PeticionsDigitalitzacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToStringListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToEstatDigitalitzacioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.estatDigitalitzacio.RespostaConsultaEstatDigitalitzacioRDTO;

/**
 * The Class
 * PeticionsDigitalitzacioRDTOToRespostaConsultaEstatDigitalitzacioRDTOMapper.
 */
@Component("peticionsDigitalitzacioRDTOToRespostaConsultaEstatDigitalitzacioRDTOMapper")
public class PeticionsDigitalitzacioRDTOToRespostaConsultaEstatDigitalitzacioRDTOMapper
        extends PropertyMap<PeticionsDigitalitzacioRDTO, RespostaConsultaEstatDigitalitzacioRDTO> {

	/** The internal to estat digitalitzacio converter. */
	private InternalToEstatDigitalitzacioConverter internalToEstatDigitalitzacioConverter;

	/** The internal to string list converter. */
	private InternalToStringListConverter internalToStringListConverter;

	/**
	 * Instantiates a new peticions digitalitzacio RDTO to resposta consulta
	 * estat digitalitzacio RDTO mapper.
	 *
	 * @param internalToEstatDigitalitzacioConverter
	 *            the internal to estat digitalitzacio converter
	 * @param internalToStringListConverter
	 *            the internal to string list converter
	 */
	@Autowired
	public PeticionsDigitalitzacioRDTOToRespostaConsultaEstatDigitalitzacioRDTOMapper(
	        @Qualifier("documentInternalToEstatDigitalitzacioConverter") InternalToEstatDigitalitzacioConverter internalToEstatDigitalitzacioConverter,
	        @Qualifier("internalToStringListConverter") InternalToStringListConverter internalToStringListConverter) {
		this.internalToEstatDigitalitzacioConverter = internalToEstatDigitalitzacioConverter;
		this.internalToStringListConverter = internalToStringListConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setIdPeticio(source.getCodiScan());
		using(internalToStringListConverter).map(source.getDocumentsCodi()).setCodiDocuments(null);
		using(internalToEstatDigitalitzacioConverter).map(source.getEstatPeticio()).setEstat(null);
	}

}
