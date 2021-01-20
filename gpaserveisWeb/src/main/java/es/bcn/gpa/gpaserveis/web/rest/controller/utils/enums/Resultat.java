package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums;

/**
 * The Enum Resultat.
 */
public enum Resultat {

	OK_CREAR_SOLLICITUD("OK", "Sol·licitud creada correctament"),

	ERROR_CREAR_SOLLICITUD("ERROR", "No s'ha pogut crear la sol·licitud"),

	OK_CREAR_EXPEDIENT("OK", "Expedient creat correctament"),

	ERROR_CREAR_EXPEDIENT("ERROR", "No s'ha pogut crear l'expedient"),

	OK_ACTUALITZAR_EXPEDIENT("OK", "Expedient actualitzat correctament"),

	ERROR_ACTUALITZAR_EXPEDIENT("ERROR", "No s'ha pogut actualitzar l'expedient"),

	OK_ACTUALITZAR_SOLLICITUD("OK", "Sol·licitud actualitzat correctament"),

	ERROR_ACTUALITZAR_SOLLICITUD("ERROR", "No s'ha pogut actualitzar la sol·licitud"),

	OK_APORTAR_DOCUMENTACIO("OK", "Documentació aportat correctament"),

	ERROR_APORTAR_DOCUMENTACIO("ERROR", "No s'ha pogut aportar la documentació"),

	OK_SUBSTITUIR_DOCUMENT("OK", "Document actualitzat correctament"),

	ERROR_SUBSTITUIR_DOCUMENT("ERROR", "No s'ha pogut actualitzar el document"),

	OK_ESBORRAR_DOCUMENT("OK", "Document donat de baixa correctament"),

	ERROR_ESBORRAR_DOCUMENT("ERROR", "No s'ha pogut donar de baixa el document"),

	OK_UPLOAD_DOCUMENT("OK", "Document pujat correctament"),

	ERROR_UPLOAD_DOCUMENT("ERROR", "No s'ha pogut pujar el document"),

	OK_DESCARREGAR_DOCUMENT("OK", "Document descarregat correctament"),

	ERROR_DESCARREGAR_DOCUMENT("ERROR", "No s'ha pogut descarregar el document"),

	OK_ESMENAR_EXPEDIENT("OK", "Requeriments de l’expedient incorporats correctament"),

	ERROR_ESMENAR_EXPEDIENT("ERROR", "No s'han pogut incorporar els requeriments a l'expedient"),

	OK_DESISTIR_RENUNCIAR_EXPEDIENT("OK", "Expedient desistit/renunciat correctament"),

	ERROR_DESISTIR_RENUNCIAR_EXPEDIENT("ERROR", "No s'ha pogut desistit/renunciat l'expedient"),

	OK_REGISTRAR_SOLLICITUD("OK", "Sol·licitud registrada correctament"),

	OK_REGISTRAR_EXPEDIENT("OK", "Expedient registrat correctament"),

	ERROR_REGISTRAR_SOLLICITUD("ERROR", "No s'ha pogut registrar la sol·licitud"),

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

	ERROR_SIGNAR_DOCUMENT("ERROR", "No s'ha pogut signar el document"),

	OK_PREPARAR_SIGNATURA_CRIPTOGRAFICA_DOCUMENT("OK", "Acció realitzada correctament"),

	ERROR_PREPARAR_SIGNATURA_CRIPTOGRAFICA_DOCUMENT("ERROR", "No s'ha pogut preparar la signatura dels documents"),

	OK_COMPLETAR_DOCUMENT_EXPEDIENT("OK", "Nou document completat correctament"),

	ERROR_COMPLETAR_DOCUMENT_EXPEDIENT("ERROR", "No s'ha pogut completar el document"),

	OK_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT("OK", "Declaració responsable presentada per l'expedient correctament"),

	ERROR_PRESENTAR_DECLARACIO_RESPONSABLE_EXPEDIENT("ERROR", "No s'ha pogut presentar la declaració responsable per a l'expedient"),

	OK_PREPARAR_REQUERIMENT_EXPEDIENT("OK", "Requeriment preparat per a l'expedient correctament"),

	ERROR_PREPARAR_REQUERIMENT_EXPEDIENT("ERROR", "No s'ha pogut preparar el requeriment per a l'expedient"),

	OK_VALIDAR_DOCUMENT("OK", "Acció realitzada correctament"),

	ERROR_VALIDAR_DOCUMENT("ERROR", "No s'ha pogut validar el document"),

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

	OK_OBTENIR_PER_INTEROPERABILITAT("OK", "S'ha obtingut la resposta del servei per interoperabilitat correctament"),

	ERROR_OBTENIR_PER_INTEROPERABILITAT("ERROR", "No s'ha pogut obtenir la resposta del servei per interoperabilitat"),

	OK_OBTENIR_EXPEDIENT("OK", "Expedient obtingut correctament"),

	ERROR_OBTENIR_EXPEDIENT("ERROR", "No s'ha pogut obtenir el expedient"),

	OK_REVISAR_EXPEDIENT("OK", "Expedient revisat correctament"),

	ERROR_REVISAR_EXPEDIENT("ERROR", "No s'ha pogut crear l'expedient"),

	OK_RECURS_EXPEDIENT("OK", "Recurs d'Expedient creat correctament"),

	ERROR_RECURS_EXPEDIENT("ERROR", "No s'ha pogut crear el recurs d'expedient"),

	OK_PUBLICAR_PER_A_INFORMACIO_PUBLICA("OK", "Informació publicada correctament"),

	ERROR_PUBLICAR_PER_A_INFORMACIO_PUBLICA("ERROR", "No s'ha pogut publicar la informació"),

	OK_ANOTAR_OPERACIO_COMPTABLE("OK", "L'operació comptable s'ha anotat correctament"),

	ERROR_ANOTAR_OPERACIO_COMPTABLE("ERROR", "No s'ha pogut anotar l'operació comptable"),

	OK_INSCRIURE_EN_REGISTRE("OK", "S'ha inscrit l'expedient en un registre manualment"),

	ERROR_INSCRIURE_EN_REGISTRE("ERROR", "No s'ha pogut inscriure en el registre"),

	OK_ACTUALITZAR_ID_GESTOR_DOCUMENTAL_EXPEDIENT("OK", "Identificador del gestor documental actualitzat correctament"),

	ERROR_ACTUALITZAR_ID_GESTOR_DOCUMENTAL_EXPEDIENT("ERROR", "No s'ha pogut actualitzar l'identificador del gestor documental"),

	OK_ESTAT_DOCUMENT_DIGITALITZACIO_EXPEDIENT("OK", "Estat de digitalització d'un document obtingut correctament"),

	ERROR_ESTAT_DOCUMENT_DIGITALITZACIO_EXPEDIENT("ERROR", "No s'ha pogut obtenir l'estat de digitalització del document"),

	OK_DESCARREGAR_DOCUMENT_EXPEDIENT_SIGNAT("OK", "Document signat descarregat correctament"),

	ERROR_DESCARREGAR_DOCUMENT_EXPEDIENT_SIGNAT("ERROR", "No s'ha pogut descarregar el document signat"),

	OK_ESBORRAR_TERCERA_PERSONA("OK", "Tercera persona donada de baixa correctament"),

	ERROR_ESBORRAR_TERCERA_PERSONA("ERROR", "No s'ha pogut donar de baixa la tercera persona"),

	OK_INCORPORAR_TERCERA_PERSONA_EXPEDIENT("OK", "Tercera persona incorporada correctament"),

	ERROR_INCORPORAR_TERCERA_PERSONA_EXPEDIENT("ERROR", "No s'ha pogut incorporar la tercera persona a l'expedient"),

	OK_ACTUALITZAR_TERCERA_PERSONA_EXPEDIENT("OK", "Tercera persona actualitzada correctament"),

	ERROR_ACTUALITZAR_TERCERA_PERSONA_EXPEDIENT("ERROR", "No s'ha pogut actualitzar la tercera persona de l'expedient"),

	OK_INCORPORAR_TERCERA_PERSONA_SOLLICITUD("OK", "Tercera persona incorporada correctament"),

	ERROR_INCORPORAR_TERCERA_PERSONA_SOLLICITUD("ERROR", "No s'ha pogut incorporar la tercera persona a la sol·licitud"),

	OK_ACTUALITZAR_TERCERA_PERSONA_SOLLICITUD("OK", "Tercera persona actualitzada correctament"),

	ERROR_ACTUALITZAR_TERCERA_PERSONA_SOLLICITUD("ERROR", "No s'ha pogut actualitzar la tercera persona de la sol·licitud"),

	OK_ESBORRAR_TERCERA_PERSONA_SOLLICITUD("OK", "Tercera persona donada de baixa correctament"),

	ERROR_ESBORRAR_TERCERA_PERSONA_SOLLICITUD("ERROR", "No s'ha pogut donar de baixa la tercera persona de la sol·licitud");

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
