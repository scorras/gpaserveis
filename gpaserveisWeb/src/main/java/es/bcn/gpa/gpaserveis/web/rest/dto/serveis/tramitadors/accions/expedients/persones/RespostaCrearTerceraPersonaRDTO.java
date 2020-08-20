package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.persones;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.TercerPersonaCreadaAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaCrearTerceraPersona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "persona", "expedient" })
@Getter
@Setter
public class RespostaCrearTerceraPersonaRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty(value = "Tercera persona creada")
	private TercerPersonaCreadaAccioRDTO persona;

	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;

}
