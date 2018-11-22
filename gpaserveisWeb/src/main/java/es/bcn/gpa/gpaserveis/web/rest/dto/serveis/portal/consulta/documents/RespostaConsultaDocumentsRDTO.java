package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaConsultaDocuments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "documents"
})
@Getter
@Setter
public class RespostaConsultaDocumentsRDTO {
    
	private List<DocumentsConsultaRDTO> documents = Collections.emptyList();
	
}


