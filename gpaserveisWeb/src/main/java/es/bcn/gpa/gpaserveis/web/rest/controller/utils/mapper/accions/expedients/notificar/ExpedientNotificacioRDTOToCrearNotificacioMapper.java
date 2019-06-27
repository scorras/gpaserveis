package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.notificar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.CrearNotificacio;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.PersonaNotificacioToInternalListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.notificar.ExpedientNotificacioRDTO;

/**
 * The Class ExpedientNotificacioRDTOToCrearNotificacioMapper.
 */
@Component("expedientNotificacioRDTOToCrearNotificacioMapper")
public class ExpedientNotificacioRDTOToCrearNotificacioMapper extends PropertyMap<ExpedientNotificacioRDTO, CrearNotificacio> {

	/** The persona sollicitant to internal converter. */
	private PersonaNotificacioToInternalListConverter personaNotificacioToInternalListConverter;

	@Autowired
	public ExpedientNotificacioRDTOToCrearNotificacioMapper(
	        @Qualifier("expedientPersonaNotificacioToInternalListConverter") PersonaNotificacioToInternalListConverter personaNotificacioToInternalListConverter) {
		this.personaNotificacioToInternalListConverter = personaNotificacioToInternalListConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(personaNotificacioToInternalListConverter).map(source.getDestinataris()).setPersones(null);
	}

}
