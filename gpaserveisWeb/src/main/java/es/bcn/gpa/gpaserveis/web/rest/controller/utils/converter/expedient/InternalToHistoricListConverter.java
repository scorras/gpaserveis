package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

/**
 * The Class InternalToHistoricListConverter.
 */
@Component("internalToHistoricListConverter")
public class InternalToHistoricListConverter extends
        AbstractConverter<List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO>, List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO> convert(
	        List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.HistoricsRDTO> historicsRDTOApiList) {
		ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO> historicsRDTOList = new ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO>();
		// es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO
		// tramitsRDTO = null;
		//
		// for
		// (es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO
		// tramitsRDTOApi : tramitsRDTOApiList) {
		// tramitsRDTO = new TramitsRDTO();
		// tramitsRDTO.setId(tramitsRDTOApi.getId());
		// tramitsRDTO.setNom(tramitsRDTOApi.getNom());
		// tramitsRDTO.setDescripcio(tramitsRDTOApi.getDescripcio());
		// tramitsRDTOList.add(tramitsRDTO);
		// }

		return historicsRDTOList;
	}
}