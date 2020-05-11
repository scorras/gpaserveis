package es.bcn.gpa.gpaserveis.web.rest.controller.utils.enums;

/**
 * The Enum ErrorPrincipal.
 */
public enum ErrorPrincipal {

	/* Generic */
	ERROR_GENERIC("9999", "S'ha produït una incidència: "),

	/* Unitats */
	ERROR_UNITATS_NOT_FOUND("1001", "No s'ha trobat la unitat gestora"),

	ERROR_UNITATS_NOT_IN_PROCEDIMENT("1002", "La unitat gestora indicada no està associada al procediment"),

	ERROR_UNITATS_NOT_VIGENT("1003", "La unitat gestora indicada no està vigent"),

	ERROR_UNITATS_ASSIGNADA("1004", "La unitat gestora indicada ja està assignada a l'expedient"),

	ERROR_UNITATS_CONVIDADA_ASSIGNADA("1005", "La unitat gestora convidada indicada ja està assignada a l'expedient"),

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

	ERROR_EXPEDIENTS_TRANSICION_ESTAT_NOT_VALID("3017", "No existeix transició de canvi d'estat vàlida per a aquesta acció"),

	ERROR_SOLLICITUDS_NOT_FOUND("3018", "No s'ha trobat la sol·licitud"),

	ERROR_SOLLICITUDS_REGISTRADA("3019", "La sol·licitud ja està registrada"),

	ERROR_SOLLICITUDS_TIPUS_NOT_VALID("3020", "El tipus de la sol·licitud no és vàlid"),

	ERROR_SOLLICITUDS_HI_HA_ESBORRANY("3021", "Hi ha sol·licituds del mateix tipus en estat esborrador"),

	ERROR_SOLLICITUDS_DADES_OPERACIO_APO("3022", "No és possible actualitzar les dades d'operació a una sol·licitud d'aportació."),

	ERROR_EXPEDIENTS_PERSONA_INTERESADA_RELACIO("3023",
			"Les persones interessades només poden tenir relació com a sol·licitant o representant"),

	ERROR_EXPEDIENTS_PERSONA_IMPLICADA_RELACIO("3024", "Les persones implicades només poden tenir relació com a testimoni o altres"),

	ERROR_EXPEDIENTS_PERSONA_LOGUEADA_NOT_FOUND("3025", "No s'ha trobat la persona autenticada en l'expedient"),

	ERROR_EXPEDIENTS_PERSONA_LOGUEADA_NOT_PERMIS("3026",
			"La persona autenticada no té permisos per a realitzar tràmits OVT en l'expedient"),

	ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT("3027",
			"No s'han trobat tipus de relació definits en el procediment associat a l'expedient"),

	ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES("3028",
			"S'ha d'especificar un tipus de relació per a les terceres persones implicades en l'expedient"),

	ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT_NOT_FOUND("3029",
			"El tipus de relació per a les terceres persones implicades ha d'existir en el procediment al qual està associat a l'expedient"),

	ERROR_EXPEDIENTS_RELACIO_TERCERES_PERSONES_PROCEDIMENT_VISIBILITAT("3030",
			"L'usuari autenticat no té habilitada la visibilitat per a realitzar modificacions sobre alguns de les dades d'operació especificats en la petició"),

	ERROR_EXPEDIENTS_DADES_OPERACIO_PROCEDIMENT_VISIBILITAT_PORTAL("3031",
			"La dada d'operació que es vol actualitzar no té configurada la visibilitat des de portal"),

	ERROR_EXPEDIENTS_DADES_OPERACIO_PROCEDIMENT_CRITICITAT("3032",
			"El nivell de visibilitat definit per a la persona autenticada no permet modificar les dades d'operació indicats en l'operació, la criticitat de la qual és alta"),

	ERROR_EXPEDIENTS_SOLLICITANT_OBLIGATORI("3033", "El sol·licitant és obligatori"),

	ERROR_EXPEDIENTS_DOC_ENTRADA_VISIBILITAT_PORTAL("3034",
			"La documentació que es vol actualitzar no té configurada la visibilitat des de portal"),

	ERROR_EXPEDIENTS_DOC_ENTRADA_CRITICITAT("3035",
			"El nivell de visibilitat definit per a la persona autenticada no permet operar sobre el document indicat en l'operació"),

	/* Documents */
	ERROR_DOCUMENTS_NOT_FOUND("4001", "No s'ha trobat el document: "),

	ERROR_DOCUMENTS_NOT_IN_EXPEDIENT("4002", "El document indicat no està associat a l'expedient: "),

	ERROR_CONFIGURACIO_DOCUMENTACIO_NOT_IN_EXPEDIENT("4003", "La configuració de documentació indicada no està associada a l'expedient: "),

	ERROR_CONFIGURACIO_DOCUMENTACIO_REQUERIMENT_NOT_AVAILABLE("4004",
			"La configuració de documentació no està disponible per a ser afegida al requeriment: "),

	ERROR_DOCUMENTS_UPLOAD_DECLARACIO_RESPONSABLE_NOT_AVAILABLE("4005", "No és possible pujar un fitxer a una declaració responsable"),

	ERROR_DOCUMENTS_EXPEDIENTS_NO_SIGNATS("4006", "Els documents associats a l'expedient no estan signats"),

	ERROR_DOCUMENTS_EMMAGATZEMAR_FITXER("4007", "No s'ha pogut emmagatzemar el fitxer"),

	ERROR_ENTRADA_DOCUMENTS_UPLOAD("4008", "No s'ha rebut arxiu per a pujar ni identificador de gestor documental per a actualitzar"),

	ERROR_DOCUMENTS_ORIGEN_EXTERN("4009", "No pot esborrar documents d'origen extern"),

	ERROR_DOCUMENTS_NOT_IN_SOLLICITUD("4010", "El document indicat no està associat a la sol·licitud"),

	ERROR_DOCUMENTS_NOT_SIGNAT("4011", "El document indicat no té un registre de signatura"),

	ERROR_NUMERO_DOCUMENTS_SIGNAR("4012", "La modalitat de signatura indicada no admet més d'un document"),

	ERROR_TOKEN_JWT_SIGNAR_VALID("4013", "El format de el token de Valid no és correcte"),

	/* Integracions */
	ERROR_ARIADNA("5001", ""),

	ERROR_CATALEG("5002", ""),

	ERROR_CTRLUSER("5003", ""),

	ERROR_DIGITALITZACIO("5004", ""),

	ERROR_GEOREST("5005", ""),

	ERROR_NOTIFICADOR("5006", ""),

	ERROR_OPENTEXT("5007", ""),

	ERROR_PDFGESTOR("5008", ""),

	ERROR_PORTASIG("5009", ""),

	ERROR_SIGNATURES("5010", ""),

	ERROR_DOCUMENTUM("5011", ""),

	ERROR_SERVEI_INTEROPERABILITAT("5012", "");

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
