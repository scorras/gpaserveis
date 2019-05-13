package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mciportasig.notificacions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "MciPortasigResultatPeticioResposta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiError", "descError" })
@Getter
@Setter
public class MciPortasigResultatPeticioRespostaDTO {

	@ApiModelProperty("Indicant quin error s'ha produït. Aquest error no tindrà tractament al costat del Portasignatures: si consigueix contactar a l'aplicació client, i si el web service resultatPeticio finalitza sense problemes tècnics, el Portasignatures considera que la notificació del resultat de la petició ja ha sigut realitzada.")
	protected String codiError;
	@ApiModelProperty("Text explicatiu de l'error produït.")
	protected String descError;

}
