package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums;

/**
 * The Enum ErrorPrincipal.
 */
public enum ErrorPrincipal {

	/* Generic */
	ERROR_GENERIC("9999", "S'ha produit una incidencia"),

	/* Unitats */
	ERROR_UNITATS_NOT_FOUND("1001", "No s'ha trobat la unitat gestora"),

	ERROR_UNITATS_NOT_IN_PROCEDIMENT("1002", "La unitat gestora indicada no està associada al procediment"),

	ERROR_UNITATS_NOT_VIGENT("1003", "La unitat gestora indicada no està vigent"),

	/* Procediments */
	ERROR_PROCEDIMENTS_NOT_FOUND("2001", "No s'ha trobat el procediment"),

	ERROR_PROCEDIMENTS_NOT_PUBLICAT("2002", "El procediment ha de trobar-se en estat Publicat"),

	/* Expedients */
	ERROR_EXPEDIENTS_NOT_FOUND("3001", "No s'ha trobat l'expedient"),

	ERROR_EXPEDIENTS_ACCIO_NOT_AVAILABLE("3002", "Acció no disponible: "),

	ERROR_EXPEDIENTS_SOLLICITANT_REQUIRED("3003", "El sol·licitant és obligatori en cas d'indicar persones interessades"),

	ERROR_EXPEDIENTS_ATRIBUT_NOT_FOUND("3004", "No s'ha trobat la dada d'operació: "),

	ERROR_EXPEDIENTS_ATRIBUT_NOT_CORRECT_VALUE("3005", "Valor incorrecte per la dada d'operació: "),

	ERROR_EXPEDIENTS_ATRIBUT_NOT_VALID_VALUE("3006", "El valor de la Dada d'operació no compleix amb les validacions: "),

	ERROR_EXPEDIENTS_REGISTRE_ASSENTAMENT_NOT_FOUND("3007", "No es troba l'assentament de registre"),

	ERROR_EXPEDIENTS_DADA_OPERACIO_REQUERIMENT_NOT_AVAILABLE("3008",
			"La dada d'operació no està disponible per a ser afegit al requeriment: "),

	ERROR_EXPEDIENTS_ACUMULADOR_NOT_FOUND("3009", "No s'ha trobat l'expedient acumulador"),

	ERROR_EXPEDIENTS_ACUMULADOR_NOT_VALID_JA_ACUMULAT("3010", "L'expedient acumulador no és vàlid perquè ja ha estat acumulat"),

	ERROR_EXPEDIENTS_ACUMULAT_NOT_FOUND("3011", "No s'ha trobat l'expedient a acumular"),

	ERROR_EXPEDIENTS_ACUMULAT_NOT_VALID_MATEIX_EXPEDIENT("3012", "No és possible acumular un expedient a si mateix"),

	ERROR_EXPEDIENTS_ACUMULAT_NOT_VALID_MATEIX_PROCEDIMENT("3013",
			"Els expedients acumulador i acumulat han d'estar associats al mateix procediment"),

	ERROR_EXPEDIENTS_ACUMULAT_NOT_VALID_JA_ACUMULAT("3014",
			"L'expedient a acumular no és vàlid perquè ja ha estat acumulat a un altre expedient"),

	ERROR_EXPEDIENTS_PERSONA_IMPLICADA_NOT_FOUND("3015", "No s'ha trobat la persona implicada en l'expedient"),

	ERROR_EXPEDIENTS_DATA_LIMIT_NOT_VALID("3016", "La data límit no és vàlida perquè és anterior a la data actual"),

	/* Documents */
	ERROR_DOCUMENTS_NOT_FOUND("4001", "No s'ha trobat el document"),

	ERROR_DOCUMENTS_NOT_IN_EXPEDIENT("4002", "El document indicat no està associat a l'expedient"),

	ERROR_CONFIGURACIO_DOCUMENTACIO_NOT_IN_EXPEDIENT("4003", "La configuració de documentació indicada no està associada a l'expedient: "),

	ERROR_CONFIGURACIO_DOCUMENTACIO_REQUERIMENT_NOT_AVAILABLE("4004",
			"La configuració de documentació no està disponible per a ser afegida al requeriment: "),

	ERROR_DOCUMENTS_UPLOAD_DECLARACIO_RESPONSABLE_NOT_AVAILABLE("4005", "No és possible pujar un fitxer a una declaració responsable"),

	ERROR_ENTRADA_DOCUMENTS_UPLOAD("4006", "No és possible pujar un fitxer a una declaració responsable"),

	/* Integracions */
	ERROR_ARIADNA("5001", ""),

	ERROR_CATALEG("5002", ""),

	ERROR_CTRLUSER("5003", ""),

	ERROR_DIGITALITZACIO("5004", ""),

	ERROR_GEOCOD("5005", ""),

	ERROR_NOTIFICADOR("5006", ""),

	ERROR_OPENTEXT("5007", ""),

	ERROR_PDFGESTOR("5008", ""),

	ERROR_PORTASIG("5009", ""),

	ERROR_SIGNATURES("5010", "");

	private String codi;

	private String descripcio;

	ErrorPrincipal(String codi, String descripcio) {
		this.codi = codi;
		this.descripcio = descripcio;
	}

	public String getCodi() {
		return codi;
	}

	public String getDescripcio() {
		return descripcio;
	}
}
