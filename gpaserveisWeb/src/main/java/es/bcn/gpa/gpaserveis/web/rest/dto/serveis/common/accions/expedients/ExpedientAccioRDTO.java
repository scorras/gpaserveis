package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="ExpedientAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi"
})
@Getter
@Setter
public class ExpedientAccioRDTO {
    
	@ApiModelProperty("Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty("Codi identificador de l'expedient")
	private String codi;

}


