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

	/* Documents */
	ERROR_DOCUMENTS_NOT_FOUND("4001", "No s'ha trobat el document"),

	ERROR_DOCUMENTS_NOT_IN_EXPEDIENT("4002", "El document indicat no està associat a l'expedient"),

	ERROR_CONFIGURACIO_DOCUMENTACIO_NOT_IN_EXPEDIENT("4003", "La configuració de documentació indicada no està associada a l'expedient: "),

	ERROR_DOCUMENTS_OPENTEXT("4004", "");

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
