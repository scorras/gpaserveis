package es.bcn.gpa.gpaserveis.web.rest.controller.utils.mapper.cerca.procediment.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;

/**
 * The Class InternalToUgrConverter.
 */
@Component
public class InternalToUgoConverter extends AbstractConverter<String, List<UnitatGestoraRDTO>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<UnitatGestoraRDTO> convert(String source) {
		List<UnitatGestoraRDTO> unitatGestoraRDTOList = new ArrayList<UnitatGestoraRDTO>();
		UnitatGestoraRDTO unitatGestoraRDTO = null;
		if (StringUtils.isNotEmpty(source)) {
			String[] ugoNomList = source.split("\\s*,\\s*");
			for (String ugoNom : ugoNomList) {
				unitatGestoraRDTO = new UnitatGestoraRDTO();
				unitatGestoraRDTO.setNom(ugoNom);
				unitatGestoraRDTOList.add(unitatGestoraRDTO);
			}
		}
		return unitatGestoraRDTOList;
	}
}