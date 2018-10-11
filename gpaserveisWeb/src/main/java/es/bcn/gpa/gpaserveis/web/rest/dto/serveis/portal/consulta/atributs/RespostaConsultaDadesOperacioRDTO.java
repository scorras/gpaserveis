package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaDadesOperacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dadesOperacio"
})
public class RespostaConsultaDadesOperacioRDTO {
    
	private DadesOperacioConsultaRDTO dadesOperacio;

	
	public DadesOperacioConsultaRDTO getDadesOperacio() {
		return dadesOperacio;
	}

	public void setDadesOperacio(DadesOperacioConsultaRDTO dadesOperacio) {
		this.dadesOperacio = dadesOperacio;
	}
	
}


