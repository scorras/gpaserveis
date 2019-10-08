package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.publicar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentPerAInformacioPublica")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nom", "dataCreacio" })
@Getter
@Setter
public class DocumentPerAInformacioPublicaRDTO {

	@ApiModelProperty(value = "Nom del document.", required = true)
	String nom;

	@ApiModelProperty(value = "Data de creació del document.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_PATTERN)
	private String dataCreacio;
}
