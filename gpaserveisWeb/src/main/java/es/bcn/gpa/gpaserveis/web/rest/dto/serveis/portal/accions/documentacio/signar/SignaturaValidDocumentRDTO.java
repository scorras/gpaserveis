package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class SignaturaValidDocumentRDTO.
 */
@ApiModel(value = "SignaturaValidDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "valorToken", "informacioToken", "politicaSignatura" })
@Getter
@Setter
public class SignaturaValidDocumentRDTO {

	/** The valor token. */
	@ApiModelProperty(value = "Valor de l'token de Valid", required = true)
	private String valorToken;

	/** The informacio token. */
	@ApiModelProperty(value = "Informació de l'token de Valid", required = true)
	private String informacioToken;

	/** The politica signatura. */
	@ApiModelProperty(value = "Política de signatura", required = true)
	private String politicaSignatura;

}
