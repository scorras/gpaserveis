package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SignaturaManuscritaDocumentRDTO.
 */
@ApiModel(value = "SignaturaManuscritaDocument", parent = SignaturaDocumentRDTO.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "usuari" })
@Getter
@Setter
public class SignaturaManuscritaDocumentRDTO extends SignaturaDocumentRDTO {

	/** The usuari. */
	@ApiModelProperty(value = "Informació de l'usuari de tablet", required = true)
	private UsuariManuscritaRDTO usuari;

}
