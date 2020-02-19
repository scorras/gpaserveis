package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.sollicituds.crear;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.SollicitudsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.PersonaSollicitudToInternalListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.TipusIniciacioSollicitudToInternalConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusIniciacioSollicitudApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.helper.SollicitudCrearHelper;

/**
 * The Class ExpedientCrearRDTOToExpedientsRDTOMapper.
 */
@Component("sollicitudCrearRDTOToExpedientsRDTOMapper")
public class SollicitudCrearHelperToSollicitudsRDTOMapper extends PropertyMap<SollicitudCrearHelper, SollicitudsRDTO> {

	/** The persona sollicitant to internal converter. */
	private PersonaSollicitudToInternalListConverter personaSollicitudToInternalListConverter;

	/** The tipus iniciacio sollicitud to internal converter. */
	private TipusIniciacioSollicitudToInternalConverter tipusIniciacioSollicitudToInternalConverter;

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
	        @Qualifier("sollicitudTipusIniciacioSollicitudToInternalConverter") TipusIniciacioSollicitudToInternalConverter tipusIniciacioSollicitudToInternalConverter) {
		this.personaSollicitudToInternalListConverter = personaSollicitudToInternalListConverter;
		this.tipusIniciacioSollicitudToInternalConverter = tipusIniciacioSollicitudToInternalConverter;
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
		using(tipusIniciacioSollicitudToInternalConverter).map(TipusIniciacioSollicitudApiParamValue.SOLLICITUD.getApiParamValue())
		        .setIniciacio(null);
		using(personaSollicitudToInternalListConverter).map(source.getPersonesSollicitud()).setPersonesSollicitudList(null);
	}

}
