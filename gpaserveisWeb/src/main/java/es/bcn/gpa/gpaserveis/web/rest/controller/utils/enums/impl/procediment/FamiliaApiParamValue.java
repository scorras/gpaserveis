package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.procediment;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum FamiliaApiParamValue.
 */
public enum FamiliaApiParamValue implements BaseApiParamValue {

    /** The atencio social i residencial. */
	ATENCIO_SOCIAL_I_RESIDENCIAL("ATENCIO_SOCIAL_I_RESIDENCIAL", new BigDecimal(0)),

	/** The autoritzacions i comunicats. */
	AUTORITZACIONS_I_COMUNICATS("AUTORITZACIONS_I_COMUNICATS", new BigDecimal(1)),

	/** The certamens i premis. */
	CERTAMENS_I_PREMIS("CERTAMENS_I_PREMIS", new BigDecimal(2)),

	/** The col laboracio. */
	COL_LABORACIO("COL_LABORACIO", new BigDecimal(3)),

	/** The consultes i suggeriments. */
	CONSULTES_I_SUGGERIMENTS("CONSULTES_I_SUGGERIMENTS", new BigDecimal(4)),

	/** The contractacio publica. */
	CONTRACTACIO_PUBLICA("CONTRACTACIO_PUBLICA", new BigDecimal(5)),

	/** The disciplina inspeccio i proteccio de la legalitat. */
	DISCIPLINA_INSPECCIO_I_PROTECCIO_DE_LA_LEGALITAT("DISCIPLINA_INSPECCIO_I_PROTECCIO_DE_LA_LEGALITAT", new BigDecimal(6)),

	/** The drets d acces a la informacio. */
	DRETS_D_ACCES_A_LA_INFORMACIO("DRETS_D_ACCES_A_LA_INFORMACIO", new BigDecimal(7)),

	/** The drets i activitat civil. */
	DRETS_I_ACTIVITAT_CIVIL("DRETS_I_ACTIVITAT_CIVIL", new BigDecimal(8)),

	/** The ens dependents i participats. */
	ENS_DEPENDENTS_I_PARTICIPATS("ENS_DEPENDENTS_I_PARTICIPATS", new BigDecimal(9)),

	/** The execucio urbanistica. */
	EXECUCIO_URBANISTICA("EXECUCIO_URBANISTICA", new BigDecimal(10)),

	/** The gestio del personal. */
	GESTIO_DEL_PERSONAL("GESTIO_DEL_PERSONAL", new BigDecimal(11)),

	/** The gestio pressupostaria i financera. */
	GESTIO_PRESSUPOSTARIA_I_FINANCERA("GESTIO_PRESSUPOSTARIA_I_FINANCERA", new BigDecimal(12)),

	/** The gestio tributaria. */
	GESTIO_TRIBUTARIA("GESTIO_TRIBUTARIA", new BigDecimal(13)),

	/** The informes i certificats. */
	INFORMES_I_CERTIFICATS("INFORMES_I_CERTIFICATS", new BigDecimal(14)),

	/** The inscripcions registrals. */
	INSCRIPCIONS_REGISTRALS("INSCRIPCIONS_REGISTRALS", new BigDecimal(15)),

	/** The mediacio i arbitratge. */
	MEDIACIO_I_ARBITRATGE("MEDIACIO_I_ARBITRATGE", new BigDecimal(16)),

	/** The normativa. */
	NORMATIVA("NORMATIVA", new BigDecimal(17)),

	/** The ocupacio i serveis a la via publica. */
	OCUPACIO_I_SERVEIS_A_LA_VIA_PUBLICA("OCUPACIO_I_SERVEIS_A_LA_VIA_PUBLICA", new BigDecimal(18)),

	/** The participacio. */
	PARTICIPACIO("PARTICIPACIO", new BigDecimal(19)),

	/** The planejament urbanistic. */
	PLANEJAMENT_URBANISTIC("PLANEJAMENT_URBANISTIC", new BigDecimal(20)),

	/** The prevencio. */
	PREVENCIO("PREVENCIO", new BigDecimal(21)),

	/** The queixes i reclamacions. */
	QUEIXES_I_RECLAMACIONS("QUEIXES_I_RECLAMACIONS", new BigDecimal(22)),

	/** The regim de bens i patrimoni. */
	REGIM_DE_BENS_I_PATRIMONI("REGIM_DE_BENS_I_PATRIMONI", new BigDecimal(23)),

	/** The regim sancionador. */
	REGIM_SANCIONADOR("REGIM_SANCIONADOR", new BigDecimal(24)),

	/** The responsabilitat patrimonial. */
	RESPONSABILITAT_PATRIMONIAL("RESPONSABILITAT_PATRIMONIAL", new BigDecimal(25)),

	/** The revisio de l actuacio administrativa. */
	REVISIO_DE_L_ACTUACIO_ADMINISTRATIVA("REVISIO_DE_L_ACTUACIO_ADMINISTRATIVA", new BigDecimal(26)),

	/** The subvencions i ajuts. */
	SUBVENCIONS_I_AJUTS("SUBVENCIONS_I_AJUTS", new BigDecimal(27)),

	/** The targetes carnets i identificacions. */
	TARGETES_CARNETS_I_IDENTIFICACIONS("TARGETES_CARNETS_I_IDENTIFICACIONS", new BigDecimal(28)),

	/** The altres. */
	ALTRES("ALTRES", new BigDecimal(29));

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
	FamiliaApiParamValue(String apiParamValue, BigDecimal internalValue) {
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
