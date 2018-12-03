package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.registrar.solicitud;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaRegistrarSolicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "expedient"
})
@Getter
@Setter
public class RespostaRegistrarSolicitudsRDTO {
    
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Resultat de l'operació")
	private RespostaRegistrarExpedientsRDTO expedient;

}


