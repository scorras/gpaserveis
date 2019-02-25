package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioRequeridaConsultaRDTO;

/**
 * The Class InternalToDocumentsEntradaRequeritsListConverter.
 */
@Component("expedientInternalToDocumentsEntradaRequeritsListConverter")
public class InternalToDocumentsEntradaRequeritsListConverter
        extends AbstractConverter<List<ConfDocEntradaRequeritRDTO>, List<ConfiguracioDocumentacioRequeridaConsultaRDTO>> {

	/** The boolean api param value translator. */
	@Autowired
	@Qualifier("booleanApiParamValueTranslator")
	private BooleanApiParamValueTranslator booleanApiParamValueTranslator;

	/** The suport confeccio api param value translator. */
	@Autowired
	@Qualifier("procedimentSuportConfeccioApiParamValueTranslator")
	private BaseApiParamValueTranslator suportConfeccioApiParamValueTranslator;

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
	protected List<ConfiguracioDocumentacioRequeridaConsultaRDTO> convert(List<ConfDocEntradaRequeritRDTO> confDocEntradaRequeritRDTOList) {
		ArrayList<ConfiguracioDocumentacioRequeridaConsultaRDTO> configuracioDocumentacioRequeridaConsultaRDTOList = null;

		if (CollectionUtils.isNotEmpty(confDocEntradaRequeritRDTOList)) {
			configuracioDocumentacioRequeridaConsultaRDTOList = ConverterHelper.buildDocumentsRequeritsRDTOExpedient(
			        confDocEntradaRequeritRDTOList, booleanApiParamValueTranslator, suportConfeccioApiParamValueTranslator,
			        expedientEstatTramitadorApiParamValueTranslator);
		}

		return configuracioDocumentacioRequeridaConsultaRDTOList;
	}
}