package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="AtributsExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "valor"
})
@Getter
@Setter
public class DadesAtributsExpedientsRDTO {
	
	@ApiModelProperty(value="Identificador de l'atribut")
	private BigDecimal id;
	@ApiModelProperty(value="Codi de l'atribut")
	private String codi;
	@ApiModelProperty(value="Valor de l'atribut")
	private String valor;
	
}
