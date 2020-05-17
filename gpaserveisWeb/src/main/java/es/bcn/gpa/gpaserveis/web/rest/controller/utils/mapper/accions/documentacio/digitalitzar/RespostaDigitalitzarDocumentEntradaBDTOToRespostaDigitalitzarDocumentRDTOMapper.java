package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaDigitalitzarDocumentEntradaBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.document.InternalToDocumentEntradaDigitalitzarConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalRDTOToRegistreConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.digitalitzar.RespostaDigitalitzarDocumentRDTO;

@Component("respostaDigitalitzarDocumentEntradaBDTOToRespostaDigitalitzarDocumentRDTOMapper")
public class RespostaDigitalitzarDocumentEntradaBDTOToRespostaDigitalitzarDocumentRDTOMapper
        extends PropertyMap<RespostaDigitalitzarDocumentEntradaBDTO, RespostaDigitalitzarDocumentRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalRDTOToRegistreConverter internalRDTOToRegistreConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	private InternalToDocumentEntradaDigitalitzarConverter internalToDocumentEntradaDigitalitzarConverter;

	@Autowired
	public RespostaDigitalitzarDocumentEntradaBDTOToRespostaDigitalitzarDocumentRDTOMapper(
	        @Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
	        @Qualifier("expedientInternalRDTOToRegistreConverter") InternalRDTOToRegistreConverter internalRDTOToRegistreConverter,
	        @Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter,
	        @Qualifier("internalToDocumentEntradaDigitalitzarConverter") InternalToDocumentEntradaDigitalitzarConverter internalToDocumentEntradaDigitalitzarConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
		this.internalRDTOToRegistreConverter = internalRDTOToRegistreConverter;
		this.internalToResultatRespostaConverter = internalToResultatRespostaConverter;
		this.internalToDocumentEntradaDigitalitzarConverter = internalToDocumentEntradaDigitalitzarConverter;
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
		using(internalToDocumentEntradaDigitalitzarConverter).map(source.getDocsEntradaRDTO()).setDocument(null);
	}

}
