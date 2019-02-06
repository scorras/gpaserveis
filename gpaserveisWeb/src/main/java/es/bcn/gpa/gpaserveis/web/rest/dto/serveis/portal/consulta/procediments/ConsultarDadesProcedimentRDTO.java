package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesProcedimentRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ConsultarDadesProcedimentRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dadesProcediment" })
@Getter
@Setter
public class ConsultarDadesProcedimentRDTO {

	@JsonProperty("dadesProcediment")
	private DadesProcedimentRDTO DadesProcedimentRDTO;
}
