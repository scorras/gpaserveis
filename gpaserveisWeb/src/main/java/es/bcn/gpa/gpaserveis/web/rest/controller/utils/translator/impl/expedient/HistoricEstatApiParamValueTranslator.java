package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.HistoricEstatApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class HistoricEstatApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientHistoricEstatApiParamValueTranslator")
public class HistoricEstatApiParamValueTranslator extends ApiParamValueTranslator<HistoricEstatApiParamValue, String> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "EN_PREPARACIO, SOL_LICITUD_EN_REVISIO, PENDENT_ESMENES, EN_TRAMITACIO, PENDENT_AL_LEGACIONS, PENDENT_D_INFORMES, PROPOSTA_DE_FINALITZACIO, FINALITZAT_I_COMUNICAT, TANCAT";

}
