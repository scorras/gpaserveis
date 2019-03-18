package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum AccioTramitadorApiParamValue.
 */
public enum AccioTramitadorApiParamValue implements BaseApiParamValue {

	CREAR_EXPEDIENT("CREAR_EXPEDIENT", new BigDecimal(1)),

	APORTAR_DOCUMENTACIO("Aportar documentació", new BigDecimal(2)),

	RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP("RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP", new BigDecimal(3)),

	REGISTRAR_SOLLICITUD("REGISTRAR_SOLLICITUD", new BigDecimal(4)),

	PRESENTAR_DECLARACIO_RESPONSABLE("PRESENTAR_DECLARACIO_RESPONSABLE", new BigDecimal(5)),

	PRESENTAR_RECURS("PRESENTAR_RECURS", new BigDecimal(6)),

	INICIAR_REVISIO_EXPEDIENT("INICIAR_REVISIO_EXPEDIENT", new BigDecimal(7)),

	OBRIR_EXPEDIENT("OBRIR_EXPEDIENT", new BigDecimal(8)),

	TANCAR_EXPEDIENT("TANCAR_EXPEDIENT", new BigDecimal(9)),

	CONSULTAR_EXPEDIENT_DOCUMENT_FUNCIONARI("CONSULTAR_EXPEDIENT_DOCUMENT_FUNCIONARI", new BigDecimal(10)),

	INCORPORAR_NOU_DOCUMENT_ELECTRONIC("INCORPORAR_NOU_DOCUMENT_ELECTRONIC", new BigDecimal(11)),

	INCORPORAR_DOCUMENT_AMB_CSV("INCORPORAR_DOCUMENT_AMB_CSV", new BigDecimal(12)),

	DIGITALITZAR_DOCUMENT("DIGITALITZAR_DOCUMENT", new BigDecimal(13)),

	COMPLETAR_DOCUMENT("COMPLETAR_DOCUMENT", new BigDecimal(14)),

	VALIDAR_DOCUMENT("VALIDAR_DOCUMENT", new BigDecimal(15)),

	REBUTJAR_DOCUMENT("REBUTJAR_DOCUMENT", new BigDecimal(16)),

	SUBSTITUIR_DOCUMENT("Substituir un document", new BigDecimal(17)),

	PREPARAR_REQUERIMENT_INTERESSAT("PREPARAR_REQUERIMENT_INTERESSAT", new BigDecimal(18)),

	NOTIFICAR("NOTIFICAR", new BigDecimal(19)),

	PAUSAR_EXPEDIENT("PAUSAR_EXPEDIENT", new BigDecimal(20)),

	REACTIVAR_EXPEDIENT("REACTIVAR_EXPEDIENT", new BigDecimal(21)),

	REGISTRAR_COMUNICACIO("REGISTRAR_COMUNICACIO", new BigDecimal(22)),

	ARXIVAR_SOLLICITUD_INCOMPLETA("ARXIVAR_SOLLICITUD_INCOMPLETA", new BigDecimal(23)),

	VALIDAR_SOLLICITUD("VALIDAR_SOLLICITUD", new BigDecimal(24)),

	CONVIDAR_TRAMITAR("CONVIDAR_TRAMITAR", new BigDecimal(25)),

	RETORNAR_TRAMITACIO("RETORNAR_TRAMITACIO", new BigDecimal(26)),

	PROPOSAR_RESOLUCIO("PROPOSAR_RESOLUCIO", new BigDecimal(27)),

	VALIDAR_PROPOSTA("VALIDAR_PROPOSTA", new BigDecimal(28)),

	SIGNAR_DOCUMENT("SIGNAR_DOCUMENT", new BigDecimal(29)),

	GENERAR_COPIA_ELECTRONICA_AUTENTICA_IMPRIMIBLE("GENERAR_COPIA_ELECTRONICA_AUTENTICA_IMPRIMIBLE", new BigDecimal(30)),

	PUBLICAR_PER_A_INFORMACIO_PUBLICA("PUBLICAR_PER_A_INFORMACIO_PUBLICA", new BigDecimal(31)),

	OBTENIR_DOCUMENT_INTEROPERABILITAT("OBTENIR_DOCUMENT_INTEROPERABILITAT", new BigDecimal(32)),

	OBTENIR_DOCUMENT_INTRAOPERABILITAT("OBTENIR_DOCUMENT_INTRAOPERABILITAT", new BigDecimal(33)),

	ANOTAR_OPERACIO_COMPTABLE("ANOTAR_OPERACIO_COMPTABLE", new BigDecimal(34)),

	ACCES_EXPEDIENT("ACCES_EXPEDIENT", new BigDecimal(35)),

	CERTIFICAR("CERTIFICAR", new BigDecimal(36)),

	ACUMULAR_EXPEDIENTS("ACUMULAR_EXPEDIENTS", new BigDecimal(37)),

	INSCRIURE_REGISTRE("INSCRIURE_REGISTRE", new BigDecimal(38)),

	INFORMAR_DADES_EXPEDIENT("Informar dades de l'expedient", new BigDecimal(39)),

	DESISTIR_RENUNCIAR("DESISTIR_RENUNCIAR", new BigDecimal(40)),

	CANVIAR_UNITAT_GESTORA("Canviar d'unitat gestora", new BigDecimal(41)),

	ESBORRAR_DOCUMENT("Esborrar document", new BigDecimal(42)),

	EXPORTACIO_EVIDENCIES("EXPORTACIO_EVIDENCIES", new BigDecimal(43)),

	ASSIGNAR_EXPEDIENT("ASSIGNAR_EXPEDIENT", new BigDecimal(44));

	/** The api param value. */
	private String apiParamValue;

	/** The internal value. */
	private BigDecimal internalValue;

	/**
	 * Instantiates a new accio api param value.
	 *
	 * @param apiParamValue
	 *            the api param value
	 * @param internalValue
	 *            the internal value
	 */
	AccioTramitadorApiParamValue(String apiParamValue, BigDecimal internalValue) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue#
	 * getInternalValue()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal getInternalValue() {
		return internalValue;
	}
}
