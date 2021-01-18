package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TercerPersonaActualitzadaAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaActualitzarTerceraPersona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "persona", "expedient" })
@Getter
@Setter
public class RespostaActualitzarTerceraPersonaRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty(value = "Tercera persona actualitzada")
	private TercerPersonaActualitzadaAccioRDTO persona;

	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;

}
