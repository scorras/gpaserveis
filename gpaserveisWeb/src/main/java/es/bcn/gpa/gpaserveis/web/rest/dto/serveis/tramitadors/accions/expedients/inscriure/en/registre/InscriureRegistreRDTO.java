package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.inscriure.en.registre;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "InscriureEnRegistre")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class InscriureRegistreRDTO {

	@ApiModelProperty(value = "Comentari associat al registre.")
	private String comentari;
}
