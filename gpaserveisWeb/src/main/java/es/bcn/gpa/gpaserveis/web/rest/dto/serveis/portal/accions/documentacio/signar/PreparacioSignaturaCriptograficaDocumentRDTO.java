package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class PreparacioSignaturaCriptograficaDocumentRDTO.
 */
@ApiModel(value = "PreparacioSignaturaCriptograficaDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idDocument", "politicaSignatura" })
@Getter
@Setter
public class PreparacioSignaturaCriptograficaDocumentRDTO {

	/** The id document. */
	@ApiModelProperty(value = "Identificador de el document", required = true)
	private BigDecimal idDocument;

	/** The politica signatura. */
	@ApiModelProperty(value = "Política de signatura", required = true)
	private String politicaSignatura;

}
