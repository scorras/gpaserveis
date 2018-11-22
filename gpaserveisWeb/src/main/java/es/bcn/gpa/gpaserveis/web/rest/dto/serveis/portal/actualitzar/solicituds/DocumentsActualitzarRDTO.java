package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="DocumentActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "nom",
})
@Getter
@Setter
public class DocumentsActualitzarRDTO {
    
	@ApiModelProperty("Identificador del document")
	private String id;
	@ApiModelProperty(value="Codi del document")
	private String codi;	
	@ApiModelProperty("Nom del document")
	private String nom;
	
}


