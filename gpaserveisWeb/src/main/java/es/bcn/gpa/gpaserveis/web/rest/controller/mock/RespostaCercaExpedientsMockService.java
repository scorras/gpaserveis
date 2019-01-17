package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsIdentitatRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.ExpedientsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients.RespostaCercaExpedientsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;

public class RespostaCercaExpedientsMockService {

	private List<ExpedientsCercaRDTO> data = Collections.emptyList();

	public void initialize() {
		data = new ArrayList<>();
		data.add(ExpedientsRDTOFactory.create(new BigDecimal("1"), "PROC-01/2018/00001", "01/10/2018 14:00:02", "01/10/2018 14:00:02",
		        UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		        ProcedimentsRDTOFactory.create(new BigDecimal("1"), "PROC-01", "1", "Procediment 1", "Descripció Procediment 1",
		                UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		                Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		                        UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")),
		                "EN_ELABORACIO", "APLICACIO_DE_NEGOCI", "quiosc"),
		        "EN_ELABORACIO", PersonesRDTOFactory.create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2",
		                DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES"))));
		data.add(ExpedientsRDTOFactory.create(new BigDecimal("2"), "PROC-01/2018/00002", "01/10/2018 14:00:02", "01/10/2018 14:00:02",
		        UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		        ProcedimentsRDTOFactory.create(new BigDecimal("1"), "PROC-01", "1", "Procediment 1", "Descripció Procediment 1",
		                UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		                Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		                        UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")),
		                "EN_ELABORACIO", "APLICACIO_DE_NEGOCI", "quiosc"),
		        "EN_ELABORACIO", PersonesRDTOFactory.create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2",
		                DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES"))));
		data.add(ExpedientsRDTOFactory.create(new BigDecimal("3"), "PROC-01/2018/00003", "01/10/2018 14:00:02", "01/10/2018 14:00:02",
		        UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		        ProcedimentsRDTOFactory.create(new BigDecimal("1"), "PROC-01", "1", "Procediment 1", "Descripció Procediment 1",
		                UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		                Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		                        UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")),
		                "EN_ELABORACIO", "APLICACIO_DE_NEGOCI", "quiosc"),
		        "EN_ELABORACIO", PersonesRDTOFactory.create(null, "FISICA", "Nom", "Cognom 1", "Cognom 2",
		                DocumentIdentitatRDTOFactory.create("NIF", "00000000T", "ES"))));

	}

	public RespostaCercaExpedientsRDTO getRespostaCercaExpedients() {

		RespostaCercaExpedientsRDTO resposta = new RespostaCercaExpedientsRDTO();
		resposta.setData(data);

		PaginacioRDTO paginacio = new PaginacioRDTO();
		paginacio.setTotalPagines(1);
		paginacio.setTotalResultats(data.size());
		paginacio.setNumeroPagina(1);
		paginacio.setResultatsPerPagina(20);
		resposta.setPaginacio(paginacio);

		return resposta;
	}

	private static class ExpedientsRDTOFactory {

		private static ExpedientsCercaRDTO create(BigDecimal id, String codi, String dataPresentacio, String dataModificacio,
		        UnitatGestoraRDTO unitatGestora, ProcedimentsCercaRDTO procediment, String estat, PersonesRDTO solicitant) {

			ExpedientsCercaRDTO expedientRDTO = new ExpedientsCercaRDTO();

			expedientRDTO.setId(id);
			expedientRDTO.setCodi(codi);
			expedientRDTO.setDataPresentacio(dataPresentacio);
			expedientRDTO.setDataModificacio(dataModificacio);
			expedientRDTO.setUnitatGestora(unitatGestora);
			expedientRDTO.setProcediment(procediment);
			expedientRDTO.setEstat(estat);
			expedientRDTO.setSolicitant(solicitant);

			return expedientRDTO;
		}
	}

	private static class ProcedimentsRDTOFactory {

		private static ProcedimentsCercaRDTO create(BigDecimal id, String codi, String versio, String nom, String descripcio,
		        UnitatGestoraRDTO ugr, List<UnitatGestoraRDTO> ugo, String estat, String tramitador, String aplicacioNegoci) {

			ProcedimentsCercaRDTO procedimentRDTO = new ProcedimentsCercaRDTO();

			procedimentRDTO.setId(id);
			procedimentRDTO.setCodi(codi);
			procedimentRDTO.setVersio(versio);
			procedimentRDTO.setNom(nom);
			procedimentRDTO.setDescripcio(descripcio);
			procedimentRDTO.setUgr(ugr);
			procedimentRDTO.setUgo(ugo);
			procedimentRDTO.setEstat(estat);
			procedimentRDTO.setTramitador(tramitador);
			procedimentRDTO.setAplicacioNegoci(aplicacioNegoci);

			return procedimentRDTO;
		}
	}

	private static class UnitatsRDTOFactory {

		private static UnitatGestoraRDTO create(String nom, String descripcio) {

			UnitatGestoraRDTO unitatRDTO = new UnitatGestoraRDTO();

			unitatRDTO.setNom(nom);
			unitatRDTO.setDescripcio(descripcio);

			return unitatRDTO;
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
}
