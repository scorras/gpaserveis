package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.interoperabilitat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ObtenirPerInteroperabilitat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiServei" })
@Getter
@Setter
public class ObtenirPerInteroperabilitatRDTO {
	@ApiModelProperty(value = "Codi del servei a executar.", required = true)
	private String codiServei;
}
