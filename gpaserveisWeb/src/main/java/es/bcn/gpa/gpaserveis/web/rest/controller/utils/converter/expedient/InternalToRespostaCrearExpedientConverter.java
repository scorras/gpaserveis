package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds.RespostaCrearExpedientsRDTO;

/**
 * The Class InternalToRespostaCrearExpedientConverter.
 */
@Component("expedientInternalToRespostaCrearExpedientConverter")
public class InternalToRespostaCrearExpedientConverter extends AbstractConverter<ExpedientsRDTO, RespostaCrearExpedientsRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected RespostaCrearExpedientsRDTO convert(ExpedientsRDTO source) {
		RespostaCrearExpedientsRDTO respostaCrearExpedientsRDTO = null;
		if (source != null) {
			respostaCrearExpedientsRDTO = new RespostaCrearExpedientsRDTO();
			respostaCrearExpedientsRDTO.setId(source.getId());
			respostaCrearExpedientsRDTO.setCodi(source.getCodi());
		}
		return respostaCrearExpedientsRDTO;
	}
}