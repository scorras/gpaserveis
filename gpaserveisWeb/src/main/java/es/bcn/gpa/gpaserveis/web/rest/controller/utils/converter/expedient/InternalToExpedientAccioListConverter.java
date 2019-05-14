package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;

/**
 * The Class InternalToExpedientAccioListConverter.
 */
@Component("expedientInternalToExpedientAccioListConverter")
public class InternalToExpedientAccioListConverter extends AbstractConverter<List<DadesExpedientBDTO>, List<ExpedientAccioRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<ExpedientAccioRDTO> convert(List<DadesExpedientBDTO> source) {
		ArrayList<ExpedientAccioRDTO> expedientAccioRDTOList = null;
		if (CollectionUtils.isNotEmpty(source)) {
			expedientAccioRDTOList = new ArrayList<ExpedientAccioRDTO>();
			ExpedientAccioRDTO expedientAccioRDTO = null;

			for (DadesExpedientBDTO dadesExpedientBDTO : source) {
				expedientAccioRDTO = new ExpedientAccioRDTO();
				expedientAccioRDTO.setId(dadesExpedientBDTO.getExpedientsRDTO().getId());
				expedientAccioRDTO.setCodi(ConverterHelper.buildCodiExpedient(dadesExpedientBDTO.getExpedientsRDTO().getCodi(),
				        dadesExpedientBDTO.getExpedientsRDTO().getIdEstat()));
				expedientAccioRDTOList.add(expedientAccioRDTO);
			}
		}
		return expedientAccioRDTOList;
	}
}