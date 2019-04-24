package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.retornar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientValidacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class ExpedientRetornRDTO {
	@ApiModelProperty(value = "comentari associat a la validació.")
	private String comentari;

}
