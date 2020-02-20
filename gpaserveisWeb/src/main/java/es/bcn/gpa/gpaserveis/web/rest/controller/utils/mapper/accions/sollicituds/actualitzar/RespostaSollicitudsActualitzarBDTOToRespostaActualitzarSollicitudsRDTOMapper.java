package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.sollicituds.actualitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaSollicitudsActualitzarBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.InternalToSollicitudAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.actualitzar.RespostaActualitzarSollicitudRDTO;

/**
 * The Class
 * RespostaExpedientsActualitzarBDTOToRespostaActualitzarSolicitudsRDTOMapper.
 */
@Component("respostaSollicitudsActualitzarBDTOToRespostaActualitzarSollicitudsRDTOMapper")
public class RespostaSollicitudsActualitzarBDTOToRespostaActualitzarSollicitudsRDTOMapper
		extends PropertyMap<RespostaSollicitudsActualitzarBDTO, RespostaActualitzarSollicitudRDTO> {

	private InternalToSollicitudAccioConverter internalToSollicitudAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaSollicitudsActualitzarBDTOToRespostaActualitzarSollicitudsRDTOMapper(
			@Qualifier("sollicitudInternalToSollicitudAccioConverter") InternalToSollicitudAccioConverter internalToSollicitudAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
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
		using(internalToSollicitudAccioConverter).map(source.getSollicitudsRDTO()).setSollicitud(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
	}

}
