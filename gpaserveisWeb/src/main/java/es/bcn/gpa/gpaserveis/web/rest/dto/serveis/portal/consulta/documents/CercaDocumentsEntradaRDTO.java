package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpadocumentacio.ConfiguracioDocsEntradaRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CercaDocumentsEntradaRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "configuracioDocsEntradaRDTOList" })
@Getter
@Setter
public class CercaDocumentsEntradaRDTO {

	@JsonProperty("configuracioDocsEntradaRDTOList")
	private List<ConfiguracioDocsEntradaRDTO> configuracioDocsEntradaRDTOList = null;

}
