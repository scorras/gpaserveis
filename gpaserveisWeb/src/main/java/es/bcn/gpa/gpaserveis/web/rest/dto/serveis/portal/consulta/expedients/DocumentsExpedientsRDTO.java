package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.expedients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="DocumentExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "nom"
})
@Getter
@Setter
public class DocumentsExpedientsRDTO {
	
	@ApiModelProperty(value="Identificador del document")
	private BigDecimal id;
	@ApiModelProperty(value="Codi del document")
	private String codi;
	@ApiModelProperty(value="Nom del document")
	private String nom;
	
}
