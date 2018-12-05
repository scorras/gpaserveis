package es.bcn.gpa.gpaserveis.web.rest.controller.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.DocumentsConsultaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents.RespostaConsultaDocumentsRDTO;



public class RespostaConsultaDocumentsMockService {
    
	
	private List<DocumentsConsultaRDTO> data = Collections.emptyList();
	

	public void initialize() {
		data = new ArrayList<>();
		data.add(DocumentsConsultaRDTOFactory.create(new BigDecimal("1"), "SOLC", "Document Sol·licitud", "Formulari de sol·licitud", true, false, "FORMULARI", "http://gpa.ajuntament.bcn/formularis/solc"));
		data.add(DocumentsConsultaRDTOFactory.create(new BigDecimal("2"), "DNI", "Document d'identitat", "Document d'identitat", true, false, "SENSE_SUPORT", null));
		data.add(DocumentsConsultaRDTOFactory.create(new BigDecimal("3"), "ALTRES", "Altres documents", "Altres documents", true, false, "SENSE_SUPORT", null));
	}
	
	
	public RespostaConsultaDocumentsRDTO getRespostaConsultaDocuments(
			BigDecimal idProcediment, BigDecimal idTramit ) {
		
		RespostaConsultaDocumentsRDTO resposta = new RespostaConsultaDocumentsRDTO();
		resposta.setDocuments(data);
		
		return resposta;
	}
	
	
	private static class DocumentsConsultaRDTOFactory {
		
		private static DocumentsConsultaRDTO create(
				BigDecimal id,
				String codi, 
				String descripcio,
				String descripcioAmpliada,
				boolean obligatori,
				boolean repetible,
				String suportConfeccio,
				String suportEnllac
				) {
			
			DocumentsConsultaRDTO documentConsultaRDTO = new DocumentsConsultaRDTO();
			
			documentConsultaRDTO.setId(id);
			documentConsultaRDTO.setCodi(codi);
			documentConsultaRDTO.setDescripcio(descripcio);
			documentConsultaRDTO.setDescripcioAmpliada(descripcioAmpliada);
			documentConsultaRDTO.setObligatori(true);
			documentConsultaRDTO.setRepetible(repetible);
			documentConsultaRDTO.setSuportConfeccio(suportConfeccio);
			documentConsultaRDTO.setSuportEnllac(suportEnllac);
			
			return documentConsultaRDTO;
	    }
	}	
	
}


