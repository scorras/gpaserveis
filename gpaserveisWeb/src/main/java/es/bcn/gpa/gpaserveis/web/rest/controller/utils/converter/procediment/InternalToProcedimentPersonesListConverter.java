package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.procediment;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.procediments.DadesPersonesProcedimentBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersonesTramOvt;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.NivellVisibilitatApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.TramitsOvtProcedimentsApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ProcedimentPersonesRDTO;

/**
 * The Class InternalToProcedimentPersonesListConverter.
 */
@Component("internalToProcedimentPersonesListConverter")
public class InternalToProcedimentPersonesListConverter
		extends AbstractConverter<DadesPersonesProcedimentBDTO, List<ProcedimentPersonesRDTO>> {

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
	protected List<ProcedimentPersonesRDTO> convert(DadesPersonesProcedimentBDTO dadesPersonesProcedimentBDTO) {
		ArrayList<ProcedimentPersonesRDTO> procedimentPersonesRDTOList = new ArrayList<ProcedimentPersonesRDTO>();
		List<ProcedimentPersones> procedimentPersonesList = dadesPersonesProcedimentBDTO.getProcedimentsRDTO().getProcedimentPersonesList();
		if (procedimentPersonesList != null) {
			for (ProcedimentPersones procedimentPersones : procedimentPersonesList) {

				if (procedimentPersones.getTramitsOvtList() != null) {
					for (ProcedimentPersonesTramOvt procedimentPersonesTramOvt : procedimentPersones.getTramitsOvtList()) {

						if (procedimentPersonesTramOvt.getTramitOvtIdext()
								.compareTo(dadesPersonesProcedimentBDTO.getIdTramitOvt()) == NumberUtils.INTEGER_ZERO) {
							procedimentPersonesRDTOList
									.add(ConverterHelper.buildProcedimentPersoneRDTOProcediments(nivellVisibilitatApiParamValueTranslator,
											tramitsOvtProcedimentsApiParamValueTranslator, procedimentPersones));
						}
					}
				}

			}
		}

		return procedimentPersonesRDTOList;
	}
}