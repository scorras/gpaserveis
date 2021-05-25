package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tancar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientTancament")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari", "tancamentAutomatic" })
@Getter
@Setter
public class ExpedientTancamentRDTO {

	@ApiModelProperty(value = "comentari associat al tancament.")
	private String comentari;
	@ApiModelProperty(value = "tancament automatic.")
	private BigDecimal tancamentAutomatic;

}
