package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="Paginacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "totalResultats",
    "totalPagines",
    "resultatsPerPagina",
    "numeroPagina"
})
public class PaginacioRDTO {
    
	@ApiModelProperty(value="Número total de resultats de la cerca")
	private long totalResultats;
	@ApiModelProperty(value="Número total de pàgines de la cerca")
	private int totalPagines;
	@ApiModelProperty(value="Resultats per pàgina de la cerca")
	private int resultatsPerPagina;
	@ApiModelProperty(value="Número de pàgina de la cerca")
	private int numeroPagina;
	
	
	public long getTotalResultats() {
		return totalResultats;
	}
	public void setTotalResultats(long totalResultats) {
		this.totalResultats = totalResultats;
	}
	public int getTotalPagines() {
		return totalPagines;
	}
	public void setTotalPagines(int totalPagines) {
		this.totalPagines = totalPagines;
	}
	public int getResultatsPerPagina() {
		return resultatsPerPagina;
	}
	public void setResultatsPerPagina(int resultatsPerPagina) {
		this.resultatsPerPagina = resultatsPerPagina;
	}
	public int getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	
}