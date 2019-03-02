package es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient;

import org.springframework.stereotype.Component;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient.TipusViaApiParamValue;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.ApiParamValueTranslator;

/**
 * The Class TipusViaApiParamValueTranslator.
 */
@SuppressWarnings("unchecked")
@Component("expedientTipusViaApiParamValueTranslator")
public class TipusViaApiParamValueTranslator extends ApiParamValueTranslator<TipusViaApiParamValue, String> {

	/** The Constant REQUEST_PARAM_ALLOWABLE_VALUES. */
	public static final String REQUEST_PARAM_ALLOWABLE_VALUES = "FAGEDA, APARTAMENT, AVINGUDA, BAIXADA, BARRANC_CORREGADA, BARRI, BLOC, CAMI, CARRER, CARRERO, CARRETERA, COLONIA, CASES, COSTA, DISSEMINAT, EDIFICI, GLORIETA, GRUP, GRAN_VIA, LLOC, MERCAT, PARC, PARTIDA, PASSATGE, PASSEIG, PLACETA, PLACA, POBLAT, POLIGON, PROLONGACIO, PUJADA, RAMBLA, RONDA, SENDA, TORRENT, TRAVESSIA, TRAVESSERA, URBANITZACIO, XALET, VIA";

}
