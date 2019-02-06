package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.tramit;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO;

/**
 * The Class InternalToHistoricListConverter.
 */
@Component("internalToTramitProcedimentListConverter")
public class InternalToTramitProcedimentListConverter extends
        AbstractConverter<List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO>, List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO> convert(
	        List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO> tramitsRDTOApiList) {
		ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO> tramitsRDTOList = new ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO>();
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO tramitsRDTO = null;

		for (es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO tramitsRDTOApi : tramitsRDTOApiList) {
			tramitsRDTO = new TramitsRDTO();
			tramitsRDTO.setId(tramitsRDTOApi.getId());
			tramitsRDTO.setNom(tramitsRDTOApi.getNom());
			tramitsRDTO.setDescripcio(tramitsRDTOApi.getDescripcio());
			tramitsRDTOList.add(tramitsRDTO);
		}

		return tramitsRDTOList;
	}
}