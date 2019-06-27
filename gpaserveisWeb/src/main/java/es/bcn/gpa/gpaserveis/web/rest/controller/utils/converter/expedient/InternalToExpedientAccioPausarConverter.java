package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.ExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar.ExpedientAccioPausarRDTO;

/**
 * The Class InternalToExpedientAccioPausarConverter.
 */
@Component("expedientInternalToExpedientAccioPausarConverter")
public class InternalToExpedientAccioPausarConverter extends AbstractConverter<ExpedientsRDTO, ExpedientAccioPausarRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ExpedientAccioPausarRDTO convert(ExpedientsRDTO source) {
		ExpedientAccioPausarRDTO expedientAccioPausarRDTO = null;
		if (source != null) {
			expedientAccioPausarRDTO = new ExpedientAccioPausarRDTO();

			expedientAccioPausarRDTO.setId(source.getId());
			expedientAccioPausarRDTO.setCodi(ConverterHelper.buildCodiExpedient(source.getCodi(), source.getIdEstat()));
			expedientAccioPausarRDTO.setEstat(source.getDescEstat());
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_TIME_PATTERN);
			expedientAccioPausarRDTO.setDataLimit(source.getDataAllegacio() != null ? dateTimeFormatter.print(source.getDataAllegacio())
			        : (source.getDataEsmena() != null ? dateTimeFormatter.print(source.getDataEsmena()) : null));
		}
		return expedientAccioPausarRDTO;
	}
}