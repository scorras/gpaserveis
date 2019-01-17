package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsIdentitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.registrar.solicitud.RespostaRegistrarExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.registrar.solicitud.RespostaRegistrarSolicitudsRDTO;

public class RespostaRegistrarSolicitudMockService {

	public RespostaRegistrarSolicitudsRDTO getRespostaRespostaRegistrarSolicituds(BigDecimal idExpedient) {

		RespostaRegistrarSolicitudsRDTO resposta = new RespostaRegistrarSolicitudsRDTO();

		ResultatRespostaDTO resultat = new ResultatRespostaDTO();

		resultat.setCodi("OK");
		resultat.setDescripcio("Expedient registrat correctament");

		RespostaRegistrarExpedientsRDTO expedient = new RespostaRegistrarExpedientsRDTO();
		expedient.setId(idExpedient);

		expedient.setRegistre(RegistreRDTOFactory.create("0801930008-1-2018-0002094-1", "01/10/2018 14:00:02", PersonesRDTOFactory
		        .create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2", DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES"))));

		resposta.setResultat(resultat);
		resposta.setExpedient(expedient);

		return resposta;
	}

	private static class PersonesRDTOFactory {

		private static PersonesRDTO create(BigDecimal id, String tipusPersona, String nomRaoSocial, String cognom1, String cognom2,
		        DocumentsIdentitatRDTO documentIndentitat) {

			PersonesRDTO personaRDTO = new PersonesRDTO();

			personaRDTO.setId(id);
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

			registreRDTO.setCodi(codi);
			registreRDTO.setDataRegistre(dataRegistre);
			registreRDTO.setPersona(persona);

			return registreRDTO;
		}
	}

}
