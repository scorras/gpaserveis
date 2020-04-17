package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.sollicituds.crear;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.ListPersonesImplicadesToListInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.ListPersonesInteressadesToListInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.PersonaSollicitudToInternalListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper.SollicitudCrearHelper;

/**
 * The Class ExpedientCrearRDTOToExpedientsRDTOMapper.
 */
@Component("sollicitudCrearRDTOToExpedientsRDTOMapper")
public class SollicitudCrearHelperToSollicitudsRDTOMapper extends PropertyMap<SollicitudCrearHelper, SollicitudsRDTO> {

	/** The persona sollicitant to internal converter. */
	private PersonaSollicitudToInternalListConverter personaSollicitudToInternalListConverter;

	/** The list persona sollicitant to list internal converter. */
	private ListPersonesInteressadesToListInternalConverter listPersonesInteressadesToListInternalConverter;

	/** The list persona representant to list internal converter. */
	private ListPersonesImplicadesToListInternalConverter listPersonesImplicadesToListInternalConverter;

	/**
	 * Instantiates a new solicituds crear RDTO to expedients RDTO mapper.
	 *
	 * @param personaSollicitantToInternalConverter
	 *            the persona sollicitant to internal converter
	 * @param personaRepresentantToInternalConverter
	 *            the persona representant to internal converter
	 */
	@Autowired
	public SollicitudCrearHelperToSollicitudsRDTOMapper(
			@Qualifier("sollicitudPersonaSollicitudToInternalListConverter") PersonaSollicitudToInternalListConverter personaSollicitudToInternalListConverter,
			@Qualifier("expedientListPersonesInteressadesToListInternalConverter") ListPersonesInteressadesToListInternalConverter listPersonesInteressadesToListInternalConverter,
			@Qualifier("expedientListPersonesImplicadesToListInternalConverter") ListPersonesImplicadesToListInternalConverter listPersonesImplicadesToListInternalConverter) {
		this.personaSollicitudToInternalListConverter = personaSollicitudToInternalListConverter;
		this.listPersonesInteressadesToListInternalConverter = listPersonesInteressadesToListInternalConverter;
		this.listPersonesImplicadesToListInternalConverter = listPersonesImplicadesToListInternalConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		map().setTramitOvtIdext(source.getIdTramitsOvt());
		map().setExpedient(source.getIdExpedient());
		using(personaSollicitudToInternalListConverter).map(source.getPersonesSollicitud()).setPersonesSollicitudList(null);
		using(listPersonesInteressadesToListInternalConverter).map(source.getPersonesInteressades()).setPersonesInteressades(null);
		using(listPersonesImplicadesToListInternalConverter).map(source.getPersonesImplicades()).setPersonesImplicades(null);
	}

}
