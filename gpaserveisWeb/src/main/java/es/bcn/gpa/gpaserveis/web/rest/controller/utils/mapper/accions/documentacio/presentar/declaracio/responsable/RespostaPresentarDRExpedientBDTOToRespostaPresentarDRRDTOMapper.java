package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.presentar.declaracio.responsable;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaPresentarDeclaracioResponsableExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDeclaracioResponsablePresentadaAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.presentar.declaracio.responsable.RespostaPresentarDeclaracioResponsableRDTO;

/**
 * The Class RespostaPresentarDRExpedientBDTOToRespostaPresentarDRRDTOMapper.
 */
@Component("respostaPresentarDRExpedientBDTOToRespostaPresentarDRRDTOMapper")
public class RespostaPresentarDRExpedientBDTOToRespostaPresentarDRRDTOMapper
        extends PropertyMap<RespostaPresentarDeclaracioResponsableExpedientBDTO, RespostaPresentarDeclaracioResponsableRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDeclaracioResponsablePresentadaAccioConverter internalToDeclaracioResponsablePresentadaAccioConverter;

	@Autowired
	public RespostaPresentarDRExpedientBDTOToRespostaPresentarDRRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("internalToDeclaracioResponsablePresentadaAccioConverter") InternalToDeclaracioResponsablePresentadaAccioConverter internalToDeclaracioResponsablePresentadaAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToDeclaracioResponsablePresentadaAccioConverter = internalToDeclaracioResponsablePresentadaAccioConverter;
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
		using(internalToDeclaracioResponsablePresentadaAccioConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
	}

}
