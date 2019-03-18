package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.substituir;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaSubstituirDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalBasicToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.RespostaSubstituirDocumentRDTO;

/**
 * The Class
 * RespostaSubstituirDocumentExpedientBDTOToRespostaSubstituirDocumentRDTO.
 */
@Component("respostaSubstituirDocumentExpedientBDTOToRespostaSubstituirDocumentRDTO")
public class RespostaSubstituirDocumentExpedientBDTOToRespostaSubstituirDocumentRDTO
        extends PropertyMap<RespostaSubstituirDocumentExpedientBDTO, RespostaSubstituirDocumentRDTO> {

	private InternalBasicToExpedientAccioConverter internalBasicToExpedientAccioConverter;

	private InternalToRegistreConverter internalToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentAportatAccioConverter internalToDocumentAportatAccioConverter;

	@Autowired
	public RespostaSubstituirDocumentExpedientBDTOToRespostaSubstituirDocumentRDTO(
	        @Qualifier("expedientInternalBasicToExpedientAccioConverter") InternalBasicToExpedientAccioConverter internalBasicToExpedientAccioConverter,
	        @Qualifier("documentInternalToRegistreConverter") InternalToRegistreConverter internalToRegistreConverter,
	        @Qualifier("internalToDocumentAportatAccioConverter") InternalToDocumentAportatAccioConverter internalToDocumentAportatAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalBasicToExpedientAccioConverter = internalBasicToExpedientAccioConverter;
		this.internalToRegistreConverter = internalToRegistreConverter;
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
		using(internalBasicToExpedientAccioConverter).map(source.getRespostaSubstituirDocumentExpedientRDTO().getExpedient())
		        .setExpedient(null);
		using(internalToRegistreConverter).map(source.getRespostaSubstituirDocumentExpedientRDTO().getRegistreAssentament())
		        .setRegistre(null);
		using(internalToDocumentAportatAccioConverter).map(source.getRespostaSubstituirDocumentExpedientRDTO().getDocEntrada())
		        .setDocument(null);
	}

}
