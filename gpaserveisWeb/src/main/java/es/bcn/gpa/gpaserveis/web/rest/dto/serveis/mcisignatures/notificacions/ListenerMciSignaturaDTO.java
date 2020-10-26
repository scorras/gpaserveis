package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mcisignatures.notificacions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value = "ListenerMciSignatura")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "formSignResume", "ticket" })
@Getter
@Setter
@ToString
public class ListenerMciSignaturaDTO {

	@ApiModelProperty(required = true, value = "formSignResume")
	private String formSignResume;
	@ApiModelProperty(required = true, value = "ticket")
	private String ticket;

}
