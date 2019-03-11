package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="ExpedientEsmena")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "comentari"
})
@Getter
@Setter
public class ExpedientEsmenaRDTO {
    
	@ApiModelProperty(value = "Comentari associat a la resposta.")
	private String comentari;

}


