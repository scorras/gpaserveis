package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.signar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.RespostaSignarDocumentBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar.RespostaSignarDocumentRDTO;

/**
 * The Class RespostaSignarDocumentBDTOToRespostaSignarDocumentRDTOMapper.
 */
@Component("respostaSignarDocumentBDTOToRespostaSignarDocumentRDTOMapper")
public class RespostaSignarDocumentBDTOToRespostaSignarDocumentRDTOMapper
		extends PropertyMap<RespostaSignarDocumentBDTO, RespostaSignarDocumentRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta signar document BDTO to resposta signar
	 * document RDTO mapper.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaSignarDocumentBDTOToRespostaSignarDocumentRDTOMapper(
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
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);

	}

}
