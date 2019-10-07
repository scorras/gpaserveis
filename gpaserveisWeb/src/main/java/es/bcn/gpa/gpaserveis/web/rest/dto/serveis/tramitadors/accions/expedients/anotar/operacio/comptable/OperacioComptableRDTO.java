package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.anotar.operacio.comptable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "OperacioComptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class OperacioComptableRDTO {

	@ApiModelProperty(value = "Comentari associat a l'operació comptable.")
	private String comentari;
}
