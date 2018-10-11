package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.procediments;

import java.util.Collections;
import java.util.List;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaCercaProcediments")
public class RespostaCercaProcedimentsRDTO {
    
	private List<ProcedimentsCercaRDTO> data = Collections.emptyList();
	private PaginacioRDTO paginacio;
	
	public List<ProcedimentsCercaRDTO> getData() {
		return data;
	}
	public void setData(List<ProcedimentsCercaRDTO> data) {
		this.data = data;
	}
	public PaginacioRDTO getPaginacio() {
		return paginacio;
	}
	public void setPaginacio(PaginacioRDTO paginacio) {
		this.paginacio = paginacio;
	}
	
}


