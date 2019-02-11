package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.DadesGrupsRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "CercaDadesOperacioRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dadesGrupsRDTOList" })
@Getter
@Setter
public class CercaDadesOperacioRDTO {

	@JsonProperty("dadesGrupsRDTOList")
	private List<DadesGrupsRDTO> dadesGrupsRDTOList = null;

}
