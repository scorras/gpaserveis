package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.procediment;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToTramitOvtConverter;

/**
 * The Class InternalTramitsOvtRDTOToTramitsOvtRDTOMapper.
 */
@Component("procedimentInternalTramitsOvtRDTOToTramitsOvtRDTOMapper")
public class InternalTramitsOvtRDTOToTramitsOvtRDTOMapper extends
        PropertyMap<es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO, es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO> {

	/** The internal to tramit ovt converter. */
	private InternalToTramitOvtConverter internalToTramitOvtConverter;

	/**
	 * Instantiates a new internal tramits ovt RDTO to tramits ovt RDTO mapper.
	 *
	 * @param internalToTramitOvtConverter
	 *            the internal to tramit ovt converter
	 */
	@Autowired
	public InternalTramitsOvtRDTOToTramitsOvtRDTOMapper(
	        @Qualifier("procedimentInternalToTramitOvtConverter") InternalToTramitOvtConverter internalToTramitOvtConverter) {
		this.internalToTramitOvtConverter = internalToTramitOvtConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToTramitOvtConverter).map(source.getId()).setCodi(null);
		map().setNom(source.getDescripcio());
	}

}
