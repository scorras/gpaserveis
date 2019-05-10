package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DadaOperacioRequerit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi" })
@Getter
@Setter
public class DadaOperacioRequeritRDTO {

	@ApiModelProperty(value = "Codi identificador de la dada d'operació.", required = true)
	private String codi;

}
