package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.ProcedimentsCercaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments.RespostaCercaProcedimentsRDTO;

public class RespostaCercaProcedimentsMockService {

	private List<ProcedimentsCercaRDTO> data = Collections.emptyList();

	public void initialize() {
		data = new ArrayList<>();
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("1"), "PROC-01", "1", "Procediment 1", "Descripció Procediment 1",
		        UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
		        Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")),
		        "EN_ELABORACIO", "APLICACIO_DE_NEGOCI", "quiosc"));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("2"), "PROC-02", "1", "Procediment 2", "Descripció Procediment 2",
		        UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), null, "EN_ELABORACIO", "OGE", null));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("3"), "PROC-03", "1", "Procediment 3", "Descripció Procediment 3",
		        UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2"),
		        Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")),
		        "PUBLICAT", "APLICACIO_DE_NEGOCI", "quiosc"));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("4"), "PROC-04", "1", "Procediment 4", "Descripció Procediment 4",
		        UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), null, "EN_ELABORACIO", "OGE", null));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("5"), "PROC-05", "1", "Procediment 5", "Descripció Procediment 5",
		        UnitatsRDTOFactory.create("UG3", "Unitat Gestora 3"),
		        Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), UnitatsRDTOFactory.create("UG3", "Unitat Gestora 3")),
		        "PUBLICAT", "APLICACIO_DE_NEGOCI", "quiosc"));
	}

	public RespostaCercaProcedimentsRDTO getRespostaCercaProcediments() {

		RespostaCercaProcedimentsRDTO resposta = new RespostaCercaProcedimentsRDTO();
		resposta.setData(data);

		PaginacioRDTO paginacio = new PaginacioRDTO();
		paginacio.setTotalPagines(1);
		paginacio.setTotalResultats(data.size());
		paginacio.setNumeroPagina(1);
		paginacio.setResultatsPerPagina(20);
		resposta.setPaginacio(paginacio);

		return resposta;
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
}
