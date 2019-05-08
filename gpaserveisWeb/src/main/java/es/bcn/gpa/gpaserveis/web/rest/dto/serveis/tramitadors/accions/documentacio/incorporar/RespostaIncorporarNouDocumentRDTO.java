package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.incorporar;

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

@ApiModel(value = "RespostaIncorporarNouDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "document", "registre", "expedient" })
@Getter
@Setter
public class RespostaIncorporarNouDocumentRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty(value = "Document incorporat")
	private DocumentIncorporatNouAccioRDTO document;

	@ApiModelProperty(value = "Registre de la documentació")
	private RegistreRDTO registre;

	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;

}
