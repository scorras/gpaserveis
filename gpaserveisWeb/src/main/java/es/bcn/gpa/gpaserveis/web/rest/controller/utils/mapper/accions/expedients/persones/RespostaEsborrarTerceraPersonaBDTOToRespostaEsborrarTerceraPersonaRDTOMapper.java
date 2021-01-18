package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.expedients.persones;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaEsborrarTerceraPersonaBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToTerceraPersonaEsborradaAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.RespostaEsborrarTerceraPersonaRDTO;

@Component("respostaEsborrarTerceraPersonaBDTOToRespostaEsborrarTerceraPersonaRDTOMapper")
public class RespostaEsborrarTerceraPersonaBDTOToRespostaEsborrarTerceraPersonaRDTOMapper
		extends PropertyMap<RespostaEsborrarTerceraPersonaBDTO, RespostaEsborrarTerceraPersonaRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to tercera persona esborrada accio converter. */
	private InternalToTerceraPersonaEsborradaAccioConverter internalToTerceraPersonaEsborradaAccioConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta esborrar tercera persona BDTO to resposta
	 * esborrar tercera persona RDTO mapper.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToTerceraPersonaEsborradaAccioConverter
	 *            the internal to tercera persona esborrada accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaEsborrarTerceraPersonaBDTOToRespostaEsborrarTerceraPersonaRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("internalToTerceraPersonaEsborradaAccioConverter") InternalToTerceraPersonaEsborradaAccioConverter internalToTerceraPersonaEsborradaAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToTerceraPersonaEsborradaAccioConverter = internalToTerceraPersonaEsborradaAccioConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
	}

	/**
	 * Configure.
	 */
	@Override
	protected void configure() {
		using(internalToTerceraPersonaEsborradaAccioConverter).map(source.getPersonesSollicitudRDTO()).setPersona(null);
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
	}

}
