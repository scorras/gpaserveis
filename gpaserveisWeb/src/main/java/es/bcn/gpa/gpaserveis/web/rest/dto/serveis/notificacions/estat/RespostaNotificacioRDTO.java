package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.notificacions.estat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaNotificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "retornNotificacio" })
@Getter
@Setter
public class RespostaNotificacioRDTO {

	@ApiModelProperty(value = "RetornNotificacio", required = true)
	RetornNotificacioRDTO retornNotificacio;

}
