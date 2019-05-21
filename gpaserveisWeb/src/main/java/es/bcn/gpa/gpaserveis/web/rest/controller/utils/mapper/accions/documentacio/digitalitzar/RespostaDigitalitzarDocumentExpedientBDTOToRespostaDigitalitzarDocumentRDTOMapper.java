package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalBasicToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.RespostaDigitalitzarDocumentRDTO;

/**
 * The Class
 * RespostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper.
 */
@Component("respostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper")
public class RespostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper
        extends PropertyMap<RespostaDigitalitzarDocumentExpedientBDTO, RespostaDigitalitzarDocumentRDTO> {

	private InternalBasicToExpedientAccioConverter internalBasicToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper(
	        @Qualifier("expedientInternalBasicToExpedientAccioConverter") InternalBasicToExpedientAccioConverter internalBasicToExpedientAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalBasicToExpedientAccioConverter = internalBasicToExpedientAccioConverter;
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
		using(internalBasicToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
	}

}
