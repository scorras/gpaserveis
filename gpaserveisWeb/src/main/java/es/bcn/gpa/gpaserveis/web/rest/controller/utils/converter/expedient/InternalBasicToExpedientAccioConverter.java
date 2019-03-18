package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.ExpedientAccioRDTO;

/**
 * The Class InternalBasicToExpedientAccioConverter.
 */
@Component("expedientInternalBasicToExpedientAccioConverter")
public class InternalBasicToExpedientAccioConverter extends AbstractConverter<ExpedientRDTO, ExpedientAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ExpedientAccioRDTO convert(ExpedientRDTO source) {
		ExpedientAccioRDTO expedientAccioRDTO = null;
		if (source != null) {
			expedientAccioRDTO = new ExpedientAccioRDTO();

			expedientAccioRDTO.setId(source.getId());
			expedientAccioRDTO.setCodi(source.getCodi());
		}
		return expedientAccioRDTO;
	}
}