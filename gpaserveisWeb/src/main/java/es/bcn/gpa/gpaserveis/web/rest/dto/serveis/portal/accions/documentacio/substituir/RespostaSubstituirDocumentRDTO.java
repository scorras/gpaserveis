package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.substituir;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.DocumentAportatAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostSubstituirDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resultat",
    "document",
    "registre",
    "expedient"
})
@Getter
@Setter
public class RespostaSubstituirDocumentRDTO {
    
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	
	@ApiModelProperty(value = "Document substituit")
	private DocumentAportatAccioRDTO document;

	@ApiModelProperty(value = "Registre del document")
	private RegistreRDTO registre;
	
	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;
}


