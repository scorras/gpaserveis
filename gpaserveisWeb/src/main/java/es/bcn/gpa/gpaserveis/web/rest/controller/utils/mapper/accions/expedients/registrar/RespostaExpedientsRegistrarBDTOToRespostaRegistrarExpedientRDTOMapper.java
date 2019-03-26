package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.registrar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.registrar.RespostaRegistrarExpedientRDTO;

/**
 * The Class
 * RespostaExpedientsRegistrarBDTOToRespostaRegistrarExpedientRDTOMapper.
 */
@Component("respostaExpedientsRegistrarBDTOToRespostaRegistrarExpedientRDTOMapper")
public class RespostaExpedientsRegistrarBDTOToRespostaRegistrarExpedientRDTOMapper
        extends PropertyMap<RespostaExpedientsRegistrarBDTO, RespostaRegistrarExpedientRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToRegistreConverter internalToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaExpedientsRegistrarBDTOToRespostaRegistrarExpedientRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalToRegistreConverter") InternalToRegistreConverter internalToRegistreConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToRegistreConverter = internalToRegistreConverter;
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
		using(internalToExpedientAccioConverter).map(source.getRespostaRegistrarSolicitudExpedient().getExpedient()).setExpedient(null);
		using(internalToRegistreConverter).map(source.getRespostaRegistrarSolicitudExpedient().getRegistreAssentament()).setRegistre(null);
		map().setComprovant(source.getRespostaRegistrarSolicitudExpedient().getComprovant());
	}

}
