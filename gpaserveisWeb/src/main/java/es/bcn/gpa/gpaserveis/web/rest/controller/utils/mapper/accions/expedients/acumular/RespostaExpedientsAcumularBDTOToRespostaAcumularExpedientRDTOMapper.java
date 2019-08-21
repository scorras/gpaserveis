package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.acumular;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaExpedientsAcumularBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acumular.RespostaAcumularExpedientRDTO;

/**
 * The Class
 * RespostaExpedientsAcumularBDTOToRespostaAcumularExpedientRDTOMapper.
 */
@Component("respostaExpedientsAcumularBDTOToRespostaAcumularExpedientRDTOMapper")
public class RespostaExpedientsAcumularBDTOToRespostaAcumularExpedientRDTOMapper
        extends PropertyMap<RespostaExpedientsAcumularBDTO, RespostaAcumularExpedientRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to expedient accio list converter. */
	private InternalToExpedientAccioListConverter internalToExpedientAccioListConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta expedients abandonar BDTO to resposta
	 * abandonar expedient RDTO mapper.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaExpedientsAcumularBDTOToRespostaAcumularExpedientRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalToExpedientAccioListConverter") InternalToExpedientAccioListConverter internalToExpedientAccioListConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToExpedientAccioListConverter = internalToExpedientAccioListConverter;
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
		using(internalToExpedientAccioListConverter).map(source.getExpedientsAcumulatsRDTOList()).setAcumulats(null);
	}

}
