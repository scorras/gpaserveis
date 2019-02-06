package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum CompetenciaAssociadaApiParamValue.
 */
public enum CompetenciaAssociadaApiParamValue implements BaseApiParamValue {

    /** The accio social. */
	ACCIO_SOCIAL("ACCIO_SOCIAL", new BigDecimal(1)),

	/** The afers juridics. */
	AFERS_JURIDICS("AFERS_JURIDICS", new BigDecimal(2)),

	/** The bens i patrimoni. */
	BENS_I_PATRIMONI("BENS_I_PATRIMONI", new BigDecimal(3)),

	/** The comerc i consum. */
	COMERC_I_CONSUM("COMERC_I_CONSUM", new BigDecimal(4)),

	/** The cultura. */
	CULTURA("CULTURA", new BigDecimal(5)),

	/** The educacio. */
	EDUCACIO("EDUCACIO", new BigDecimal(6)),

	/** The esports i lleure. */
	ESPORTS_I_LLEURE("ESPORTS_I_LLEURE", new BigDecimal(7)),

	/** The habitatge. */
	HABITATGE("HABITATGE", new BigDecimal(8)),

	/** The medi ambient. */
	MEDI_AMBIENT("MEDI_AMBIENT", new BigDecimal(9)),

	/** The movilitat transport i circulacio. */
	MOVILITAT_TRANSPORT_I_CIRCULACIO("MOVILITAT_TRANSPORT_I_CIRCULACIO", new BigDecimal(10)),

	/** The obres i infraestructures. */
	OBRES_I_INFRAESTRUCTURES("OBRES_I_INFRAESTRUCTURES", new BigDecimal(11)),

	/** The organitzacio i coordinacio administrativa. */
	ORGANITZACIO_I_COORDINACIO_ADMINISTRATIVA("ORGANITZACIO_I_COORDINACIO_ADMINISTRATIVA", new BigDecimal(12)),

	/** The organs de govern. */
	ORGANS_DE_GOVERN("ORGANS_DE_GOVERN", new BigDecimal(13)),

	/** The poblacio i demarcacio. */
	POBLACIO_I_DEMARCACIO("POBLACIO_I_DEMARCACIO", new BigDecimal(14)),

	/** The potestats de planificacio i normativa. */
	POTESTATS_DE_PLANIFICACIO_I_NORMATIVA("POTESTATS_DE_PLANIFICACIO_I_NORMATIVA", new BigDecimal(15)),

	/** The pressupostos i finances. */
	PRESSUPOSTOS_I_FINANCES("PRESSUPOSTOS_I_FINANCES", new BigDecimal(16)),

	/** The promocio economica. */
	PROMOCIO_ECONOMICA("PROMOCIO_ECONOMICA", new BigDecimal(17)),

	/** The recursos humans. */
	RECURSOS_HUMANS("RECURSOS_HUMANS", new BigDecimal(18)),

	/** The altres. */
	ALTRES("ALTRES", new BigDecimal(19));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new competencia associada cerca procediments.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	CompetenciaAssociadaApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal getInternalValue() {
		return internalValue;
	}
}
