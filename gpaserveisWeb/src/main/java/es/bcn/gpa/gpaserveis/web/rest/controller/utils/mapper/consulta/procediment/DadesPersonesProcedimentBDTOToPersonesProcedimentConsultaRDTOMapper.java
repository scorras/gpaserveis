package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.consulta.procediment;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesPersonesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment.InternalToProcedimentPersonesListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.PersonesProcedimentConsultaRDTO;

/**
 * The Class DadesProcedimentBDTOToPersonesProcedimentConsultaRDTOMapper.
 */
@Component
public class DadesPersonesProcedimentBDTOToPersonesProcedimentConsultaRDTOMapper
		extends PropertyMap<DadesPersonesProcedimentBDTO, PersonesProcedimentConsultaRDTO> {

	/** The list nivellVisibilitat to list internal converter. */
	private InternalToProcedimentPersonesListConverter internalToProcedimentPersonesListConverter;

	/**
	 * Instantiates a new resposta dades procediment BDTO to procediments
	 * consulta RDTO mapper.
	 *
	 * @param internalToTramitProcedimentListConverter
	 *            the internal to tramit procediment list converter
	 */
	@Autowired
	public DadesPersonesProcedimentBDTOToPersonesProcedimentConsultaRDTOMapper(
			@Qualifier("internalToProcedimentPersonesListConverter") InternalToProcedimentPersonesListConverter internalToProcedimentPersonesListConverter) {

		this.internalToProcedimentPersonesListConverter = internalToProcedimentPersonesListConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToProcedimentPersonesListConverter).map(source).setTerceresPersonesImplicades(null);
	}

}
