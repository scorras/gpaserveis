package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.consultar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaConsultaExpedientsBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.RespostaConsultaExpedientsRDTO;

/**
 * The Class
 * RespostaConsultaExpedientsBDTOToRespostaConsultaExpedientsRDTOMapper.
 */
@Component("respostaConsultaExpedientsBDTOToRespostaConsultaExpedientsRDTOMapper")
public class RespostaConsultaExpedientsBDTOToRespostaConsultaExpedientsRDTOMapper
        extends PropertyMap<RespostaConsultaExpedientsBDTO, RespostaConsultaExpedientsRDTO> {

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaConsultaExpedientsBDTOToRespostaConsultaExpedientsRDTOMapper(
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
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
	}

}
