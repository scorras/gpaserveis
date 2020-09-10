package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.persones;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.PersonaImplicadaToPersonaSollicitudConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.CrearTerceraPersonaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TerceraPersonaSollicitudRDTO;

/**
 * The Class crearTerceraPersonaRDTOToTerceraPersonaSollicitudRDTOMapper.
 */
@Component("crearTerceraPersonaRDTOToTerceraPersonaSollicitudRDTOMapper")
public class CrearTerceraPersonaRDTOToTerceraPersonaSollicitudRDTOMapper
		extends PropertyMap<CrearTerceraPersonaRDTO, TerceraPersonaSollicitudRDTO> {

	/** The list persona representant to list internal converter. */
	private PersonaImplicadaToPersonaSollicitudConverter personaImplicadaToPersonaSollicitudConverter;

	/**
	 * Instantiates a new solicituds crear RDTO to expedients RDTO mapper.
	 *
	 * @param personaSollicitantToInternalConverter
	 *            the persona sollicitant to internal converter
	 * @param personaRepresentantToInternalConverter
	 *            the persona representant to internal converter
	 */
	@Autowired
	public CrearTerceraPersonaRDTOToTerceraPersonaSollicitudRDTOMapper(
			@Qualifier("personaImplicadaToPersonaSollicitudConverter") PersonaImplicadaToPersonaSollicitudConverter personaImplicadaToPersonaSollicitudConverter) {
		this.personaImplicadaToPersonaSollicitudConverter = personaImplicadaToPersonaSollicitudConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(personaImplicadaToPersonaSollicitudConverter).map(source.getPersona()).setPersonesSollicitudRDTO(null);
	}

}
