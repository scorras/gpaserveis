package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaConsultaExpedients")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "expedient" })
@Getter
@Setter
public class RespostaConsultaExpedientsRDTO {

	private ExpedientConsultaRDTO expedient;

}
