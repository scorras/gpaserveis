package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentEsborratAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi" })
@Getter
@Setter
public class DocumentEsborratAccioRDTO {

	@ApiModelProperty(value = "Id del document")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi del document")
	private String codi;

}
