package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SignaturaPortasignaturesDocumentRDTO.
 */
@ApiModel(value = "SignaturaPortasignaturesDocument", parent = SignaturaDocumentRDTO.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "usuari" })
@Getter
@Setter
public class SignaturaPortasignaturesDocumentRDTO extends SignaturaDocumentRDTO {

	/** The usuari. */
	@ApiModelProperty(value = "Informació de l'usuari de Portasignatures", required = true)
	private UsuariPortasignaturesRDTO usuari;

}
