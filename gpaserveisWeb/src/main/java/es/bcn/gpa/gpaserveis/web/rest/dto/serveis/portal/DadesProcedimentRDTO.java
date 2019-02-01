package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaunitats.UnitatsGestoresRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DadesProcedimentRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "procediments", "tramitsList", "ugr", "ugoList" })
@Getter
@Setter
public class DadesProcedimentRDTO {

	@JsonProperty("procediments")
	private ProcedimentsRDTO procedimentsRDTO = null;

	@JsonProperty("tramitsList")
	private List<TramitsRDTO> tramitsRDTOList = null;

	@JsonProperty("ugr")
	private UnitatsGestoresRDTO ugrRDTO = null;

	@JsonProperty("ugoList")
	private List<UnitatsGestoresRDTO> ugoRDTOList = null;

}
