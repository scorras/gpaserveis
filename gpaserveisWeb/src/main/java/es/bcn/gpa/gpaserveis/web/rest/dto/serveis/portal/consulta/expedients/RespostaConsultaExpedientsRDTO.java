package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import io.swagger.annotations.ApiModel;


@ApiModel(value="RespostaConsultaDocuments")
public class RespostaConsultaExpedientsRDTO {
    
	private ExpedientsConsultaRDTO expedient;

	public ExpedientsConsultaRDTO getExpedient() {
		return expedient;
	}

	public void setExpedient(ExpedientsConsultaRDTO expedient) {
		this.expedient = expedient;
	}
	
}


