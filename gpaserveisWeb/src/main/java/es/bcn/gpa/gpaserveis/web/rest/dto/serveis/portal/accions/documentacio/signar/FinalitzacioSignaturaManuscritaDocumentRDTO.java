package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class FinalitzacioSignaturaManuscritaDocumentRDTO.
 */
@ApiModel(value = "FinalitzacioSignaturaManuscritaDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idPeticio" })
@Getter
@Setter
public class FinalitzacioSignaturaManuscritaDocumentRDTO {

	@ApiModelProperty(required = true, value = "Identificador assignat pel mòdul de signatures en el moment de realitzar la petició.")
	private String idPeticio;

}
