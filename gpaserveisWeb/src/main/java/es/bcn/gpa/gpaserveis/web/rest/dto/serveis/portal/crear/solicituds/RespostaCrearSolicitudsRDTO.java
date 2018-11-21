package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="RespostaCrearSolicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "expedient"
})
public class RespostaCrearSolicitudsRDTO {
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Expedient creat en estat inicial")
	private RespostaCrearExpedientsRDTO expedient;
	
	public ResultatRespostaDTO getResultat() {
		return resultat;
	}
	public void setResultat(ResultatRespostaDTO resultat) {
		this.resultat = resultat;
	}
	public RespostaCrearExpedientsRDTO getExpedient() {
		return expedient;
	}
	public void setExpedient(RespostaCrearExpedientsRDTO expedient) {
		this.expedient = expedient;
	}
}


