package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.unitatsgestores.canviar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsCanviarUnitatGestoraBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioUnitatGestoraConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.unitatsgestores.canviar.RespostaCanviarUnitatGestoraExpedientRDTO;

/**
 * The Class
 * RespostaExpedientsCanviarUGBDTOToRespostaCanviarUGExpedientRDTOMapper.
 */
@Component("respostaExpedientsCanviarUGBDTOToRespostaCanviarUGExpedientRDTOMapper")
public class RespostaExpedientsCanviarUGBDTOToRespostaCanviarUGExpedientRDTOMapper
        extends PropertyMap<RespostaExpedientsCanviarUnitatGestoraBDTO, RespostaCanviarUnitatGestoraExpedientRDTO> {

	/** The internal to expedient accio unitat gestora converter. */
	private InternalToExpedientAccioUnitatGestoraConverter internalToExpedientAccioUnitatGestoraConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta expedients convidar tramitar BDTO to resposta
	 * convidar tramitar expedient RDTO mapper.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaExpedientsCanviarUGBDTOToRespostaCanviarUGExpedientRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioUnitatGestoraConverter") InternalToExpedientAccioUnitatGestoraConverter internalToExpedientAccioUnitatGestoraConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioUnitatGestoraConverter = internalToExpedientAccioUnitatGestoraConverter;
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
		using(internalToExpedientAccioUnitatGestoraConverter).map(source.getDadesExpedientBDTO()).setExpedient(null);

	}

}