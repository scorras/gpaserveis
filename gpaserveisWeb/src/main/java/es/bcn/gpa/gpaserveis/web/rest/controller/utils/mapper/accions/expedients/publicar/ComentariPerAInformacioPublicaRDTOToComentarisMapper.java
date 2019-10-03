package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.publicar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.Comentaris;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.DataHoraToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.publicar.ComentariPerAInformacioPublicaRDTO;

/**
 * The Class ComentariPerAInformacioPublicaRDTOToComentarisMapper.
 */
@Component("comentariPerAInformacioPublicaRDTOToComentarisMapper")
public class ComentariPerAInformacioPublicaRDTOToComentarisMapper extends PropertyMap<ComentariPerAInformacioPublicaRDTO, Comentaris> {

	private DataHoraToInternalConverter dataHoraToInternalConverter;

	@Autowired
	public ComentariPerAInformacioPublicaRDTOToComentarisMapper(
			@Qualifier("dataHoraToInternalConverter") DataHoraToInternalConverter dataHoraToInternalConverter) {
		this.dataHoraToInternalConverter = dataHoraToInternalConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(dataHoraToInternalConverter).map(source.getDataCreacio()).setDataCreacio(null);
		map().setTitol(source.getTitol());
		map().setDescripcio(source.getDescripcio());
	}

}
