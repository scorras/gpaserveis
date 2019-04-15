package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.ExpedientAccioRDTO;

/**
 * The Class InternalToExpedientAccioConverter.
 */
@Component("expedientInternalToExpedientAccioConverter")
public class InternalToExpedientAccioConverter extends AbstractConverter<ExpedientsRDTO, ExpedientAccioRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ExpedientAccioRDTO convert(ExpedientsRDTO source) {
		ExpedientAccioRDTO expedientAccioRDTO = null;
		if (source != null) {
			expedientAccioRDTO = new ExpedientAccioRDTO();

			expedientAccioRDTO.setId(source.getId());
			expedientAccioRDTO.setCodi(ConverterHelper.buildCodiExpedient(source.getCodi(), source.getIdEstat()));
		}
		return expedientAccioRDTO;
	}
}