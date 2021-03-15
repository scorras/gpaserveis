package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaTramitProcediment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tramit", "tramitGeneric", "" })
@Getter
@Setter
public class RespostaConsultaTramitProcedimentRDTO {

	@ApiModelProperty(value = "Dades del tràmit")
	private TramitsOvtRDTO tramit;

	@ApiModelProperty(value = "Tràmit genèric")
	private String tramitGeneric;

	@ApiModelProperty(value = "Detall Identificador")
	private String detallIdentificador;

}
