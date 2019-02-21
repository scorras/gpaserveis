package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ConfiguracionsDocumentacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentsRequeritsExpedients")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documents" })
@Getter
@Setter
public class DocumentsRequeritsExpedientsRDTO {

	@ApiModelProperty("Llista de documents requerits")
	private List<ConfiguracionsDocumentacioRDTO> documents;

}
