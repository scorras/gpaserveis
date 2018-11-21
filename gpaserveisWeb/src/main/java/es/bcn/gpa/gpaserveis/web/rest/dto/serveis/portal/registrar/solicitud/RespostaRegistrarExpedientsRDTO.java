package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.registrar.solicitud;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="RespostaExpedientCrear")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
    "registre"
})
public class RespostaRegistrarExpedientsRDTO {

	@ApiModelProperty("Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty("Dades del registre de l'expedient")
	private RegistreRDTO registre;
	

	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public RegistreRDTO getRegistre() {
		return registre;
	}
	public void setRegistre(RegistreRDTO registre) {
		this.registre = registre;
	}
	
	
}
