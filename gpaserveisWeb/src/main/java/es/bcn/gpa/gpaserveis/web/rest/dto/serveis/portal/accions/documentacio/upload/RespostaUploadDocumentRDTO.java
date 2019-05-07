package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.upload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentAportatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaUploadDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "document", "registre", "expedient" })
@Getter
@Setter
public class RespostaUploadDocumentRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty(value = "Upload document")
	private DocumentAportatAccioRDTO document;

	@ApiModelProperty(value = "Registre del document")
	private RegistreRDTO registre;

	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;

}
