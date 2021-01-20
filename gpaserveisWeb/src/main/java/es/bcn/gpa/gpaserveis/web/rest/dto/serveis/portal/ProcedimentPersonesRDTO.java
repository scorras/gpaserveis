package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ProcedimentPersones")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tipus", "nivellVisibilitat" })
@Getter
@Setter
public class ProcedimentPersonesRDTO {

	@ApiModelProperty(value = "Tipus de relació")
	private String tipus;
	@ApiModelProperty(value = "Nivell de Visibilitat")
	private String nivellVisibilitat;

}
