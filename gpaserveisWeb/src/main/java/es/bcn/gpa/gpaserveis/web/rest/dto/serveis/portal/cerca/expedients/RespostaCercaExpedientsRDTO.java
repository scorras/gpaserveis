package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.expedients;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaCercaProcediments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "paginacio"
})
public class RespostaCercaExpedientsRDTO {
    
	private List<ExpedientsCercaRDTO> data = Collections.emptyList();
	private PaginacioRDTO paginacio;
	
	
	public List<ExpedientsCercaRDTO> getData() {
		return data;
	}
	public void setData(List<ExpedientsCercaRDTO> data) {
		this.data = data;
	}
	public PaginacioRDTO getPaginacio() {
		return paginacio;
	}
	public void setPaginacio(PaginacioRDTO paginacio) {
		this.paginacio = paginacio;
	}
	
}


