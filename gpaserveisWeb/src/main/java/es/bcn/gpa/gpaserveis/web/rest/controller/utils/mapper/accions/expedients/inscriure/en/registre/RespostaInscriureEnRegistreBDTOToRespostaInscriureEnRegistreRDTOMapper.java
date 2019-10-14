package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.inscriure.en.registre;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaInscriureEnRegistreBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.inscriure.en.registre.RespostaInscriureEnRegistreRDTO;

@Component("respostaInscriureEnRegistreBDTOToRespostaInscriureEnRegistreRDTOMapper")
public class RespostaInscriureEnRegistreBDTOToRespostaInscriureEnRegistreRDTOMapper
		extends PropertyMap<RespostaInscriureEnRegistreBDTO, RespostaInscriureEnRegistreRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

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
	public RespostaInscriureEnRegistreBDTOToRespostaInscriureEnRegistreRDTOMapper(
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
	}

}
