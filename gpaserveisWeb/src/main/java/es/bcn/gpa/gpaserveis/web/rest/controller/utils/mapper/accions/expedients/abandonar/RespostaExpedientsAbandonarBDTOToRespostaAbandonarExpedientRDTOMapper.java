package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.abandonar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAbandonarBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.abandonar.RespostaAbandonarExpedientRDTO;

/**
 * The Class
 * RespostaExpedientsAbandonarBDTOToRespostaAbandonarExpedientRDTOMapper.
 */
@Component("respostaExpedientsAbandonarBDTOToRespostaAbandonarExpedientRDTOMapper")
public class RespostaExpedientsAbandonarBDTOToRespostaAbandonarExpedientRDTOMapper
        extends PropertyMap<RespostaExpedientsAbandonarBDTO, RespostaAbandonarExpedientRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaExpedientsAbandonarBDTOToRespostaAbandonarExpedientRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
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
		using(internalToExpedientAccioConverter).map(source.getRespostaAbandonarExpedient().getExpedient()).setExpedient(null);
	}

}
