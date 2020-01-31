package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.accions.documentacio.digitalitzar;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.documents.RespostaEstatDigitalitzacioBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.common.InternalToResultatRespostaConverter;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient.InternalToExpedientAccioConverter;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.estatDigitalitzacio.RespostaEstatDigitalitzacioRDTO;

/**
 * The Class
 * RespostaEstatDigitalitzacioBDTOToRespostaEstatDigitalitzacioRDTOMapper.
 */
@Component("respostaEstatDigitalitzacioBDTOToRespostaEstatDigitalitzacioRDTOMapper")
public class RespostaEstatDigitalitzacioBDTOToRespostaEstatDigitalitzacioRDTOMapper
		extends PropertyMap<RespostaEstatDigitalitzacioBDTO, RespostaEstatDigitalitzacioRDTO> {

	private InternalToExpedientAccioConverter internalToExpedientAccioConverter;

	private InternalToResultatRespostaConverter internalToResultatRespostaConverter;

	@Autowired
	public RespostaEstatDigitalitzacioBDTOToRespostaEstatDigitalitzacioRDTOMapper(
			@Qualifier("expedientInternalToExpedientAccioConverter") InternalToExpedientAccioConverter internalToExpedientAccioConverter,
			@Qualifier("internalToResultatRespostaConverter") InternalToResultatRespostaConverter internalToResultatRespostaConverter) {
		this.internalToExpedientAccioConverter = internalToExpedientAccioConverter;
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
		map().setEstatDigitalitzacio(source.getEstatDigitalitzacio());
		map().setMessage(source.getMessage());
	}

}
