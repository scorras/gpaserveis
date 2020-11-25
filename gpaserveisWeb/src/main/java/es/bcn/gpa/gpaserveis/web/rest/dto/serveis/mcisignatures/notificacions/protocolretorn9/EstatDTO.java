package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions.protocolretorn9;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "estatDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "descripcio", "valorNumeric" })
@Getter
@Setter
@ToString
public class EstatDTO {

	@ApiModelProperty(required = true, value = "Codi de l'estat")
	private String codi;
	@ApiModelProperty(required = true, value = "Descripció de l'estat")
	private String descripcio;
	@ApiModelProperty(required = true, value = "Codi numèric de l'estat")
	private BigDecimal valorNumeric;
}
