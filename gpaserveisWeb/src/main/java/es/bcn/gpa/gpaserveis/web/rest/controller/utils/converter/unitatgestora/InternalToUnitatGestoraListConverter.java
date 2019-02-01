package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.unitatgestora;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;

/**
 * The Class InternalToUnitatGestoraListConverter.
 */
@Component("internalToUnitatGestoraListConverter")
public class InternalToUnitatGestoraListConverter extends AbstractConverter<List<UnitatsGestoresRDTO>, List<UnitatGestoraRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<UnitatGestoraRDTO> convert(List<UnitatsGestoresRDTO> unitatsGestoresRDTOList) {
		ArrayList<UnitatGestoraRDTO> unitatGestoraRDTOList = new ArrayList<UnitatGestoraRDTO>();
		UnitatGestoraRDTO unitatGestoraRDTO = null;
		for (UnitatsGestoresRDTO unitatsGestoresRDTO : unitatsGestoresRDTOList) {
			unitatGestoraRDTO = new UnitatGestoraRDTO();
			unitatGestoraRDTO.setId(unitatsGestoresRDTO.getId());
			unitatGestoraRDTO.setCodi(unitatsGestoresRDTO.getNom());
			unitatGestoraRDTO.setDescripcio(unitatsGestoresRDTO.getDescripcio());
			unitatGestoraRDTOList.add(unitatGestoraRDTO);
		}

		return unitatGestoraRDTOList;
	}
}