package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaActualitzarSolicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "expedient"
})
@Getter
@Setter
public class RespostaActualitzarSolicitudsRDTO {
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Expedient actualitzat en estat esborrany")
	private RespostaActualitzarExpedientsRDTO expedient;
	
}


