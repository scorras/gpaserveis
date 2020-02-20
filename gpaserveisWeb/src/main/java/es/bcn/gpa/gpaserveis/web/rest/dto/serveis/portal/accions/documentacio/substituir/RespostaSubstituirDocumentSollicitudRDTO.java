package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentAportatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds.SollicitudAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostSubstituirDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "document",
    "expedient",
    "sollicitud"
})
@Getter
@Setter
public class RespostaSubstituirDocumentSollicitudRDTO {
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	
	@ApiModelProperty(value = "Document substituit")
	private DocumentAportatAccioRDTO document;
	
	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;
	
	@ApiModelProperty(value = "Sollicitud del document")
	private SollicitudAccioRDTO sollicitud;
}


