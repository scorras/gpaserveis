package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.pausar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientAccioPausar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "estat", "dataLimit" })
@Getter
@Setter
public class ExpedientAccioPausarRDTO extends ExpedientAccioRDTO {

	@ApiModelProperty(value = "Estat actual del expedient")
	private String estat;
	@ApiModelProperty(value = "Data límit que estableix la durada de la pausa de l’expedient")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataLimit;

}
