package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsOvtRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaDadesOperacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dadesOperacio", "tramit" })
@Getter
@Setter
public class RespostaConsultaDadesOperacioRDTO {

	@ApiModelProperty(value = "Llista de dades d'operació")
	private DadesOperacioConsultaRDTO dadesOperacio;

	@ApiModelProperty(value = "Dades del tràmit")
	private TramitsOvtRDTO tramit;

}
