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
 * The Class RespostaPrepararSignaturaDocumentRDTO.
 */
@ApiModel(value = "RespostaPrepararSignaturaDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "expedient", "idPeticio", "urlSignaturaBrowser" })
@Getter
@Setter
public class RespostaPrepararSignaturaDocumentRDTO {

	/** The resultat. */
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	/** The expedient. */
	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;

	/** The id peticio. */
	@ApiModelProperty("Identificador de la petició de signatura")
	private String idPeticio = null;

	/** The url signatura browser. */
	@ApiModelProperty("URL de redirecció a client a la pàgina de signatura")
	private String urlSignaturaBrowser = null;
}
