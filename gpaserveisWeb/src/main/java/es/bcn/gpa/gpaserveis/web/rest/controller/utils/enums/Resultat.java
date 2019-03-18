package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums;

/**
 * The Enum Resultat.
 */
public enum Resultat {

	OK_CREAR_EXPEDIENT("OK", "Expedient creat correctament"),

	ERROR_CREAR_EXPEDIENT("ERROR", "No s'ha pogut crear l'expedient"),

	OK_ACTUALITZAR_EXPEDIENT("OK", "Expedient actualitzat correctament"),

	ERROR_ACTUALITZAR_EXPEDIENT("ERROR", "No s'ha pogut actualitzar l'expedient"),

	OK_APORTAR_DOCUMENTACIO_EXPEDIENT("OK", "Documentació aportat correctament"),

	ERROR_APORTAR_DOCUMENTACIO_EXPEDIENT("ERROR", "No s'ha pogut aportar la documentació"),

	OK_SUBSTITUIR_DOCUMENT_EXPEDIENT("OK", "Document actualitzat correctament"),

	ERROR_SUBSTITUIR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut actualitzar el document"),

	OK_ESBORRAR_DOCUMENT_EXPEDIENT("OK", "Document donat de baixa correctament"),

	ERROR_ESBORRAR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut donar de baixa el document");

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
