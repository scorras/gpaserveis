package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentTramitacioBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentTramitacioDigitalitzarConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalRDTOToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.RespostaDigitalitzarDocumentRDTO;

@Component("respostaDigitalitzarDocumentTramitacioBDTOToRespostaDigitalitzarDocumentRDTOMapper")
public class RespostaDigitalitzarDocumentTramitacioBDTOToRespostaDigitalitzarDocumentRDTOMapper
        extends PropertyMap<RespostaDigitalitzarDocumentTramitacioBDTO, RespostaDigitalitzarDocumentRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalRDTOToRegistreConverter internalRDTOToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentTramitacioDigitalitzarConverter internalToDocumentTramitacioDigitalitzarConverter;

	@Autowired
	public RespostaDigitalitzarDocumentTramitacioBDTOToRespostaDigitalitzarDocumentRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalRDTOToRegistreConverter") InternalRDTOToRegistreConverter internalRDTOToRegistreConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter,
	        @Qualifier("internalToDocumentTramitacioDigitalitzarConverter") InternalToDocumentTramitacioDigitalitzarConverter internalToDocumentTramitacioDigitalitzarConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalRDTOToRegistreConverter = internalRDTOToRegistreConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
		this.internalToDocumentTramitacioDigitalitzarConverter = internalToDocumentTramitacioDigitalitzarConverter;
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
		using(internalToDocumentTramitacioDigitalitzarConverter).map(source.getDocsTramitacioRDTO()).setDocument(null);
	}

}