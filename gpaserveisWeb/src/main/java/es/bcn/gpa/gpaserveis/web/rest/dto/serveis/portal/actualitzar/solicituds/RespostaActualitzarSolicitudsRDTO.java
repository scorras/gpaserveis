package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="RespostaActualitzarSolicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "expedient"
})
public class RespostaActualitzarSolicitudsRDTO {
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Expedient actualitzat en estat esborrany")
	private RespostaActualitzarExpedientsRDTO expedient;
	
	public ResultatRespostaDTO getResultat() {
		return resultat;
	}
	public void setResultat(ResultatRespostaDTO resultat) {
		this.resultat = resultat;
	}
	public RespostaActualitzarExpedientsRDTO getExpedient() {
		return expedient;
	}
	public void setExpedient(RespostaActualitzarExpedientsRDTO expedient) {
		this.expedient = expedient;
	}
	
	
}


