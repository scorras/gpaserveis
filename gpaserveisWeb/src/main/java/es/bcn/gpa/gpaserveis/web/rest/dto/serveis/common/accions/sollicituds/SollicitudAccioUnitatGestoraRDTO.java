package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.unitatgestora.UnitatGestoraAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientAccioUnitatGestora")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "unitatGestora" })
@Getter
@Setter
public class SollicitudAccioUnitatGestoraRDTO extends SollicitudAccioRDTO {

	@ApiModelProperty("Unitat Gestora de l'Expedient")
	private UnitatGestoraAccioRDTO unitatGestora;

}
