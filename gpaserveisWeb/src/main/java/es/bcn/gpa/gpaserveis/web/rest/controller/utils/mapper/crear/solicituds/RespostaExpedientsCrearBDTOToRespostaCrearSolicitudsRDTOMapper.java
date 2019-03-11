package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.crear.solicituds;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCrearBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToRespostaCrearExpedientConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.crear.RespostaCrearExpedientRDTO;

/**
 * The Class RespostaExpedientsCrearBDTOToRespostaCrearSolicitudsRDTOMapper.
 */
@Component("respostaExpedientsCrearBDTOToRespostaCrearSolicitudsRDTOMapper")
public class RespostaExpedientsCrearBDTOToRespostaCrearSolicitudsRDTOMapper
        extends PropertyMap<RespostaExpedientsCrearBDTO, RespostaCrearExpedientRDTO> {

	private InternalToRespostaCrearExpedientConverter internalToRespostaCrearExpedientConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaExpedientsCrearBDTOToRespostaCrearSolicitudsRDTOMapper(
	        @Qualifier("expedientInternalToRespostaCrearExpedientConverter") InternalToRespostaCrearExpedientConverter internalToRespostaCrearExpedientConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToRespostaCrearExpedientConverter = internalToRespostaCrearExpedientConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToRespostaCrearExpedientConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
	}

}
