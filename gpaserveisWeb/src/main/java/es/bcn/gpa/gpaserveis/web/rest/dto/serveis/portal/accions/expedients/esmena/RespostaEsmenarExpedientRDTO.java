package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.esmena;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentAportatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaEsmenarExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "expedient", "comprovant" })
@Getter
@Setter
public class RespostaEsmenarExpedientRDTO {

	/** The resultat. */
	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	/** The expedient. */
	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;

	/** The comprovant. */
	@ApiModelProperty("Identificador del comprovant en PDF del registre del document incorporat")
	private BigDecimal comprovant;

	@ApiModelProperty(value = "Documentacio aportada a l'expedient")
	private List<DocumentAportatAccioRDTO> documentacioAportada;

}
