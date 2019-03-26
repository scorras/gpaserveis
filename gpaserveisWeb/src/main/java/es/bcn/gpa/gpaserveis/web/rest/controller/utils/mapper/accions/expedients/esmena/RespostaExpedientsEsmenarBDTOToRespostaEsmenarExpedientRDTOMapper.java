package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.esmena;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsEsmenarBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.RespostaEsmenarExpedientRDTO;

/**
 * The Class RespostaExpedientsEsmenarBDTOToRespostaEsmenarExpedientRDTOMapper.
 */
@Component("respostaExpedientsEsmenarBDTOToRespostaEsmenarExpedientRDTOMapper")
public class RespostaExpedientsEsmenarBDTOToRespostaEsmenarExpedientRDTOMapper
        extends PropertyMap<RespostaExpedientsEsmenarBDTO, RespostaEsmenarExpedientRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaExpedientsEsmenarBDTOToRespostaEsmenarExpedientRDTOMapper(
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
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
	}

}
