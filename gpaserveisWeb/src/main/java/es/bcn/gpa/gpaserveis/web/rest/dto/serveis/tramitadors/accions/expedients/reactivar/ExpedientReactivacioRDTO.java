package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.reactivar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientReactivacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class ExpedientReactivacioRDTO {

	@ApiModelProperty(value = "Comentari associat a la reactivació.")
	private String comentari;

}
