package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.acumular;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaAcumularExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "expedient", "acumulats" })
@Getter
@Setter
public class RespostaAcumularExpedientRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;
	@ApiModelProperty("Llistat d'expedients acumulats")
	private List<ExpedientAccioRDTO> acumulats;

}
