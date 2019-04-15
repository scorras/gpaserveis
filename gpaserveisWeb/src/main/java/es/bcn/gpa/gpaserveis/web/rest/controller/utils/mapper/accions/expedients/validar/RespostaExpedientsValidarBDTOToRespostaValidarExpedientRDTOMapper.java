package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.validar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsValidarBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.validar.RespostaValidarExpedientRDTO;

/**
 * The Class RespostaExpedientsValidarBDTOToRespostaValidarExpedientRDTOMapper.
 */
@Component("respostaExpedientsValidarBDTOToRespostaValidarExpedientRDTOMapper")
public class RespostaExpedientsValidarBDTOToRespostaValidarExpedientRDTOMapper
        extends PropertyMap<RespostaExpedientsValidarBDTO, RespostaValidarExpedientRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaExpedientsValidarBDTOToRespostaValidarExpedientRDTOMapper(
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
		using(internalToExpedientAccioConverter).map(source.getRespostaValidarExpedient().getExpedient()).setExpedient(null);
	}

}
