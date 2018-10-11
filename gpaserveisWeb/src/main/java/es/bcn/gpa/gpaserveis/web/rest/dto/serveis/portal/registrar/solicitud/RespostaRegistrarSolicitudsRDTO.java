package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.registrar.solicitud;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="RespostaRegistrarSolicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "expedient"
})
public class RespostaRegistrarSolicitudsRDTO {
    
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Resultat de l'operació")
	private RespostaRegistrarExpedientsRDTO expedient;

	public ResultatRespostaDTO getResultat() {
		return resultat;
	}
	public void setResultat(ResultatRespostaDTO resultat) {
		this.resultat = resultat;
	}
	public RespostaRegistrarExpedientsRDTO getExpedient() {
		return expedient;
	}
	public void setExpedient(RespostaRegistrarExpedientsRDTO expedient) {
		this.expedient = expedient;
	}
	
}


