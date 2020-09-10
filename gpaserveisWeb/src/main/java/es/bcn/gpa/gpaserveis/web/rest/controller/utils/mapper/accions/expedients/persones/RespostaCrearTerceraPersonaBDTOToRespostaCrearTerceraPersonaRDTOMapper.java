package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.persones;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaCrearTerceraPersonaBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToTerceraPersonaCreadaAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.persones.RespostaCrearTerceraPersonaRDTO;

/**
 * The Class
 * respostaCrearTerceraPersonaBDTOToRespostaCrearTerceraPersonaRDTOMapper.
 */
@Component("respostaCrearTerceraPersonaBDTOToRespostaCrearTerceraPersonaRDTOMapper")
public class RespostaCrearTerceraPersonaBDTOToRespostaCrearTerceraPersonaRDTOMapper
		extends PropertyMap<RespostaCrearTerceraPersonaBDTO, RespostaCrearTerceraPersonaRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToTerceraPersonaCreadaAccioConverter internalToTercerPersonaCreadaAccioConverter;

	@Autowired
	public RespostaCrearTerceraPersonaBDTOToRespostaCrearTerceraPersonaRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("internalToTercerPersonaCreadaAccioConverter") InternalToTerceraPersonaCreadaAccioConverter internalToTercerPersonaCreadaAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToTercerPersonaCreadaAccioConverter = internalToTercerPersonaCreadaAccioConverter;
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
		using(internalToTercerPersonaCreadaAccioConverter).map(source.getPersonesSollicitudRDTO()).setPersona(null);
	}

}
