package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.comunicacio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="ExpedientComunicat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "canal",
    "dataComunicacio",
    "comentari"
})
@Getter
@Setter
public class ExpedientComunicatRDTO {

	@ApiModelProperty(value = "Canal de comunicació informat.", required = true, allowableValues = "TELEFON, MAIL")
	private String canal;
	@ApiModelProperty(value = "Data del comunicat.", required = true)
	private String dataComunicacio;
	@ApiModelProperty(value = "Comentari.")
	private String comentari;
	
}


