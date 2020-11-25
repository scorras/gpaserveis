package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "resultatPeticioDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idPeticio", "urlSignaturaBrowser", "missatgeError", "errors" })
@Getter
@Setter
@ToString
public class ResultatPeticioDTO {

	@ApiModelProperty(required = true, value = "Identificador de la petició original de signatura")
	private BigDecimal idPeticio;
	@ApiModelProperty(required = true, value = "Url de la signatura")
	private String urlSignaturaBrowser;
	@ApiModelProperty(required = true, value = "Objecte error amb els diferents atributs")
	private ErrorDTO missatgeError;
	@ApiModelProperty(required = true, value = "Detall dels errors per a cada document")
	private List<DetallErrorsDTO> errors;

}
