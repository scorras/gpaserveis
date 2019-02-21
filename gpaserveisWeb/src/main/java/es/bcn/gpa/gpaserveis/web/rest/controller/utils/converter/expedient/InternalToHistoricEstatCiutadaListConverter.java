package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.EstatsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;

/**
 * The Class InternalToHistoricEstatListConverter.
 */
@Component("expedientInternalToHistoricEstatCiutadaListConverter")
public class InternalToHistoricEstatCiutadaListConverter extends AbstractConverter<List<EstatsRDTO>, List<HistoricsRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<HistoricsRDTO> convert(List<EstatsRDTO> source) {
		ArrayList<HistoricsRDTO> historicsRDTOList = new ArrayList<HistoricsRDTO>();

		if (CollectionUtils.isNotEmpty(source)) {
			// Se excluye la transición más reciente por tratarse del estado
			// actual, que ya se incluye en otro atributo de la respuesta
			for (EstatsRDTO estatsRDTO : source.subList(1, source.size())) {
				historicsRDTOList.add(ConverterHelper.buildHistoricsRDTOExpedient(estatsRDTO));
			}

			// Deben eliminarse estados consecutivos que sean repetidos,
			// agrupándose en el más reciente
			String ultimEstat = null;
			Iterator<HistoricsRDTO> historicsRDTOIterator = historicsRDTOList.iterator();
			while (historicsRDTOIterator.hasNext()) {
				HistoricsRDTO historicsRDTO = (HistoricsRDTO) historicsRDTOIterator.next();
				if (StringUtils.equals(ultimEstat, historicsRDTO.getEstat())) {
					historicsRDTOIterator.remove();
				}
				ultimEstat = historicsRDTO.getEstat();
			}
		}

		return historicsRDTOList;
	}

}