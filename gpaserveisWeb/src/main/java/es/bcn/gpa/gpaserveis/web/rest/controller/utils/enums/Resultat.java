package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums;

/**
 * The Enum Resultat.
 */
public enum Resultat {

	OK_CREAR_EXPEDIENT("OK", "Expedient creat correctament"),

	ERROR_CREAR_EXPEDIENT("ERROR", "No s'ha pogut crear l'expedient");

	private String codi;

	private String descripcio;

	Resultat(String codi, String descripcio) {
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
