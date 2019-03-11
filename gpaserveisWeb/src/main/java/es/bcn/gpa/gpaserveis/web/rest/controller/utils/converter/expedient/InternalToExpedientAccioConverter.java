package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.crear.RespostaCrearExpedientRDTO;

/**
 * The Class InternalToRespostaCrearExpedientConverter.
 */
@Component("expedientInternalToRespostaCrearExpedientConverter")
public class InternalToRespostaCrearExpedientConverter extends AbstractConverter<ExpedientsRDTO, RespostaCrearExpedientRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected RespostaCrearExpedientRDTO convert(ExpedientsRDTO source) {
		RespostaCrearExpedientRDTO respostaCrearExpedientsRDTO = null;
		if (source != null) {
			respostaCrearExpedientsRDTO = new RespostaCrearExpedientRDTO();
			
			ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
			expedient.setId(source.getId());
			expedient.setCodi(source.getCodi());
			
			respostaCrearExpedientsRDTO.setExpedient(expedient);
		}
		return respostaCrearExpedientsRDTO;
	}
}