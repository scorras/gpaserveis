package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.sollicituds.crear;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudCrearBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.InternalToSollicitudAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.crear.RespostaCrearSollicitudRDTO;

/**
 * The Class RespostaExpedientsCrearBDTOToRespostaCrearSolicitudsRDTOMapper.
 */
@Component("respostaSollicitudsCrearBDTOToRespostaCrearSolicitudsRDTOMapper")
public class RespostaSollicitudsCrearBDTOToRespostaCrearSolicitudsRDTOMapper
		extends PropertyMap<RespostaSollicitudCrearBDTO, RespostaCrearSollicitudRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToSollicitudAccioConverter internalToSollicitudAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaSollicitudsCrearBDTOToRespostaCrearSolicitudsRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("sollicitudInternalToSollicitudAccioConverter") InternalToSollicitudAccioConverter internalToSollicitudAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToSollicitudAccioConverter = internalToSollicitudAccioConverter;
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
		using(internalToSollicitudAccioConverter).map(source.getSollicitudRDTO()).setSollicitud(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
	}

}
