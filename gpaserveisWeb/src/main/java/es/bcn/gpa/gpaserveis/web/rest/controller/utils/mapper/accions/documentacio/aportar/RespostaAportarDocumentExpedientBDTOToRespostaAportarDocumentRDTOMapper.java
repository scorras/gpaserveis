package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.aportar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaAportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatAccioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalBasicToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaAportarDocumentRDTO;

/**
 * The Class
 * RespostaAportarDocumentacioExpedientBDTOToRespostaAportarDocumentRDTOMapper.
 */
@Component("respostaAportarDocumentacioExpedientBDTOToRespostaAportarDocumentRDTOMapper")
public class RespostaAportarDocumentExpedientBDTOToRespostaAportarDocumentRDTOMapper
        extends PropertyMap<RespostaAportarDocumentExpedientBDTO, RespostaAportarDocumentRDTO> {

	private InternalBasicToExpedientAccioConverter internalBasicToExpedientAccioConverter;

	private InternalToRegistreConverter internalToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentAportatAccioListConverter internalToDocumentAportatAccioListConverter;

	@Autowired
	public RespostaAportarDocumentExpedientBDTOToRespostaAportarDocumentRDTOMapper(
	        @Qualifier("expedientInternalBasicToExpedientAccioConverter") InternalBasicToExpedientAccioConverter internalBasicToExpedientAccioConverter,
	        @Qualifier("documentInternalToRegistreConverter") InternalToRegistreConverter internalToRegistreConverter,
	        @Qualifier("internalToDocumentAportatAccioListConverter") InternalToDocumentAportatAccioListConverter internalToDocumentAportatAccioListConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalBasicToExpedientAccioConverter = internalBasicToExpedientAccioConverter;
		this.internalToRegistreConverter = internalToRegistreConverter;
		this.internalToDocumentAportatAccioListConverter = internalToDocumentAportatAccioListConverter;
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
		using(internalBasicToExpedientAccioConverter).map(source.getRespostaAportarDocumentacioExpedientRDTO().getExpedient())
		        .setExpedient(null);
		using(internalToRegistreConverter).map(source.getRespostaAportarDocumentacioExpedientRDTO().getRegistreAssentament())
		        .setRegistre(null);
		using(internalToDocumentAportatAccioListConverter).map(source.getRespostaAportarDocumentacioExpedientRDTO().getDocsEntrada())
		        .setDocumentacioAportada(null);
	}

}
