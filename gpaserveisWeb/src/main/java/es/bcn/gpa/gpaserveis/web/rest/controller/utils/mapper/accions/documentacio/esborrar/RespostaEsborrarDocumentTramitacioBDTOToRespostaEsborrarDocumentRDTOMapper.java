package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.esborrar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEsborrarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentTramitacioEsborratAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentRDTO;

/**
 * The Class
 * RespostaEsborrarDocumentTramitacioBDTOToRespostaEsborrarDocumentRDTOMapper.
 */
@Component("respostaEsborrarDocumentTramitacioBDTOToRespostaEsborrarDocumentRDTOMapper")
public class RespostaEsborrarDocumentTramitacioBDTOToRespostaEsborrarDocumentRDTOMapper
		extends PropertyMap<RespostaEsborrarDocumentTramitacioBDTO, RespostaEsborrarDocumentRDTO> {

	/** The internal to expedient accio converter. */
	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	/** The internal to document tramitacio esborrat accio converter. */
	private InternalToDocumentTramitacioEsborratAccioConverter internalToDocumentTramitacioEsborratAccioConverter;

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/**
	 * Instantiates a new resposta esborrar document tramitacio BDTO to resposta
	 * esborrar document RDTO mapper.
	 *
	 * @param internalToExpedientAccioConverter
	 *            the internal to expedient accio converter
	 * @param internalToDocumentTramitacioEsborratAccioConverter
	 *            the internal to document tramitacio esborrat accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaEsborrarDocumentTramitacioBDTOToRespostaEsborrarDocumentRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("internalToDocumentTramitacioEsborratAccioConverter") InternalToDocumentTramitacioEsborratAccioConverter internalToDocumentTramitacioEsborratAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToDocumentTramitacioEsborratAccioConverter = internalToDocumentTramitacioEsborratAccioConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.PropertyMap#configure()
	 */
	@Override
	protected void configure() {
		using(internalToDocumentTramitacioEsborratAccioConverter).map(source.getDocsTramitacioRDTO()).setDocument(null);
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
	}

}
