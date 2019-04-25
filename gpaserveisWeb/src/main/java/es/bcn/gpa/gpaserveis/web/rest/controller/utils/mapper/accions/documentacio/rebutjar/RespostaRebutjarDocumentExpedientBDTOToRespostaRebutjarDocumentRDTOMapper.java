package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.rebutjar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaRebutjarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.rebutjar.RespostaRebutjarDocumentRDTO;

/**
 * The Class
 * RespostaRebutjarDocumentExpedientBDTOToRespostaRebutjarDocumentRDTOMapper.
 */
@Component("respostaRebutjarDocumentExpedientBDTOToRespostaRebutjarDocumentRDTOMapper")
public class RespostaRebutjarDocumentExpedientBDTOToRespostaRebutjarDocumentRDTOMapper
        extends PropertyMap<RespostaRebutjarDocumentExpedientBDTO, RespostaRebutjarDocumentRDTO> {

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/** The internal to document aportat accio converter. */
	private InternalToDocumentAportatAccioConverter internalToDocumentAportatAccioConverter;

	/**
	 * Instantiates a new resposta rebutjar document expedient BDTO to resposta
	 * rebutjar document RDTO mapper.
	 *
	 * @param internalToDocumentAportatAccioConverter
	 *            the internal to document aportat accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaRebutjarDocumentExpedientBDTOToRespostaRebutjarDocumentRDTOMapper(
	        @Qualifier("internalToDocumentAportatAccioConverter") InternalToDocumentAportatAccioConverter internalToDocumentAportatAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToDocumentAportatAccioConverter = internalToDocumentAportatAccioConverter;
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
		using(internalToDocumentAportatAccioConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
	}

}
