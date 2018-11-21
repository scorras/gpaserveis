package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaConsultaExpedients")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expedient"
})
public class RespostaConsultaExpedientsRDTO {
    
	private ExpedientsConsultaRDTO expedient;

	
	public ExpedientsConsultaRDTO getExpedient() {
		return expedient;
	}

	public void setExpedient(ExpedientsConsultaRDTO expedient) {
		this.expedient = expedient;
	}
	
}


