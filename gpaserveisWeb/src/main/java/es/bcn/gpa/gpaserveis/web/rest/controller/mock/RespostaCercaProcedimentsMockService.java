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
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("1"), "PROC-01", "Procediment 1", UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")), "OR-1", Arrays.asList(new String[]{"OFICI","ADMINISTRACIO"}), "1", "EN_ELABORACIO"));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("2"), "PROC-02", "Procediment 2", UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), null, null,  Arrays.asList(new String[]{"OFICI","ADMINISTRACIO"}), "1", "EN_ELABORACIO"));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("3"), "PROC-03", "Procediment 3", UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2"),  Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2")), null,  Arrays.asList(new String[]{"SOLICITUD"}), "1", "PUBLICAT"));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("4"), "PROC-04", "Procediment 4", UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"), null, "OR-2",  Arrays.asList(new String[]{"OFICI","ADMINISTRACIO"}), "1", "EN_ELABORACIO"));
		data.add(ProcedimentsRDTOFactory.create(new BigDecimal("5"), "PROC-05", "Procediment 5", UnitatsRDTOFactory.create("UG3", "Unitat Gestora 3"),  Arrays.asList(UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),UnitatsRDTOFactory.create("UG3", "Unitat Gestora 3")), null,  Arrays.asList(new String[]{"ALTRES"}), "1", "PUBLICAT"));
	}

	
	
	public RespostaCercaProcedimentsRDTO getRespostaCercaProcediments() {
		
		RespostaCercaProcedimentsRDTO resposta = new RespostaCercaProcedimentsRDTO();
		resposta.setData(data);
		
		PaginacioRDTO paginacio = new PaginacioRDTO();
		paginacio.setTotalPagines(1);
		paginacio.setTotalResultats(data.size());
		paginacio.setNumeroPagina(1);
		paginacio.setResultatsPerPagina(data.size());
		resposta.setPaginacio(paginacio);
		
		return resposta;
	}
	
	
	
	private static class ProcedimentsRDTOFactory {
		
		private static ProcedimentsCercaRDTO create(
				BigDecimal id, 
				String codi, 
				String descripcio,
				UnitatGestoraRDTO ugr,
				List<UnitatGestoraRDTO> ugo,
				String organResolutori,
				List<String> inici,
				String versio,
				String estat) {
			
			ProcedimentsCercaRDTO procedimentRDTO = new ProcedimentsCercaRDTO();
			
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
	
	
	private static class UnitatsRDTOFactory {
		
		private static UnitatGestoraRDTO create(
				String codi, 
				String descripcio
				) {
			
			UnitatGestoraRDTO unitatRDTO = new UnitatGestoraRDTO();
			
			unitatRDTO.setCodi(codi);
			unitatRDTO.setDescripcio(descripcio);
			
			return unitatRDTO;
	    }
	}	
}


