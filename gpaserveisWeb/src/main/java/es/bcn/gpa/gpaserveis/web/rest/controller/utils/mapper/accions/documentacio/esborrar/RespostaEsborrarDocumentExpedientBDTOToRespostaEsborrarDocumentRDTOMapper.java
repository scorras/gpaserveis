package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.esborrar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentEsborratAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentRDTO;

/**
 * The Class
 * RespostaEsborrarDocumentExpedientBDTOToRespostaEsborrarDocumentRDTOMapper.
 */
@Component("respostaEsborrarDocumentExpedientBDTOToRespostaEsborrarDocumentRDTOMapper")
public class RespostaEsborrarDocumentExpedientBDTOToRespostaEsborrarDocumentRDTOMapper
        extends PropertyMap<RespostaEsborrarDocumentExpedientBDTO, RespostaEsborrarDocumentRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to document esborrat accio converter. */
	private InternalToDocumentEsborratAccioConverter internalToDocumentEsborratAccioConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta esborrar document expedient BDTO to resposta
	 * esborrar document RDTO.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToDocumentEsborratAccioConverter
	 *            the internal to document esborrat accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaEsborrarDocumentExpedientBDTOToRespostaEsborrarDocumentRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("internalToDocumentEsborratAccioConverter") InternalToDocumentEsborratAccioConverter internalToDocumentEsborratAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToDocumentEsborratAccioConverter = internalToDocumentEsborratAccioConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToDocumentEsborratAccioConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
	}

}
