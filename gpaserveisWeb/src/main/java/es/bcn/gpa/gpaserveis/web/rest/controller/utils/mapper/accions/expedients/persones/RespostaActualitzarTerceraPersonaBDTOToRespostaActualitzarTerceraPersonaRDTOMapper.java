package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.persones;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaActualitzarTerceraPersonaBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToTerceraPersonaActualitzadaAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.RespostaActualitzarTerceraPersonaRDTO;

/**
 * The Class
 * respostaActualitzarTerceraPersonaBDTOToRespostaActualitzarTerceraPersonaRDTOMapper.
 */
@Component("respostaActualitzarTerceraPersonaBDTOToRespostaActualitzarTerceraPersonaRDTOMapper")
public class RespostaActualitzarTerceraPersonaBDTOToRespostaActualitzarTerceraPersonaRDTOMapper
		extends PropertyMap<RespostaActualitzarTerceraPersonaBDTO, RespostaActualitzarTerceraPersonaRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToTerceraPersonaActualitzadaAccioConverter internalToTerceraPersonaActualitzadaAccioConverter;

	@Autowired
	public RespostaActualitzarTerceraPersonaBDTOToRespostaActualitzarTerceraPersonaRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("internalToTerceraPersonaActualitzadaAccioConverter") InternalToTerceraPersonaActualitzadaAccioConverter internalToTerceraPersonaActualitzadaAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToTerceraPersonaActualitzadaAccioConverter = internalToTerceraPersonaActualitzadaAccioConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToTerceraPersonaActualitzadaAccioConverter).map(source.getPersonesSollicitudRDTO()).setPersona(null);
	}

}
