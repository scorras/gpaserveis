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

	ERROR_ESBORRAR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut donar de baixa el document"),

	OK_UPLOAD_DOCUMENT_EXPEDIENT("OK", "Document pujat correctament"),

	ERROR_UPLOAD_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut pujar el document"),

	OK_DESCARREGAR_DOCUMENT_EXPEDIENT("OK", "Document descarregat correctament"),

	ERROR_DESCARREGAR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut descarregar el document"),

	OK_ESMENAR_EXPEDIENT("OK", "Requeriments de l’expedient incorporats correctament"),

	ERROR_ESMENAR_EXPEDIENT("ERROR", "No s'han pogut incorporar els requeriments a l'expedient"),

	OK_DESISTIR_RENUNCIAR_EXPEDIENT("OK", "Expedient desistit/renunciat correctament"),

	ERROR_DESISTIR_RENUNCIAR_EXPEDIENT("ERROR", "No s'ha pogut desistit/renunciat l'expedient"),

	OK_REGISTRAR_EXPEDIENT("OK", "Expedient registrat correctament"),

	ERROR_REGISTRAR_EXPEDIENT("ERROR", "No s'ha pogut registrar l'expedient"),

	OK_VALIDAR_EXPEDIENT("OK", "Expedient validat correctament"),

	ERROR_VALIDAR_EXPEDIENT("ERROR", "No s'ha pogut validar l'expedient");

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
