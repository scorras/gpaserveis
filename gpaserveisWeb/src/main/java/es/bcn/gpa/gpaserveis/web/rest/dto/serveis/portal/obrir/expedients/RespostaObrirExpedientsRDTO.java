package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.obrir.expedients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="RespostaObrirExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi"
})
public class RespostaObrirExpedientsRDTO {
    
	@ApiModelProperty("Identificador de l'expedient")
	private BigDecimal id;
	@ApiModelProperty("Codi de l'expedient")
	private String codi;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getCodi() {
		return codi;
	}
	public void setCodi(String codi) {
		this.codi = codi;
	}
	
}


