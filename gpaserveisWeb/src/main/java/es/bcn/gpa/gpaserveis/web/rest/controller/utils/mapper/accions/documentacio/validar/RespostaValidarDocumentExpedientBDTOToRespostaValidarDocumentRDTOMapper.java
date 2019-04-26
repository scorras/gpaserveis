package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.validar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaValidarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar.RespostaValidarDocumentRDTO;

/**
 * The Class
 * RespostaValidarDocumentExpedientBDTOToRespostaValidarDocumentRDTOMapper.
 */
@Component("respostaValidarDocumentExpedientBDTOToRespostaValidarDocumentRDTOMapper")
public class RespostaValidarDocumentExpedientBDTOToRespostaValidarDocumentRDTOMapper
        extends PropertyMap<RespostaValidarDocumentExpedientBDTO, RespostaValidarDocumentRDTO> {

	/** The internal to resultat resposta converter. */
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	/** The internal to document aportat accio converter. */
	private InternalToDocumentAportatAccioConverter internalToDocumentAportatAccioConverter;

	/**
	 * Instantiates a new resposta validar document expedient BDTO to resposta
	 * validar document RDTO mapper.
	 *
	 * @param internalToDocumentAportatAccioConverter
	 *            the internal to document aportat accio converter
	 * @param internalToResultatRespostaConverter
	 *            the internal to resultat resposta converter
	 */
	@Autowired
	public RespostaValidarDocumentExpedientBDTOToRespostaValidarDocumentRDTOMapper(
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
