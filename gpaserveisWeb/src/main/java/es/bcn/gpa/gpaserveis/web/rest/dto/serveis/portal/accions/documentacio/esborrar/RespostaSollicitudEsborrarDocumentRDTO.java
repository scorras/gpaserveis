package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.esborrar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds.SollicitudAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.DocumentEsborratAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaSollicitudEsborrarDocumentRDTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "document", "expedient", "sollicitud"})
@Getter
@Setter
public class RespostaSollicitudEsborrarDocumentRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty(value = "Document esborrat")
	private DocumentEsborratAccioRDTO document;

	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;
	
	@ApiModelProperty(value = "Sol·licitud del document")
	private SollicitudAccioRDTO sollicitud;

}
