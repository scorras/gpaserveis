package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.unitatgestora.UnitatGestoraAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientAccioUnitatGestora")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "unitatGestora" })
@Getter
@Setter
public class ExpedientAccioUnitatGestoraRDTO extends ExpedientAccioRDTO {

	@ApiModelProperty("Unitat Gestora de l'Expedient")
	private UnitatGestoraAccioRDTO unitatGestora;

}
