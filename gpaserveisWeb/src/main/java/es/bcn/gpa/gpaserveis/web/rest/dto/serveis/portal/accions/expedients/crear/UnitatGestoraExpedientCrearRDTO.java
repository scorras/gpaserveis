package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.crear;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "UnitatGestoraExpedientCrear")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi" })
@Getter
@Setter
public class UnitatGestoraExpedientCrearRDTO {

	@ApiModelProperty(value = "Codi de la Unitat Gestora", required = true)
	private String codi;

}
