package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Historic")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "estat", "estatCastella", "dataCreacio" })
@Getter
@Setter
public class HistoricsRDTO {

	@ApiModelProperty(value = "Estat de l'històric")
	private String estat;
	@ApiModelProperty(value = "Estat de l'històric en castellà")
	private String estatCastella;
	@ApiModelProperty(value = "Data de creació de l'històric")
	private String dataCreacio;

}
