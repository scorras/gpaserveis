package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaConsultaProcediments")
public class RespostaConsultaProcedimentsRDTO {
    
	private ProcedimentsConsultaRDTO procediment;

	public ProcedimentsConsultaRDTO getProcediment() {
		return procediment;
	}

	public void setProcediment(ProcedimentsConsultaRDTO procediment) {
		this.procediment = procediment;
	}
	
}


