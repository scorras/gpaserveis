package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.retornar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaexpedients.RetornTramitacio;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaRetornarExpedien")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "expedient", "retornTramitacio" })
@Getter
@Setter
public class RespostaRetornarExpedientRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;
	@ApiModelProperty("Retorn tramitació")
	private RetornTramitacio retornTramitacio;

}
