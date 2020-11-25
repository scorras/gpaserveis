package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "resultatPeticioRespostaDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiError", "descError" })
@Getter
@Setter
public class ResultatPeticioRespostaDTO {

	@ApiModelProperty("Indicant quin error s'ha produït")
	protected String codiError;
	@ApiModelProperty("Text explicatiu de l'error produït")
	protected String descError;

}
