package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaConsultaDocuments")
public class RespostaConsultaDocumentsRDTO {
    
	private List<DocumentsConsultaRDTO> documents = Collections.emptyList();

	public List<DocumentsConsultaRDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentsConsultaRDTO> documents) {
		this.documents = documents;
	}
	
	
	
}


