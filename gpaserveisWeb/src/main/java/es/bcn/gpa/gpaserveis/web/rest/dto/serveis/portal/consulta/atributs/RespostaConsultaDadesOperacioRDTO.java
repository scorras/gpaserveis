package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaDadesOperacio")
public class RespostaConsultaDadesOperacioRDTO {
    
	private DadesOperacioConsultaRDTO dadesOperacio;

	public DadesOperacioConsultaRDTO getDadesOperacio() {
		return dadesOperacio;
	}

	public void setDadesOperacio(DadesOperacioConsultaRDTO dadesOperacio) {
		this.dadesOperacio = dadesOperacio;
	}
	
}


