package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentDigitalitzatAccioListConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalRDTOToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.digitalitzar.RespostaDigitalitzarDocumentRDTO;

/**
 * The Class
 * RespostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper.
 */
@Component("respostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper")
public class RespostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper
		extends PropertyMap<RespostaDigitalitzarDocumentExpedientBDTO, RespostaDigitalitzarDocumentRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalRDTOToRegistreConverter internalRDTOToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentDigitalitzatAccioListConverter internalToDocumentDigitalitzatAccioListConverter;

	@Autowired
	public RespostaDigitalitzarDocumentExpedientBDTOToRespostaDigitalitzarDocumentRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("expedientInternalRDTOToRegistreConverter") InternalRDTOToRegistreConverter internalRDTOToRegistreConverter,
			@Qualifier("internalToDocumentDigitalitzatAccioListConverter") InternalToDocumentDigitalitzatAccioListConverter internalToDocumentDigitalitzatAccioListConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalRDTOToRegistreConverter = internalRDTOToRegistreConverter;
		this.internalToDocumentDigitalitzatAccioListConverter = internalToDocumentDigitalitzatAccioListConverter;
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
		using(internalToDocumentDigitalitzatAccioListConverter).map(source.getDocsEntradaRDTOList()).setDocumentacioDigitalitzat(null);
		map().setComprovant(source.getIdRespostaCrearJustificant());
	}

}
