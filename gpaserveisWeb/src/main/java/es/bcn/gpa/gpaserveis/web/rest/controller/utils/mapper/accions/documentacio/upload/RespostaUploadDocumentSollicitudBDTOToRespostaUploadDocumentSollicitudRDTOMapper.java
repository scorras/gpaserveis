package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.upload;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaUploadDocumentSollicitudBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.InternalToSollicitudAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.upload.RespostaUploadDocumentSollicitudRDTO;

/**
 * The Class
 * RespostaUploadDocumentSollicitudBDTOToRespostaUploadDocumentSollicitudRDTOMapper.
 */
@Component("respostaUploadDocumentSollicitudBDTOToRespostaUploadDocumentSollicitudRDTOMapper")
public class RespostaUploadDocumentSollicitudBDTOToRespostaUploadDocumentSollicitudRDTOMapper
        extends PropertyMap<RespostaUploadDocumentSollicitudBDTO, RespostaUploadDocumentSollicitudRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;
	
	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentAportatAccioConverter internalToDocumentAportatAccioConverter;
	
	private InternalToSollicitudAccioConverter internalToSollicitudAccioConverter;

	@Autowired
	public RespostaUploadDocumentSollicitudBDTOToRespostaUploadDocumentSollicitudRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("internalToDocumentAportatAccioConverter") InternalToDocumentAportatAccioConverter internalToDocumentAportatAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter,
	        @Qualifier("internalToSollicitudAccioConverter") InternalToSollicitudAccioConverter internalToSollicitudAccioConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToDocumentAportatAccioConverter = internalToDocumentAportatAccioConverter;
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
		using(internalToResultatRespostaConverter).map(source.getRespostaResultatBDTO()).setResultat(null);
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalToDocumentAportatAccioConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
		using(internalToSollicitudAccioConverter).map(source.getSollicitudsRDTO()).setSollicitud(null);
	}

}
