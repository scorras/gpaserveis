package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaFinalitzarSignarManuscritaDocumentRDTO.
 */
@ApiModel(value = "RespostaFinalitzarSignarManuscritaDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat" })
@Getter
@Setter
public class RespostaFinalitzarSignarManuscritaDocumentRDTO {

	/** The resultat. */
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

}
