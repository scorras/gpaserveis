package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.obrir.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="RespostaObrirSolicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "expedient"
})
public class RespostaObrirSolicitudsRDTO {
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Expedient creat en estat inicial")
	private RespostaObrirExpedientsRDTO expedient;
	
	public ResultatRespostaDTO getResultat() {
		return resultat;
	}
	public void setResultat(ResultatRespostaDTO resultat) {
		this.resultat = resultat;
	}
	public RespostaObrirExpedientsRDTO getExpedient() {
		return expedient;
	}
	public void setExpedient(RespostaObrirExpedientsRDTO expedient) {
		this.expedient = expedient;
	}
	
	
}


