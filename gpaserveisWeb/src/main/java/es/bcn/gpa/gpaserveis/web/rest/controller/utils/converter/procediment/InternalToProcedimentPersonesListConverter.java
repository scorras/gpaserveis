package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.NivellVisibilitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitsOvtProcedimentsApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ProcedimentPersonesRDTO;

/**
 * The Class InternalToProcedimentPersonesListConverter.
 */
@Component("internalToProcedimentPersonesListConverter")
public class InternalToProcedimentPersonesListConverter
		extends AbstractConverter<List<ProcedimentPersones>, List<ProcedimentPersonesRDTO>> {

	@Autowired
	@Qualifier("nivellVisibilitatApiParamValueTranslator")
	private NivellVisibilitatApiParamValueTranslator nivellVisibilitatApiParamValueTranslator;

	@Autowired
	@Qualifier("tramitsOvtProcedimentsApiParamValueTranslator")
	private TramitsOvtProcedimentsApiParamValueTranslator tramitsOvtProcedimentsApiParamValueTranslator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.modelmapper.AbstractConverter#convert(java.lang.Object)
	 */
	@Override
	protected List<ProcedimentPersonesRDTO> convert(List<ProcedimentPersones> procedimentPersonesList) {
		ArrayList<ProcedimentPersonesRDTO> procedimentPersonesRDTOList = new ArrayList<ProcedimentPersonesRDTO>();
		if (procedimentPersonesList != null) {
			for (ProcedimentPersones procedimentPersones : procedimentPersonesList) {
				procedimentPersonesRDTOList.add(ConverterHelper.buildProcedimentPersoneRDTOProcediments(
						nivellVisibilitatApiParamValueTranslator, tramitsOvtProcedimentsApiParamValueTranslator, procedimentPersones));
			}
		}

		return procedimentPersonesRDTOList;
	}
}