package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaConsultaDocuments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "documents"
})
public class RespostaConsultaDocumentsRDTO {
    
	private List<DocumentsConsultaRDTO> documents = Collections.emptyList();

	
	public List<DocumentsConsultaRDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentsConsultaRDTO> documents) {
		this.documents = documents;
	}
	
	
}


