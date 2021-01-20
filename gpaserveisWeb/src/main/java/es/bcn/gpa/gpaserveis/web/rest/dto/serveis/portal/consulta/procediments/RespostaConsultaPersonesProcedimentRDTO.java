package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ProcedimentPersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaPersonesProcediment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tramit", "terceresPersonesImplicades" })
@Getter
@Setter
public class RespostaConsultaPersonesProcedimentRDTO {

	@ApiModelProperty(value = "Dades del tràmit")
	private TramitsOvtRDTO tramit;

	@ApiModelProperty(value = "Llista de terceres persones implicades")
	private List<ProcedimentPersonesRDTO> terceresPersonesImplicades;

}
