package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.digitalitzar;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentDigitalitzarAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaDigitalitzarDocument")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "documentacioDigitalitzat", "registre", "expedient", "comprovant" })
@Getter
@Setter
public class RespostaDigitalitzarDocumentRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty(value = "Documentacio digitalitzat a l'expedient")
	private List<DocumentDigitalitzarAccioRDTO> documentacioDigitalitzat;

	@ApiModelProperty(value = "Registre de la documentació")
	private RegistreRDTO registre;

	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;

	@ApiModelProperty("Identificador del comprovant en PDF del registre del document incorporat")
	private BigDecimal comprovant;

}