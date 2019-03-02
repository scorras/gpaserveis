package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums;

/**
 * The Enum ErrorPrincipal.
 */
public enum ErrorPrincipal {

	ERROR_GENERIC("9999", "S'ha produit una incidencia"),

	ERROR_UNITATS_NOT_FOUND("1001", "No s'ha trobat la unitat gestora"),

	ERROR_UNITATS_NOT_IN_PROCEDIMENT("1002", "La unitat gestora indicada no està associada al procediment"),

	ERROR_PROCEDIMENTS_NOT_FOUND("2001", "No s'ha trobat el procediment");

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
