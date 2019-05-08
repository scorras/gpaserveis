package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.incorporar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaIncorporarNouDocumentEntradaExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentEntradaIncorporatNouAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalRDTOToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar.RespostaIncorporarNouDocumentRDTO;

/**
 * The Class
 * RespostaIncorporarNouDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper.
 */
@Component("respostaIncorporarNouDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper")
public class RespostaIncorporarNouDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper
        extends PropertyMap<RespostaIncorporarNouDocumentEntradaExpedientBDTO, RespostaIncorporarNouDocumentRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalRDTOToRegistreConverter internalRDTOToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentEntradaIncorporatNouAccioConverter internalToDocumentEntradaIncorporatNouAccioConverter;

	@Autowired
	public RespostaIncorporarNouDocumentEntradaExpedientBDTOToRespostaIncorporarNouDocumentRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalRDTOToRegistreConverter") InternalRDTOToRegistreConverter internalRDTOToRegistreConverter,
	        @Qualifier("internalToDocumentEntradaIncorporatNouAccioConverter") InternalToDocumentEntradaIncorporatNouAccioConverter internalToDocumentEntradaIncorporatNouAccioConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalRDTOToRegistreConverter = internalRDTOToRegistreConverter;
		this.internalToDocumentEntradaIncorporatNouAccioConverter = internalToDocumentEntradaIncorporatNouAccioConverter;
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
		using(internalToDocumentEntradaIncorporatNouAccioConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
	}

}
