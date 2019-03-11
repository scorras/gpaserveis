package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsIdentitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.DocumentAportatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar.RespostaAportarDocumentacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar.RespostaEsborrarDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir.RespostaSubstituirDocumentRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.abandonar.RespostaAbandonarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.acces.RespostaAccesExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.comunicacio.RespostaRegistrarComunicacioExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena.RespostaEsmenarExpedientRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.registrar.RespostaRegistrarExpedientRDTO;

public class RespostaAccionsMockService {

	public RespostaRegistrarExpedientRDTO getRespostaRegistrarExpedientRDTO(BigDecimal idExpedient) {
		RespostaRegistrarExpedientRDTO resposta = new RespostaRegistrarExpedientRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		resposta.setRegistre(RegistreRDTOFactory.create("0801930008-1-2018-0002094-1", "01/10/2018 14:00:02", PersonesRDTOFactory
		        .create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2", DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES"))));
		return resposta;
	}
	
	
	public RespostaAportarDocumentacioRDTO getRespostaAportarDocumentacioRDTO(BigDecimal idExpedient) {
		RespostaAportarDocumentacioRDTO resposta = new RespostaAportarDocumentacioRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		resposta.setRegistre(RegistreRDTOFactory.create("0801930008-1-2018-0002094-1", "01/10/2018 14:00:02", PersonesRDTOFactory
		        .create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2", DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES"))));
		return resposta;
	}
	
	public RespostaSubstituirDocumentRDTO getRespostaSubstituirDocumentRDTO(BigDecimal idExpedient) {
		RespostaSubstituirDocumentRDTO resposta = new RespostaSubstituirDocumentRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		return resposta;
	}
	
	public RespostaEsborrarDocumentRDTO getRespostaEsborrarDocumentRDTO(BigDecimal idExpedient) {
		RespostaEsborrarDocumentRDTO resposta = new RespostaEsborrarDocumentRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		return resposta;
	}
	
	
	public RespostaEsmenarExpedientRDTO getRespostaEsmenarExpedientRDTO(BigDecimal idExpedient) {
		RespostaEsmenarExpedientRDTO resposta = new RespostaEsmenarExpedientRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		return resposta;
	}
	
	public RespostaAbandonarExpedientRDTO getRespostaAbandonarExpedientRDTO(BigDecimal idExpedient) {
		RespostaAbandonarExpedientRDTO resposta = new RespostaAbandonarExpedientRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		return resposta;
	}
	
	public RespostaAccesExpedientRDTO getRespostaAccesExpedientRDTO(BigDecimal idExpedient) {
		RespostaAccesExpedientRDTO resposta = new RespostaAccesExpedientRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		return resposta;
	}
	
	public RespostaRegistrarComunicacioExpedientRDTO getRespostaRegistrarComunicacioExpedientRDTO(BigDecimal idExpedient) {
		RespostaRegistrarComunicacioExpedientRDTO resposta = new RespostaRegistrarComunicacioExpedientRDTO();
		resposta.setResultat(getRespostaOK());
		resposta.setExpedient(getExpedientAccioRDTO(idExpedient));
		return resposta;
	}
	
	
	private static ResultatRespostaDTO getRespostaOK(){
		ResultatRespostaDTO resultat = new ResultatRespostaDTO();
		resultat.setCodi("OK");
		resultat.setDescripcio("Operació finalitzada correctament");
		return resultat;
	}
	
	
	private static ExpedientAccioRDTO getExpedientAccioRDTO(BigDecimal idExpedient){
		ExpedientAccioRDTO expedient = new ExpedientAccioRDTO();
		expedient.setId(idExpedient);
		expedient.setCodi("CODI-EXP-0000001");
		return expedient;
	}

	private static class PersonesRDTOFactory {

		private static PersonesRDTO create(BigDecimal id, String tipusPersona, String nomRaoSocial, String cognom1, String cognom2,
		        DocumentsIdentitatRDTO documentIndentitat) {

			PersonesRDTO personaRDTO = new PersonesRDTO();

			personaRDTO.setTipusPersona(tipusPersona);
			personaRDTO.setNomRaoSocial(nomRaoSocial);
			personaRDTO.setCognom1(cognom1);
			personaRDTO.setCognom2(cognom2);
			personaRDTO.setDocumentIndentitat(documentIndentitat);

			return personaRDTO;
		}
	}

	private static class DocumentIdentitatRDTOFactory {

		private static DocumentsIdentitatRDTO create(String tipusDocument, String numeroDocument, String pais) {

			DocumentsIdentitatRDTO documentIndentitatRDTO = new DocumentsIdentitatRDTO();
			documentIndentitatRDTO.setTipusDocument(tipusDocument);
			documentIndentitatRDTO.setNumeroDocument(numeroDocument);
			documentIndentitatRDTO.setPais(pais);

			return documentIndentitatRDTO;
		}
	}

	private static class RegistreRDTOFactory {

		private static RegistreRDTO create(String codi, String dataRegistre, PersonesRDTO persona) {

			RegistreRDTO registreRDTO = new RegistreRDTO();

			registreRDTO.setNumRegistre(codi);
			registreRDTO.setDataRegistre(dataRegistre);
			registreRDTO.setPersona(persona);

			return registreRDTO;
		}
	}
	
	private static class DocumentAportatAccioRDTODTOFactory {

		private static DocumentAportatAccioRDTO create(BigDecimal id, String nom) {

			DocumentAportatAccioRDTO documentAportatAccioRDTO = new DocumentAportatAccioRDTO();

			documentAportatAccioRDTO.setId(id);
			documentAportatAccioRDTO.setNom(nom);

			return documentAportatAccioRDTO;
		}
	}	

}
