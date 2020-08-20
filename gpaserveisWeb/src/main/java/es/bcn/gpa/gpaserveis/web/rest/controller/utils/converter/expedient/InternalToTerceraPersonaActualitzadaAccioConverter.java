package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PersonesSollicitudRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TercerPersonaActualitzadaAccioRDTO;

/**
 * The Class internalToTerceraPersonaActualitzadaAccioConverter.
 */
@Component("internalToTerceraPersonaActualitzadaAccioConverter")
public class InternalToTerceraPersonaActualitzadaAccioConverter
		extends AbstractConverter<PersonesSollicitudRDTO, TercerPersonaActualitzadaAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected TercerPersonaActualitzadaAccioRDTO convert(PersonesSollicitudRDTO personesSollicitudRDTO) {
		return ConverterHelper.buildTercerPersonaActualitzadaAccioRDTO(personesSollicitudRDTO);
	}
}