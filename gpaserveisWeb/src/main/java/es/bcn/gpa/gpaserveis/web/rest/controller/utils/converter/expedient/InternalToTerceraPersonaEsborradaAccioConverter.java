package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TerceraPersonaEsborradaAccioRDTO;

/**
 * The Class InternalToTerceraPersonaEsborradaAccioConverter.
 */
@Component("internalToTerceraPersonaEsborradaAccioConverter")
public class InternalToTerceraPersonaEsborradaAccioConverter
        extends AbstractConverter<PersonesSollicitudRDTO, TerceraPersonaEsborradaAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected TerceraPersonaEsborradaAccioRDTO convert(PersonesSollicitudRDTO personesSollicitudRDTO) {
		TerceraPersonaEsborradaAccioRDTO terceraPersonaEsborradaAccioRDTO = null;

		if (personesSollicitudRDTO != null) {
			terceraPersonaEsborradaAccioRDTO = new TerceraPersonaEsborradaAccioRDTO();
			terceraPersonaEsborradaAccioRDTO.setId(personesSollicitudRDTO.getId());
		}

		return terceraPersonaEsborradaAccioRDTO;
	}
}