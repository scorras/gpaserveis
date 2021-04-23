package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioUnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.unitatgestora.UnitatGestoraAccioRDTO;

/**
 * The Class InternalToExpedientAccioUnitatGestoraConverter.
 */
@Component("expedientInternalToExpedientAccioUnitatGestoraConverter")
public class InternalToExpedientAccioUnitatGestoraConverter extends AbstractConverter<DadesExpedientBDTO, ExpedientAccioUnitatGestoraRDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected ExpedientAccioUnitatGestoraRDTO convert(DadesExpedientBDTO source) {
		ExpedientAccioUnitatGestoraRDTO expedientAccioUnitatGestoraRDTO = null;
		UnitatGestoraAccioRDTO unitatGestoraAccioRDTO = null;
		if (source != null) {
			expedientAccioUnitatGestoraRDTO = new ExpedientAccioUnitatGestoraRDTO();

			expedientAccioUnitatGestoraRDTO.setId(source.getExpedientsRDTO().getId());
			expedientAccioUnitatGestoraRDTO.setCodi(
			        ConverterHelper.buildCodiExpedient(source.getExpedientsRDTO().getCodi(), source.getExpedientsRDTO().getIdEstat()));
			if (source.getUnitatsGestoresRDTO() != null) {
				unitatGestoraAccioRDTO = new UnitatGestoraAccioRDTO();
				unitatGestoraAccioRDTO.setCodi(source.getUnitatsGestoresRDTO().getNom());
			}
			expedientAccioUnitatGestoraRDTO.setUnitatGestora(unitatGestoraAccioRDTO);
		}
		return expedientAccioUnitatGestoraRDTO;
	}
}