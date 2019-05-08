package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.completar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaCompletarDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentEntradaCompletatAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.RespostaIncorporarNouDocumentRDTO;

/**
 * The Class
 * RespostaCompletarDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper.
 */
@Component("respostaCompletarDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper")
public class RespostaCompletarDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper
        extends PropertyMap<RespostaCompletarDocumentEntradaExpedientBDTO, RespostaIncorporarNouDocumentRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToRegistreConverter internalToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentEntradaCompletatAccioConverter internalToDocumentEntradaCompletatAccioConverter;

	@Autowired
	public RespostaCompletarDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("documentInternalToRegistreConverter") InternalToRegistreConverter internalToRegistreConverter,
	        @Qualifier("internalToDocumentEntradaCompletatAccioConverter") InternalToDocumentEntradaCompletatAccioConverter internalToDocumentEntradaCompletatAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalToRegistreConverter = internalToRegistreConverter;
		this.internalToDocumentEntradaCompletatAccioConverter = internalToDocumentEntradaCompletatAccioConverter;
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
		using(internalToRegistreConverter).map(source.getDocsEntradaRDTO().getRegistreAssentament()).setRegistre(null);
		using(internalToDocumentEntradaCompletatAccioConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
	}

}
