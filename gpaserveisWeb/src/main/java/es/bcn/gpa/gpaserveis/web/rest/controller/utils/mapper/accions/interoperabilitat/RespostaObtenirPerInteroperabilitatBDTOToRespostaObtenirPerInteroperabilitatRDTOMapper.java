package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.interoperabilitat;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaObtenirPerInteroperabilitatBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.interoperabilitat.RespostaObtenirPerInteroperabilitatRDTO;

/**
 * The Class
 * RespostaObtenirPerInteroperabilitatBDTOToRespostaObtenirPerInteroperabilitatRDTOMapper.
 */
@Component("respostaObtenirPerInteroperabilitatBDTOToRespostaObtenirPerInteroperabilitatRDTOMapper")
public class RespostaObtenirPerInteroperabilitatBDTOToRespostaObtenirPerInteroperabilitatRDTOMapper
		extends PropertyMap<RespostaObtenirPerInteroperabilitatBDTO, RespostaObtenirPerInteroperabilitatRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta obtenir per interoperabilitat BDTO to
	 * resposta obtenir per interoperabilitat RDTO mapper.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaObtenirPerInteroperabilitatBDTOToRespostaObtenirPerInteroperabilitatRDTOMapper(
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
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		map().setResposta(source.getResposta());
	}

}
