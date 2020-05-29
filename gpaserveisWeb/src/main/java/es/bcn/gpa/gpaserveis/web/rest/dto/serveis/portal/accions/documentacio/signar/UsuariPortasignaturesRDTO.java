package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class UsuariPortasignaturesRDTO.
 */
@ApiModel(value = "UsuariPortasignatures")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "matricula" })
@Getter
@Setter
public class UsuariPortasignaturesRDTO {

	/** The matricula. */
	@ApiModelProperty(value = "Matrícula de la persona que va a signar el document", required = true)
	private String matricula;

}
