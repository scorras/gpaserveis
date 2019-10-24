package es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.expedient;

import static org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.business.dto.expedients.DadesExpedientBDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfDocEntradaRequeritRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.AccionsEstatsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.converter.ConverterHelper;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.AccioCiutadaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.BaseApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.common.BooleanApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.ConfiguracioDocumentacioRequeridaConsultaRDTO;

/**
 * The Class InternalToDocumentsEntradaRequeritsListConverter.
 */
@Component("expedientInternalToDocumentsEntradaRequeritsListConverter")
public class InternalToDocumentsEntradaRequeritsListConverter
		extends AbstractConverter<DadesExpedientBDTO, List<ConfiguracioDocumentacioRequeridaConsultaRDTO>> {

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
	protected List<ConfiguracioDocumentacioRequeridaConsultaRDTO> convert(DadesExpedientBDTO dadesExpedientBDTO) {
		ArrayList<ConfiguracioDocumentacioRequeridaConsultaRDTO> configuracioDocumentacioRequeridaConsultaRDTOList = null;

		List<ConfDocEntradaRequeritRDTO> confDocEntradaRequeritRDTOList = dadesExpedientBDTO.getConfiguracioDocumentacioRequerida();

		// solo incluimos los documentos requeridos si la accion que manejamos
		// es la de requerimiento de esmena
		boolean accionRequerimentEsmena = false;
		for (AccionsEstatsRDTO accionsEstatsRDTO : dadesExpedientBDTO.getAccionsDisponibles()) {
			if (accionsEstatsRDTO.getAccio().compareTo(AccioCiutadaApiParamValue.REQUERIMENT_ESMENA.getInternalValue()) == INTEGER_ZERO) {
				accionRequerimentEsmena = true;
			}
		}

		if (accionRequerimentEsmena && CollectionUtils.isNotEmpty(confDocEntradaRequeritRDTOList)) {
			configuracioDocumentacioRequeridaConsultaRDTOList = ConverterHelper.buildDocumentsRequeritsRDTOExpedient(
					confDocEntradaRequeritRDTOList, booleanApiParamValueTranslator, suportConfeccioApiParamValueTranslator,
					expedientEstatTramitadorApiParamValueTranslator);
		}

		return configuracioDocumentacioRequeridaConsultaRDTOList;
	}
}