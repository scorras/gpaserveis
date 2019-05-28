package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.signar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaSignarDocumentRDTO.
 */
@ApiModel(value = "RespostaSignarDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "expedient" })
@Getter
@Setter
public class RespostaSignarDocumentRDTO {

	/** The resultat. */
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	/** The expedient. */
	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;
}
