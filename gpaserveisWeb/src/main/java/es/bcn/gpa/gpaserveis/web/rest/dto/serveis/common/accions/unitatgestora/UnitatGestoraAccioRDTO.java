package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.unitatgestora;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "UnitatGestoraAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi" })
@Getter
@Setter
public class UnitatGestoraAccioRDTO {

	@ApiModelProperty("Codi identificador de la unitat gestora")
	private String codi;

}
