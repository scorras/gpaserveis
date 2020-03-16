package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.impl.expedient;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums.BaseApiParamValue;

/**
 * The Enum AccioTramitadorApiParamValue.
 */
public enum AccioTramitadorApiParamValue implements BaseApiParamValue {

	CREAR_EXPEDIENT("Crear expedient", new BigDecimal(1)),

	APORTAR_DOCUMENTACIO("Aportar documentació", new BigDecimal(2)),

	RESPONDRE_REQUERIMENT_O_TRAMIT_ALLEGACIONS_O_IP("Respondre a requeriment o tràmit d'al·legacions o IP", new BigDecimal(3)),

	REGISTRAR_SOLLICITUD("Registrar la sol·licitud", new BigDecimal(4)),

	PRESENTAR_DECLARACIO_RESPONSABLE("Presentar declaració responsable", new BigDecimal(5)),

	PRESENTAR_RECURS("Presentar recurs", new BigDecimal(6)),

	INICIAR_REVISIO_EXPEDIENT("Iniciar revisió expedient", new BigDecimal(7)),

	OBRIR_EXPEDIENT("Obrir expedient", new BigDecimal(8)),

	TANCAR_EXPEDIENT("Tancar expedient", new BigDecimal(9)),

	CONSULTAR_EXPEDIENT_DOCUMENT_FUNCIONARI("Consultar expedient / document (funcionari)", new BigDecimal(10)),

	INCORPORAR_NOU_DOCUMENT_ELECTRONIC("Incorporar un nou document electrònic", new BigDecimal(11)),

	INCORPORAR_DOCUMENT_AMB_CSV("Incorporar un document amb CSV", new BigDecimal(12)),

	DIGITALITZAR_DOCUMENT("Digitalitzar un document", new BigDecimal(13)),

	COMPLETAR_DOCUMENT("Completar un document", new BigDecimal(14)),

	VALIDAR_DOCUMENT("Validar un document", new BigDecimal(15)),

	REBUTJAR_DOCUMENT("Rebutjar un document", new BigDecimal(16)),

	SUBSTITUIR_DOCUMENT("Substituir un document", new BigDecimal(17)),

	PREPARAR_REQUERIMENT_INTERESSAT("Preparar un requeriment a l'interessat", new BigDecimal(18)),

	NOTIFICAR("Notificar", new BigDecimal(19)),

	PAUSAR_EXPEDIENT("Pausar l'expedient", new BigDecimal(20)),

	REACTIVAR_EXPEDIENT("Reactivar expedient", new BigDecimal(21)),

	REGISTRAR_COMUNICACIO("Registrar comunicació", new BigDecimal(22)),

	ARXIVAR_SOLLICITUD_INCOMPLETA(Constants.DESCRIPCIO_ACCIO_ARXIVAR, new BigDecimal(23)),

	VALIDAR_SOLLICITUD("Validar sol·licitud", new BigDecimal(24)),

	CONVIDAR_TRAMITAR("Convidar a tramitar", new BigDecimal(25)),

	RETORNAR_TRAMITACIO("Retornar la tramitació", new BigDecimal(26)),

	PROPOSAR_RESOLUCIO("Proposar resolució", new BigDecimal(27)),

	VALIDAR_PROPOSTA("Validar proposta (Vist-i-plau)", new BigDecimal(28)),

	SIGNAR_DOCUMENT("Signar document", new BigDecimal(29)),

	GENERAR_COPIA_ELECTRONICA_AUTENTICA_IMPRIMIBLE("Generar Còpia electrònica autèntica imprimible", new BigDecimal(30)),

	PUBLICAR_PER_A_INFORMACIO_PUBLICA("Publicar per a informació pública", new BigDecimal(31)),

	OBTENIR_DOCUMENT_INTEROPERABILITAT("Obtenir un document per interoperabilitat", new BigDecimal(32)),

	OBTENIR_DOCUMENT_INTRAOPERABILITAT("Obtenir un document per intraoperabilitat", new BigDecimal(33)),

	ANOTAR_OPERACIO_COMPTABLE("Anotar Operació comptable", new BigDecimal(34)),

	ACCES_EXPEDIENT("Accés a l'expedient (funcionari dóna accés)", new BigDecimal(35)),

	CERTIFICAR("Certificar", new BigDecimal(36)),

	ACUMULAR_EXPEDIENTS("Acumular expedients", new BigDecimal(37)),

	INSCRIURE_REGISTRE("Inscriure en un registre", new BigDecimal(38)),

	INFORMAR_DADES_EXPEDIENT("Informar dades de l'expedient", new BigDecimal(39)),

	DESISTIR_RENUNCIAR("Desistir / Renunciar", new BigDecimal(40)),

	CANVIAR_UNITAT_GESTORA("Canviar d'unitat gestora", new BigDecimal(41)),

	ESBORRAR_DOCUMENT("Esborrar document", new BigDecimal(42)),

	TORNAR_ENRERE("Tornar enrere", new BigDecimal(43)),

	DOCUMENT_SIGNAT("Document signat", new BigDecimal(44)),

	EXPORTACIO_EVIDENCIES("Exportació evidències", new BigDecimal(45)),

	ASSIGNAR_EXPEDIENT("Assignar expedient", new BigDecimal(46));

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
