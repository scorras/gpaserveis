package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.PaginationAttributes;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesExpedientRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CercaExpedientsRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dadesExpedientList", "paginationAttributes" })
@Getter
@Setter
public class CercaExpedientsRDTO {

	@JsonProperty("dadesExpedientList")
	private List<DadesExpedientRDTO> dadesExpedientRDTOList = null;

	@JsonProperty("paginationAttributes")
	private PaginationAttributes paginationAttributes = null;

}
