package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "detallErrorsDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idDocument", "detallError", "signaturaResultat", "idPeticioOriginal" })
@Getter
@Setter
@ToString
public class DetallErrorsDTO {

	@ApiModelProperty(required = true, value = "Identificador del document")
	private String idDocument;
	@ApiModelProperty(required = true, value = "Objecte error")
	private ErrorDTO detallError;
	@ApiModelProperty(required = true, value = "Objecte de la signatura")
	private SignaturaDTO signaturaResultat;
	@ApiModelProperty(required = true, value = "Identificador de la petició original")
	private BigDecimal idPeticioOriginal;

}
