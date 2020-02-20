package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.esborrar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentEntradaSollicitudBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentEntradaEsborratAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.InternalToSollicitudAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentSollicitudRDTO;

/**
 * The Class
 * RespostaEsborrarDocumentEntradaSollicitudBDTOToRespostaEsborrarDocumentSollicitudRDTOMapper.
 */
@Component("respostaEsborrarDocumentEntradaSollicitudBDTOToRespostaEsborrarDocumentSollicitudRDTOMapper")
public class RespostaEsborrarDocumentEntradaSollicitudBDTOToRespostaEsborrarDocumentSollicitudRDTOMapper
		extends PropertyMap<RespostaEsborrarDocumentEntradaSollicitudBDTO, RespostaEsborrarDocumentSollicitudRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to document entrada esborrat accio converter. */
	private InternalToDocumentEntradaEsborratAccioConverter internalToDocumentEntradaEsborratAccioConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;
	
	/** The internal to sollicitud accio converter. */
	private InternalToSollicitudAccioConverter internalToSollicitudAccioConverter;

	/**
	 * Instantiates a new resposta esborrar document entrada BDTO to resposta
	 * esborrar document RDTO mapper.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToDocumentEntradaEsborratAccioConverter
	 *            the internal to document entrada esborrat accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaEsborrarDocumentEntradaSollicitudBDTOToRespostaEsborrarDocumentSollicitudRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("internalToDocumentEntradaEsborratAccioConverter") InternalToDocumentEntradaEsborratAccioConverter internalToDocumentEntradaEsborratAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter,
			@Qualifier("sollicitudInternalToSollicitudAccioConverter") InternalToSollicitudAccioConverter internalToSollicitudAccioConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToDocumentEntradaEsborratAccioConverter = internalToDocumentEntradaEsborratAccioConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
		this.internalToSollicitudAccioConverter = internalToSollicitudAccioConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToDocumentEntradaEsborratAccioConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
		using(internalToSollicitudAccioConverter).map(source.getSollicitudsRDTO()).setSollicitud(null);
	}

}
