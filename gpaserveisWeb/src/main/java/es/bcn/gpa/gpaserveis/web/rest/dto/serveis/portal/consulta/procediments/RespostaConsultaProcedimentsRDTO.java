package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaConsultaProcediments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "procediment"
})
public class RespostaConsultaProcedimentsRDTO {
    
	private ProcedimentsConsultaRDTO procediment;

	
	public ProcedimentsConsultaRDTO getProcediment() {
		return procediment;
	}

	public void setProcediment(ProcedimentsConsultaRDTO procediment) {
		this.procediment = procediment;
	}
	
}


