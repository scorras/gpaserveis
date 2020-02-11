package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SollicitudAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "tipus"})
@Getter
@Setter
public class SollicitudAccioRDTO {

	@ApiModelProperty("Identificador de la sol·licitud")
	private BigDecimal id;
	
	@ApiModelProperty("Tipus de la sol·licitud")
	private String tipus;

}
