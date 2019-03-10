package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.abandonar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="ExpedientAbandonament")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "comentari"
})
@Getter
@Setter
public class ExpedientAbandonamentRDTO {
	@ApiModelProperty(value = "Comentari associat al desistiment o renuncia.")
	private String comentari;

}


