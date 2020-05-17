package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "TramitsOvtProcediments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nom" })
@Getter
@Setter
public class TramitsOvtProcedimentsRDTO {

	@ApiModelProperty(value = "Nom del tràmit")
	private String nom;

}