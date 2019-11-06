package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.interoperabilitat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentIntraoperabilitat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiAccio" })
@Getter
@Setter
public class DocumentInteroperabilitatRDTO {
	// TODO Definir las necesidades tras la integración con los organismos
	// correspondientes.
	@ApiModelProperty(value = "Codi de l'acció.")
	private String codiAccio;
}
