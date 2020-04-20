package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DocumentRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaDocumentacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document", "resultat" })
@Getter
@Setter
public class RespostaConsultaDocumentacioRDTO {

	@ApiModelProperty(value = "Document")
	private DocumentRDTO document;
}
