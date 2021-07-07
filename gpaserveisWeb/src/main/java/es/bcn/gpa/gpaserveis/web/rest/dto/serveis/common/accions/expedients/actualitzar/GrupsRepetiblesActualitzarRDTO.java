package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "GrupsRepetiblesActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idGrup", "valor" })
// @JsonDeserialize(using = JsonAtributsActualitzarDeserializer.class)
@Getter
@Setter
public class GrupsRepetiblesActualitzarRDTO {

	@ApiModelProperty(value = "Identificador de el grup repetible", required = false)
	private BigDecimal idGrup;
	@ApiModelProperty(value = "Valor de grup repetible en format JSON", required = false)
	private String valor;
}
