package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment.CompetenciaAssociadaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class CompetenciaAssociadaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component
public class CompetenciaAssociadaApiParamValueTranslator extends ApiParamValueTranslator<CompetenciaAssociadaApiParamValue, BigDecimal> {

	/** The Constant REQUEST_PARAM_NAME. */
	public static final String REQUEST_PARAM_NAME = "competenciaAssociada";

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "ACCIO_SOCIAL, AFERS_JURIDICS, BENS_I_PATRIMONI, COMERC_I_CONSUM, CULTURA, EDUCACIO, ESPORTS_I_LLEURE, HABITATGE, MEDI_AMBIENT, MOVILITAT_TRANSPORT_I_CIRCULACIO, OBRES_I_INFRAESTRUCTURES, ORGANITZACIO_I_COORDINACIO_ADMINISTRATIVA, ORGANS_DE_GOVERN, POBLACIO_I_DEMARCACIO, POTESTATS_DE_PLANIFICACIO_I_NORMATIVA, PRESSUPOSTOS_I_FINANCES, PROMOCIO_ECONOMICA, RECURSOS_HUMANS";

}
