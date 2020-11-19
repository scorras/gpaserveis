package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class UsuariManuscritaRDTO.
 */
@ApiModel(value = "UsuariManuscrita")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idTabletUsuari", "documentUsuari" })
@Getter
@Setter
public class UsuariManuscritaRDTO {

	/** The id tablet usuari. */
	@ApiModelProperty(value = "Identificador de la tauleta on signarà l'usuari")
	private String idTabletUsuari;
	/** The id tablet usuari. */
	@ApiModelProperty(value = "Document identitat de l'usuari")
	private String documentUsuari;
}
