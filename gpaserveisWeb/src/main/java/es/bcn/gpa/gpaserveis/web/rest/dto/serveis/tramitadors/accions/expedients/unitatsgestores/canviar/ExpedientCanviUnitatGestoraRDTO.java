package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.unitatsgestores.canviar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientCanviUnitatGestora")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiUnitatGestora", "comentari" })
@Getter
@Setter
public class ExpedientCanviUnitatGestoraRDTO {

	@ApiModelProperty(value = "Codi de la Unitat Gestora", required = true)
	private String codiUnitatGestora;

	@ApiModelProperty(value = "Comentari associat al canvi d'unitat gestora")
	private String comentari;

}
