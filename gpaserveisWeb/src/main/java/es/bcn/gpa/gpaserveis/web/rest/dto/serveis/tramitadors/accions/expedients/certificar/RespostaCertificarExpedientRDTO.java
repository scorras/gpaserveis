package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.certificar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaCertificarExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "expedient" })
@Getter
@Setter
public class RespostaCertificarExpedientRDTO {

	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;

}
