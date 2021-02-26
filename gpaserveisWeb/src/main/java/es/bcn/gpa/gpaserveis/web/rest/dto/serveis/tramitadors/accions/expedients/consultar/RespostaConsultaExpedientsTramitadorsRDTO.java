package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.consultar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaExpedientsTramitadors")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "expedient" })
@Getter
@Setter
public class RespostaConsultaExpedientsTramitadorsRDTO {

	@ApiModelProperty(value = "Expedient")
	private ExpedientConsultaTramitadorsRDTO expedient;

}
