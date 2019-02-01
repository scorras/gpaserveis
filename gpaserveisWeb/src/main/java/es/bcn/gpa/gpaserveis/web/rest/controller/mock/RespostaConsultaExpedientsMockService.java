package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsIdentitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.HistoricsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DadesAtributsExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.DocumentsExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.ExpedientsConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients.RespostaConsultaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;

public class RespostaConsultaExpedientsMockService {

	public RespostaConsultaExpedientsRDTO getRespostaConsultaExpedients(BigDecimal idExpedient) {

		RespostaConsultaExpedientsRDTO resposta = new RespostaConsultaExpedientsRDTO();

		ExpedientsConsultaRDTO expedient = new ExpedientsConsultaRDTO();

		expedient.setId(idExpedient);
		expedient.setCodi("CODI");
		expedient.setPermetAportacio(true);
		expedient.setPermetEsmena(true);
		expedient.setPermetAlegacio(false);
		expedient.setDataPresentacio("01/10/2018 14:00:02");
		expedient.setDataModificacio("01/10/2018 14:00:02");
		expedient.setUnitatGestora(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"));
		expedient.setEstat("EN_REVISIO");

		expedient.setHistorics(Arrays.asList(HistoricsRDTOFactory.create("EN_REVISIO", "05/10/2018 20:05:47", "Expedient en revisió"),
		        HistoricsRDTOFactory.create("PENDENT_SUBSANACIO", "03/10/2018 19:44:58", "Expedient en espera de subsanació"),
		        HistoricsRDTOFactory.create("EN_REVISIO", "02/10/2018 14:13:28", "Expedient en revisió"),
		        HistoricsRDTOFactory.create("EN_PREPARACIO", "01/10/2018 17:30:52", "Expedient en preparació")));

		expedient.setProcediment(ProcedimentsRDTOFactory.create(new BigDecimal("1"), "PROC-01", "Procediment 1",
		        UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		        Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")),
		        "OR-1", Arrays.asList(new String[] { "OFICI", "ADMINISTRACIO" }), "1", "EN_ELABORACIO"));

		expedient.setRegistre(RegistreRDTOFactory.create("0801930008-1-2018-0002094-1", "01/10/2018 14:00:02", PersonesRDTOFactory
		        .create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2", DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES"))));

		expedient.setSolicitant(PersonesRDTOFactory.create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2",
		        DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES")));

		expedient.setRepresentant(PersonesRDTOFactory.create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2",
		        DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES")));

		expedient.setDocuments(Arrays.asList(DocumentsExpedientsRDTOFactory.create(new BigDecimal("1"), "SOLC", "FORM_DOC_SOLC.pdf"),
		        DocumentsExpedientsRDTOFactory.create(new BigDecimal("2"), "NIF", "FORM_DOC_NIF.pdf")));

		expedient.setAtributs(Arrays.asList(DadesAtributsExpedientsRDTOFactory.create(new BigDecimal("1"), "ATTR1", "Valor Atribut 1"),
		        DadesAtributsExpedientsRDTOFactory.create(new BigDecimal("2"), "ATTR2", "Valor Atribut 2"),
		        DadesAtributsExpedientsRDTOFactory.create(new BigDecimal("3"), "ATTR3", "Valor Atribut 3")));

		resposta.setExpedient(expedient);
		return resposta;
	}

	private static class UnitatsRDTOFactory {

		private static UnitatGestoraRDTO create(String codi, String descripcio) {

			UnitatGestoraRDTO unitatRDTO = new UnitatGestoraRDTO();

			unitatRDTO.setCodi(codi);
			unitatRDTO.setDescripcio(descripcio);

			return unitatRDTO;
		}
	}

	private static class HistoricsRDTOFactory {

		private static HistoricsRDTO create(String estat, String dataCreacio, String descripcio) {

			HistoricsRDTO historicsRDTO = new HistoricsRDTO();

			historicsRDTO.setEstat(estat);
			historicsRDTO.setDataCreacio(dataCreacio);
			historicsRDTO.setDescripcio(descripcio);

			return historicsRDTO;
		}
	}

	private static class ProcedimentsRDTOFactory {

		private static ProcedimentsConsultaRDTO create(BigDecimal id, String codi, String descripcio, UnitatGestoraRDTO ugr,
		        List<UnitatGestoraRDTO> ugo, String organResolutori, List<String> inici, String versio, String estat) {

			ProcedimentsConsultaRDTO procedimentRDTO = new ProcedimentsConsultaRDTO();

			procedimentRDTO.setId(id);
			procedimentRDTO.setCodi(codi);
			procedimentRDTO.setDescripcio(descripcio);
			procedimentRDTO.setUgr(ugr);
			procedimentRDTO.setUgo(ugo);
			procedimentRDTO.setOrganResolutori(organResolutori);
			procedimentRDTO.setInici(inici);
			procedimentRDTO.setVersio(versio);
			procedimentRDTO.setEstat(estat);

			return procedimentRDTO;
		}
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

	private static class DocumentsExpedientsRDTOFactory {

		private static DocumentsExpedientsRDTO create(BigDecimal id, String codi, String nom) {

			DocumentsExpedientsRDTO documentsExpedientsRDTO = new DocumentsExpedientsRDTO();

			documentsExpedientsRDTO.setId(id);
			documentsExpedientsRDTO.setCodi(codi);
			documentsExpedientsRDTO.setNom(nom);

			return documentsExpedientsRDTO;
		}
	}

	private static class DadesAtributsExpedientsRDTOFactory {

		private static DadesAtributsExpedientsRDTO create(BigDecimal id, String codi, String valor) {

			DadesAtributsExpedientsRDTO atributsExpedientsRDTO = new DadesAtributsExpedientsRDTO();

			atributsExpedientsRDTO.setId(id);
			atributsExpedientsRDTO.setCodi(codi);
			atributsExpedientsRDTO.setValor(valor);

			return atributsExpedientsRDTO;
		}
	}

}
