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

	ERROR_VALIDAR_EXPEDIENT("ERROR", "No s'ha pogut validar l'expedient"),

	OK_PAUSAR_EXPEDIENT("OK", "Expedient pausat correctament"),

	ERROR_PAUSAR_EXPEDIENT("ERROR", "No s'ha pogut pausar l'expedient"),

	OK_REACTIVAR_EXPEDIENT("OK", "Expedient reactivat correctament"),

	ERROR_REACTIVAR_EXPEDIENT("ERROR", "No s'ha pogut reactivar l'expedient"),

	OK_ARXIVAR_EXPEDIENT("OK", "Expedient arxivat correctament"),

	ERROR_ARXIVAR_EXPEDIENT("ERROR", "No s'ha pogut arxivar l'expedient"),

	OK_RETORNAR_TRAMITACIO_EXPEDIENT("OK", "Expedient retornat a tramitació correctament"),

	ERROR_RETORNAR_TRAMITACIO_EXPEDIENT("ERROR", "No s'ha pogut retornar a tramitació l'expedient"),

	OK_PROPOSAR_RESOLUCIO_EXPEDIENT("OK", "Expedient proposat a resolució correctament"),

	ERROR_PROPOSAR_RESOLUCIO_EXPEDIENT("ERROR", "No s'ha pogut proposar a resolució l'expedient"),

	OK_TANCAR_EXPEDIENT("OK", "Expedient tancat correctament"),

	ERROR_TANCAR_EXPEDIENT("ERROR", "No s'ha pogut tancar l'expedient"),

	OK_TORNAR_ENRERE_EXPEDIENT("OK", "Expedient tornat enrere correctament"),

	ERROR_TORNAR_ENRERE_EXPEDIENT("ERROR", "No s'ha pogut tornar enrere l'expedient"),

	OK_VALIDAR_DOCUMENT_EXPEDIENT("OK", "Document validat correctament"),

	ERROR_VALIDAR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut validar el document"),

	OK_REBUTJAR_DOCUMENT_EXPEDIENT("OK", "Document rebutjat correctament"),

	ERROR_REBUTJAR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut rebutjar el document"),

	OK_CONVIDAR_TRAMITAR_EXPEDIENT("OK", "Expedient convidat a tramitar correctament"),

	ERROR_CONVIDAR_TRAMITAR_EXPEDIENT("ERROR", "No s'ha pogut convidar a tramitar l'expedient"),

	OK_CANVIAR_UNITAT_GESTORA_EXPEDIENT("OK", "Unitat gestora de l'expedient canviada correctament"),

	ERROR_CANVIAR_UNITAT_GESTORA_EXPEDIENT("ERROR", "No s'ha pogut canviar la unitat gestora de l'expedient"),

	OK_INCORPORAR_NOU_DOCUMENT_EXPEDIENT("OK", "Nou document incorporat a l'expedient correctament"),

	ERROR_INCORPORAR_NOU_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut incorporar el nou document a l'expedient"),

	OK_SIGNAR_DOCUMENT("OK", "Acció realitzada correctament"),

	ERROR_SIGNAR_DOCUMENT("OK", "No s'ha pogut signar el document"),

	OK_COMPLETAR_DOCUMENT_EXPEDIENT("OK", "Nou document completat correctament"),

	ERROR_COMPLETAR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut completar el document"),

	OK_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT("OK", "Declaració responsable presentada per l'expedient correctament"),

	ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT("ERROR", "No s'ha pogut presentar la declaració responsable per a l'expedient"),

	OK_PREPARAR_REQUERIMENT_EXPEDIENT("OK", "Requeriment preparat per a l'expedient correctament"),

	ERROR_PREPARAR_REQUERIMENT_EXPEDIENT("ERROR", "No s'ha pogut preparar el requeriment per a l'expedient"),

	OK_VALIDAR_DOCUMENT("OK", "Acció realitzada correctament"),

	ERROR_VALIDAR_DOCUMENT("OK", "No s'ha pogut validar el document"),

	OK_ACUMULAR_EXPEDIENT("OK", "Expedient acumulat correctament"),

	ERROR_ACUMULAR_EXPEDIENT("ERROR", "No s'ha pogut acumular l'expedient"),

	OK_ACCES_EXPEDIENT("OK", "Accés a l'expedient donat correctament"),

	ERROR_ACCES_EXPEDIENT("ERROR", "No s'ha pogut donar accés a l'expedient"),

	OK_REGISTRAR_COMUNICACIO_EXPEDIENT("OK", "Comunicació de l'expedient registrada correctament"),

	ERROR_REGISTRAR_COMUNICACIO_EXPEDIENT("ERROR", "No s'ha pogut registrar la comunicació de l'expedient"),

	OK_NOTIFICAR_EXPEDIENT("OK", "Notificació enviada correctament"),

	ERROR_NOTIFICAR_EXPEDIENT("ERROR", "No s'ha pogut enviar la notificació de l'expedient"),

	OK_DOCUMENT_SIGNAT_EXPEDIENT("OK", "Documentació de l'expedient signada correctament"),

	ERROR_DOCUMENT_SIGNAT_EXPEDIENT("ERROR", "No s'ha pogut donar per bona la signatura de la documentació de l'expedient"),

	OK_DOCUMENT_DIGITALITZAT_EXPEDIENT("OK", "Document digitalitzat correctament"),

	ERROR_DOCUMENT_DIGITALITZAT_EXPEDIENT("ERROR", "No s'ha pogut digitalitzar el document"),

	OK_OBTENIR_DOCUMENT_INTRAOPERABILITAT("OK", "Document obtingut correctament"),

	ERROR_OBTENIR_DOCUMENT_INTRAOPERABILITAT("ERROR", "No s'ha pogut obtenir el document per intraoperabilitat"),

	OK_OBTENIR_EXPEDIENT("OK", "Expedient obtingut correctament"),

	ERROR_OBTENIR_EXPEDIENT("ERROR", "No s'ha pogut obtenir el expedient"),

	OK_REVISAR_EXPEDIENT("OK", "Expedient revisat correctament"),

	ERROR_REVISAR_EXPEDIENT("ERROR", "No s'ha pogut revisar l'expedient"),

	OK_RECURS_EXPEDIENT("OK", "Recurs d'Expedient creat correctament"),

	ERROR_RECURS_EXPEDIENT("ERROR", "No s'ha pogut crear el recurs d'expedient");

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
