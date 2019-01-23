package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.tramit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.TramitsService;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisRuntimeException;
import es.bcn.gpa.gpaserveis.business.exception.GPAServeisServiceException;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.PageDataOfTramitsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO;

/**
 * The Class InternalToTramitProcedimentListConverter.
 */
@Component("internalToTramitProcedimentListConverter")
public class InternalToTramitProcedimentListConverter
        extends AbstractConverter<BigDecimal, List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO>> {

	/** The tramits service. */
	@Autowired
	private TramitsService tramitsService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO> convert(BigDecimal source) {
		ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO> tramitsRDTOList = new ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO>();
		es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO tramitsRDTO = null;
		List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO> tramitsRDTOApiList = null;
		try {
			// TODO Quizá este no sea el lugar más adecuado para realizar la
			// llamada al servicio de Tramits
			PageDataOfTramitsRDTO pageDataOfTramitsRDTO = tramitsService.cercaTramitsProcediment(source);
			tramitsRDTOApiList = pageDataOfTramitsRDTO.getData();
		} catch (GPAServeisServiceException e) {
			throw new GPAServeisRuntimeException(e);
		}

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