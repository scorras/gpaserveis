package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;
import java.util.Arrays;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.UnitatGestoraRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.DadesIdentificacioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TerminisDuracioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.ProcedimentsConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments.RespostaConsultaProcedimentsRDTO;



public class RespostaConsultaProcedimentsMockService {
    
	
	public RespostaConsultaProcedimentsRDTO getRespostaConsultaProcediments(BigDecimal idProcediment) {
		
//		if(idProcediment.compareTo(new BigDecimal("1")) == 0) {
//			throw new GPAServeisServiceRuntimeException("No se encuentra el procedimiento con id=1");
//		}

		
		RespostaConsultaProcedimentsRDTO resposta = new RespostaConsultaProcedimentsRDTO();
		
		ProcedimentsConsultaRDTO procediment = new ProcedimentsConsultaRDTO();
		
		procediment.setId(idProcediment);
		procediment.setCodi("CODI");
		procediment.setDescripcio("Procediment 1");
		procediment.setVersio("1");
		procediment.setEstat("EN_ELABORACIO");
		procediment.setInici(Arrays.asList(new String[]{"OFICI","ADMINISTRACIO"}));
		
		procediment.setTramits(
				TramitsRDTOFactory.create(new BigDecimal("1"), "SOLC", "Sol·licitud")
		);
		
		procediment.setUgo(
				Arrays.asList(
						UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1"),
						UnitatsRDTOFactory.create("UG2", "Unitat Gestora 2"),
						UnitatsRDTOFactory.create("UG3", "Unitat Gestora 3")
				)
		);	
		
		procediment.setUgr(
				UnitatsRDTOFactory.create("UG1", "Unitat Gestora 1")
		);
		
		
		
		DadesIdentificacioRDTO dadesIdentificacioRDTO = new DadesIdentificacioRDTO();
		dadesIdentificacioRDTO.setInformacioCiutada("Informacio ciutada");
		dadesIdentificacioRDTO.setNivellAutenticacio("ALT");
		
		TerminisDuracioRDTO terminisDuracioRDTO = new TerminisDuracioRDTO();
		terminisDuracioRDTO.setUnitat("DIES");
		terminisDuracioRDTO.setTerminiMaxim("365");
		terminisDuracioRDTO.setPeriodicitat("ESPORADIC");
		terminisDuracioRDTO.setDataIniciVigencia("01/01/2018");
		terminisDuracioRDTO.setDataFiVigencia("12/12/2019");
		
		dadesIdentificacioRDTO.setTerminisDuracio(terminisDuracioRDTO);
		procediment.setDadesIdentificacio(dadesIdentificacioRDTO);
		
		resposta.setProcediment(procediment);
		return resposta;
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
	
	
	private static class TramitsRDTOFactory {
		
		private static TramitsRDTO create(
			BigDecimal id,
			String codi, 
			String descripcio
		) {
			
			TramitsRDTO tramitsRDTO = new TramitsRDTO();
			
			tramitsRDTO.setId(id);
			tramitsRDTO.setCodi(codi);
			tramitsRDTO.setDescripcio(descripcio);
			
			return tramitsRDTO;
	    }
	}	
	
}


