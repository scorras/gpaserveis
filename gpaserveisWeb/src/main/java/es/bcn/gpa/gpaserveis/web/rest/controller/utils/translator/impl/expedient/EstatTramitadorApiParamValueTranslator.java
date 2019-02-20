package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.EstatTramitadorApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class EstatTramitadorApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientEstatTramitadorApiParamValueTranslator")
public class EstatTramitadorApiParamValueTranslator extends ApiParamValueTranslator<EstatTramitadorApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "estat";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "EN_PREPARACIO, SOL_LICITUD_EN_REVISIO, PENDENT_ESMENES, EN_TRAMITACIO, PENDENT_AL_LEGACIONS, PENDENT_D_INFORMES, PROPOSTA_DE_FINALITZACIO, FINALITZAT_I_COMUNICAT, TANCAT";

}
