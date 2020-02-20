package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.aportar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaAportarDocumentSollicitudBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatAccioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.sollicitud.InternalToSollicitudAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaAportarDocumentSollicitudRDTO;

/**
 * The Class
 * RespostaAportarDocumentSollicitudtBDTOToRespostaAportarDocumentSollicitudRDTOMapper.
 */
@Component("respostaAportarDocumentSollicitudtBDTOToRespostaAportarDocumentSollicitudRDTOMapper")
public class RespostaAportarDocumentSollicitudtBDTOToRespostaAportarDocumentSollicitudRDTOMapper
        extends PropertyMap<RespostaAportarDocumentSollicitudBDTO, RespostaAportarDocumentSollicitudRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentAportatAccioListConverter internalToDocumentAportatAccioListConverter;
	
	private InternalToSollicitudAccioConverter internalToSollicitudAccioConverter;

	@Autowired
	public RespostaAportarDocumentSollicitudtBDTOToRespostaAportarDocumentSollicitudRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("internalToDocumentAportatAccioListConverter") InternalToDocumentAportatAccioListConverter internalToDocumentAportatAccioListConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter,
	        @Qualifier("sollicitudInternalToSollicitudAccioConverter") InternalToSollicitudAccioConverter internalToSollicitudAccioConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToDocumentAportatAccioListConverter = internalToDocumentAportatAccioListConverter;
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
		using(internalToDocumentAportatAccioListConverter).map(source.getDocsEntradaRDTOList()).setDocumentacioAportada(null);
		using(internalToSollicitudAccioConverter).map(source.getSollicitudsRDTO()).setSollicitud(null);
		
	}

}
