package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.aportar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaAportarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentAportatAccioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalRDTOToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaSollicitudAportarDocumentRDTO;

/**
 * The Class
 * RespostaSollicitudAportarDocumentacioExpedientBDTOToRespostaSollicitudAportarDocumentRDTOMapper.
 */
@Component("respostaSollicitudAportarDocumentacioExpedientBDTOToRespostaSollicitudAportarDocumentRDTOMapper")
public class RespostaSollicitudAportarDocumentExpedientBDTOToRespostaSollicitudAportarDocumentRDTOMapper
        extends PropertyMap<RespostaAportarDocumentExpedientBDTO, RespostaSollicitudAportarDocumentRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalRDTOToRegistreConverter internalRDTOToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentAportatAccioListConverter internalToDocumentAportatAccioListConverter;

	@Autowired
	public RespostaSollicitudAportarDocumentExpedientBDTOToRespostaSollicitudAportarDocumentRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalRDTOToRegistreConverter") InternalRDTOToRegistreConverter internalRDTOToRegistreConverter,
	        @Qualifier("internalToDocumentAportatAccioListConverter") InternalToDocumentAportatAccioListConverter internalToDocumentAportatAccioListConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalRDTOToRegistreConverter = internalRDTOToRegistreConverter;
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
		using(internalToExpedientAccioConverter).map(source.getExpedientsRDTO()).setExpedient(null);
		using(internalRDTOToRegistreConverter).map(source.getRegistreAssentamentRDTO()).setRegistre(null);
		using(internalToDocumentAportatAccioListConverter).map(source.getDocsEntradaRDTOList()).setDocumentacioAportada(null);
		map().setComprovant(source.getIdRespostaCrearJustificant());
	}

}
