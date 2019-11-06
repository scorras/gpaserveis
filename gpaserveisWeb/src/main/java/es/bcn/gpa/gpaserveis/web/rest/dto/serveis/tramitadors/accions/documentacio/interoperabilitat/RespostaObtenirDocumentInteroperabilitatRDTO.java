package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.interoperabilitat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentIncorporatNouAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class RespostaObtenirDocumentIntraoperabilitatRDTO.
 */
@ApiModel(value = "RespostaObtenirDocumentIntraoperabilitat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "document", "registre", "expedient" })
@Getter
@Setter
public class RespostaObtenirDocumentInteroperabilitatRDTO {

	/** The resultat. */
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	/** The document. */
	@ApiModelProperty(value = "Document incorporat")
	private DocumentIncorporatNouAccioRDTO document;

	/** The registre. */
	@ApiModelProperty(value = "Registre de la documentació")
	private RegistreRDTO registre;

	/** The expedient. */
	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;

}