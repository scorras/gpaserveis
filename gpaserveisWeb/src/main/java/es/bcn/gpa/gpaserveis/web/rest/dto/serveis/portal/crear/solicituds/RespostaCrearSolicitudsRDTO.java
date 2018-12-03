package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaCrearSolicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "expedient"
})
@Getter
@Setter
public class RespostaCrearSolicitudsRDTO {
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Expedient creat en estat inicial")
	private RespostaCrearExpedientsRDTO expedient;

}


