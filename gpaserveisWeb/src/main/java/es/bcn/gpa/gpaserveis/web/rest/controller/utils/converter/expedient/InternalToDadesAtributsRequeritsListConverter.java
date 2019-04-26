package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesOperacions;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsRequeritsRDTO;

/**
 * The Class InternalToDadesAtributsRequeritsListConverter.
 */
@Component("expedientInternalToDadesAtributsRequeritsListConverter")
public class InternalToDadesAtributsRequeritsListConverter
        extends AbstractConverter<List<DadesOperacions>, List<DadesAtributsRequeritsRDTO>> {

	/** The tipus camp api param value translator. */
	@Autowired
	@Qualifier("procedimentTipusCampApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusCampApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<DadesAtributsRequeritsRDTO> convert(List<DadesOperacions> source) {
		ArrayList<DadesAtributsRequeritsRDTO> dadesAtributsRequeritsRDTOList = null;
		if (CollectionUtils.isNotEmpty(source)) {
			dadesAtributsRequeritsRDTOList = new ArrayList<DadesAtributsRequeritsRDTO>();
			DadesAtributsRequeritsRDTO dadesAtributsRequeritsRDTO = null;
			for (DadesOperacions dadesOperacions : source) {
				dadesAtributsRequeritsRDTO = new DadesAtributsRequeritsRDTO();
				dadesAtributsRequeritsRDTO.setCodi(dadesOperacions.getCodi());
				dadesAtributsRequeritsRDTO.setDescripcio(dadesOperacions.getDescripcio());
				dadesAtributsRequeritsRDTO.setDescripcioCastella(dadesOperacions.getDescripcioCastella());
				dadesAtributsRequeritsRDTO.setTitol(dadesOperacions.getTitol());
				dadesAtributsRequeritsRDTO.setTitolCastella(dadesOperacions.getTitolCastella());
				dadesAtributsRequeritsRDTO
				        .setTipus(tipusCampApiParamValueTranslator.getApiParamValueByInternalValue(dadesOperacions.getTipus()));
				dadesAtributsRequeritsRDTOList.add(dadesAtributsRequeritsRDTO);
			}
		}
		return dadesAtributsRequeritsRDTOList;
	}
}