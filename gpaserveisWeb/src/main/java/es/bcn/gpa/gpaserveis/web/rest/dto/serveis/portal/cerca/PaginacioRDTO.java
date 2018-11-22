package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="Paginacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "totalResultats",
    "totalPagines",
    "resultatsPerPagina",
    "numeroPagina"
})
@Getter
@Setter
public class PaginacioRDTO {
    
	@ApiModelProperty(value="Número total de resultats de la cerca")
	private long totalResultats;
	@ApiModelProperty(value="Número total de pàgines de la cerca")
	private int totalPagines;
	@ApiModelProperty(value="Resultats per pàgina de la cerca")
	private int resultatsPerPagina;
	@ApiModelProperty(value="Número de pàgina de la cerca")
	private int numeroPagina;
	
}