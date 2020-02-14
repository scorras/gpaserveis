package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.sollicituds.registrar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.sollicituds.RespostaSollicitudsRegistrarBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalRDTOToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.registrar.RespostaRegistrarSollicitudRDTO;

@Component("respostaSollicitudsRegistrarBDTOToRespostaRegistrarSollicitudRDTOMapper")
public class RespostaSollicitudsRegistrarBDTOToRespostaRegistrarSollicitudRDTOMapper
        extends PropertyMap<RespostaSollicitudsRegistrarBDTO, RespostaRegistrarSollicitudRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	// private InternalToSollicitudAccioConverter
	// internalToSollicitudAccioConverter;

	private InternalRDTOToRegistreConverter internalRDTOToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaSollicitudsRegistrarBDTOToRespostaRegistrarSollicitudRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalRDTOToRegistreConverter") InternalRDTOToRegistreConverter internalRDTOToRegistreConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalRDTOToRegistreConverter = internalRDTOToRegistreConverter;
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
		using(internalRDTOToRegistreConverter).map(source.getRespostaCrearRegistreExpedient().getRegistreAssentament()).setRegistre(null);
		map().setComprovant(source.getDocsTramitacioRDTO().getId());
	}

}
