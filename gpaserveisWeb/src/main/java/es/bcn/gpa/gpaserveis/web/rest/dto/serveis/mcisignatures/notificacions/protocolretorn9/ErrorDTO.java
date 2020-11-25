package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "errorDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiError", "descripcioError", "signaturaOriginal", "idPeticioOriginal" })
@Getter
@Setter
@ToString
public class ErrorDTO {

	@ApiModelProperty(required = true, value = "Codi de l'error")
	private BigDecimal codiError;
	@ApiModelProperty(required = true, value = "Descripció de l'error")
	private String descripcioError;
	@ApiModelProperty(required = true, value = "Objecte de la signatura")
	private SignaturaDTO signaturaOriginal;
	@ApiModelProperty(required = true, value = "Identificador de la petició original")
	private BigDecimal idPeticioOriginal;

}
