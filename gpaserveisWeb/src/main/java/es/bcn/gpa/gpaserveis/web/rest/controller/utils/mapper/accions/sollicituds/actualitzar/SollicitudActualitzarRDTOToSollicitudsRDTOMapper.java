package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.sollicituds.actualitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.PersonaSollicitudToInternalListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper.SollicitudActualitzarHelper;

/**
 * The Class ExpedientActualitzarRDTOToExpedientsRDTOMapper.
 */
@Component("sollicitudActualitzarRDTOToSollicitudsRDTOMapper")
public class SollicitudActualitzarRDTOToSollicitudsRDTOMapper extends PropertyMap<SollicitudActualitzarHelper, SollicitudsRDTO> {

	/** The persona sollicitant to internal converter. */
	private PersonaSollicitudToInternalListConverter personaSollicitudToInternalListConverter;

	/**
	 * Instantiates a new solicituds crear RDTO to expedients RDTO mapper.
	 *
	 * @param personaSollicitantToInternalConverter
	 *            the persona sollicitant to internal converter
	 * @param personaRepresentantToInternalConverter
	 *            the persona representant to internal converter
	 */
	@Autowired
	public SollicitudActualitzarRDTOToSollicitudsRDTOMapper(
			@Qualifier("sollicitudPersonaSollicitudToInternalListConverter") PersonaSollicitudToInternalListConverter personaSollicitudToInternalListConverter) {
		this.personaSollicitudToInternalListConverter = personaSollicitudToInternalListConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(personaSollicitudToInternalListConverter).map(source.getPersonesSollicitud()).setPersonesSollicitudList(null);
	}

}
