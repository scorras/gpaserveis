package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesProcedimentRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CercaProcedimentsRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dadesProcedimentList", "paginationAttributes" })
@Getter
@Setter
public class CercaProcedimentsRDTO {

	@JsonProperty("dadesProcedimentList")
	private List<DadesProcedimentRDTO> dadesProcedimentRDTOList = null;

	@JsonProperty("paginationAttributes")
	private PaginationAttributes paginationAttributes = null;

}
