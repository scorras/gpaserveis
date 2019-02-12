package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentsEntrada")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documents" })
@Getter
@Setter
public class DocumentsEntradaConsultaRDTO {

	@ApiModelProperty("Llista de documents")
	private List<DocumentsRDTO> documents = Collections.emptyList();

}
