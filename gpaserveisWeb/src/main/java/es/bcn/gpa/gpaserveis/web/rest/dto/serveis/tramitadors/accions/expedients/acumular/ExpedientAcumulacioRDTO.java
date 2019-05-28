package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acumular;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientAcumulacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiExpedient", "comentari" })
@Getter
@Setter
public class ExpedientAcumulacioRDTO {

	@ApiModelProperty(value = "Codi de l'expedient acumulat.", required = true)
	private String codiExpedient;
	@ApiModelProperty(value = "comentari associat al tancament.", required = true)
	private String comentari;

}
