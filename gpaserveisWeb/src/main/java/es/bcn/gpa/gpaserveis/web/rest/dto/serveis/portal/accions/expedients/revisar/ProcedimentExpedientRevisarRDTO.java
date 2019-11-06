package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.revisar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ProcedimentExpedientRevisar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id" })
@Getter
@Setter
public class ProcedimentExpedientRevisarRDTO {

	@ApiModelProperty(value = "Identificador del procediment", required = true)
	private BigDecimal id;
}
