package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "AtributsActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "valor" })
@Getter
@Setter
public class AtributsActualitzarRDTO {

	@ApiModelProperty(value = "Codi identificador de l'atribut.", required = true)
	private String codi;
	@ApiModelProperty(value = "Valor de l'atribut", required = true)
	private List<String> valor;

}
