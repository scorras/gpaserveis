package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum TipusViaApiParamValue.
 */
public enum TipusViaApiParamValue implements BaseApiParamValue {

    /** The fageda. */
	FAGEDA("FAGEDA", "AL"),

	/** The apartament. */
	APARTAMENT("APARTAMENT", "AP"),

	/** The avinguda. */
	AVINGUDA("AVINGUDA", "AV"),

	/** The baixada. */
	BAIXADA("BAIXADA", "BD"),

	/** The barranc corregada. */
	BARRANC_CORREGADA("BARRANC_CORREGADA", "BC"),

	/** The barri. */
	BARRI("BARRI", "BO"),

	/** The bloc. */
	BLOC("BLOC", "BL"),

	/** The cami. */
	CAMI("CAMI", "CM"),

	/** The carrer. */
	CARRER("CARRER", "CA"),

	/** The carrero. */
	CARRERO("CARRERO", "CJ"),

	/** The carretera. */
	CARRETERA("CARRETERA", "CR"),

	/** The colonia. */
	COLONIA("COLONIA", "CO"),

	/** The cases. */
	CASES("CASES", "CS"),

	/** The costa. */
	COSTA("COSTA", "CT"),

	/** The disseminat. */
	DISSEMINAT("DISSEMINAT", "DS"),

	/** The edifici. */
	EDIFICI("EDIFICI", "ED"),

	/** The glorieta. */
	GLORIETA("GLORIETA", "GL"),

	/** The grup. */
	GRUP("GRUP", "GR"),

	/** The gran via. */
	GRAN_VIA("GRAN_VIA", "GV"),

	/** The lloc. */
	LLOC("LLOC", "LG"),

	/** The mercat. */
	MERCAT("MERCAT", "MC"),

	/** The parc. */
	PARC("PARC", "PQ"),

	/** The partida. */
	PARTIDA("PARTIDA", "PD"),

	/** The passatge. */
	PASSATGE("PASSATGE", "PJ"),

	/** The passeig. */
	PASSEIG("PASSEIG", "PS"),

	/** The placeta. */
	PLACETA("PLACETA", "PL"),

	/** The placa. */
	PLACA("PLACA", "PZ"),

	/** The poblat. */
	POBLAT("POBLAT", "PB"),

	/** The poligon. */
	POLIGON("POLIGON", "PG"),

	/** The prolongacio. */
	PROLONGACIO("PROLONGACIO", "PR"),

	/** The pujada. */
	PUJADA("PUJADA", "SD"),

	/** The rambla. */
	RAMBLA("RAMBLA", "RB"),

	/** The ronda. */
	RONDA("RONDA", "RD"),

	/** The senda. */
	SENDA("SENDA", "SN"),

	/** The torrent. */
	TORRENT("TORRENT", "TT"),

	/** The travessia. */
	TRAVESSIA("TRAVESSIA", "TR"),

	/** The travessera. */
	TRAVESSERA("TRAVESSERA", "TS"),

	/** The urbanitzacio. */
	URBANITZACIO("URBANITZACIO", "UR"),

	/** The xalet. */
	XALET("XALET", "CH"),

	/** The via. */
	VIA("VIA", "VI");

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private String internalValue;

	/**
	 * Instantiates a new tipus via api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	TipusViaApiParamValue(String apiParamValue, String internalValue) {
		this.apiParamValue = apiParamValue;
		this.internalValue = internalValue;
	}

	/**
	 * Gets the api param value.
	 *
	 * @return the api param value
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getApiParamValue() {
		return apiParamValue;
	}

	/**
	 * Gets the internal value.
	 *
	 * @return the internal value
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue#
	 * getInternalValue()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getInternalValue() {
		return internalValue;
	}
}
