package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;

/**
 * The Class InternalToDadesGrupListConverter.
 */
@Component("procedimentInternalToDadesGrupListConverter")
public class InternalToDadesGrupListConverter extends
        AbstractConverter<List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO>, List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO>> {

	/** The tipus camp api param value translator. */
	@Autowired
	@Qualifier("procedimentTipusCampApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusCampApiParamValueTranslator;

	/** The tipus validacio api param value translator. */
	@Autowired
	@Qualifier("procedimentTipusValidacioApiParamValueTranslator")
	private BaseApiParamValueTranslator tipusValidacioApiParamValueTranslator;

	/** The expedient estat tramitador api param value translator. */
	@Autowired
	@Qualifier("expedientEstatTramitadorApiParamValueTranslator")
	private BaseApiParamValueTranslator expedientEstatTramitadorApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO> convert(
	        List<es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO> source) {
		ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO> dadesGrupsRDTOList = new ArrayList<es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO>();
		if (CollectionUtils.isNotEmpty(source)) {
			for (es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO internalDadesGrupsRDTO : source) {
				dadesGrupsRDTOList
				        .add(ConverterHelper.buildDadesGrupsRDTOProcediment(internalDadesGrupsRDTO, tipusCampApiParamValueTranslator,
				                tipusValidacioApiParamValueTranslator, expedientEstatTramitadorApiParamValueTranslator));
			}
		}
		return dadesGrupsRDTOList;
	}
}