package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.resolucio.proposar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientPropostaResolucio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class ExpedientPropostaResolucioRDTO {

	@ApiModelProperty(value = "Comentari associat a la proposta de resolució.")
	private String comentari;

}
