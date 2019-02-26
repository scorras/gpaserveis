package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
			// No se excluye la transición más reciente. Deben aparecer todas en
			// el histórico
			for (EstatsRDTO estatsRDTO : source) {
				historicsRDTOList.add(ConverterHelper.buildHistoricsRDTOExpedient(estatsRDTO));
			}

			// Deben eliminarse estados consecutivos que sean repetidos,
			// agrupándose en el más antiguo
			String primerEstat = null;
			ListIterator<HistoricsRDTO> historicsRDTOIterator = historicsRDTOList.listIterator(historicsRDTOList.size());
			while (historicsRDTOIterator.hasPrevious()) {
				HistoricsRDTO historicsRDTO = (HistoricsRDTO) historicsRDTOIterator.previous();
				if (StringUtils.equals(primerEstat, historicsRDTO.getEstat())) {
					historicsRDTOIterator.remove();
				}
				primerEstat = historicsRDTO.getEstat();
			}
		}

		return historicsRDTOList;
	}

}