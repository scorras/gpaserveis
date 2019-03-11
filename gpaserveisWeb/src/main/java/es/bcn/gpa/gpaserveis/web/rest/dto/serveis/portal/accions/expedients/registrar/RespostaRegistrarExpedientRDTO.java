package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.registrar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.ExpedientAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaRegistrarExpedient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "registre", "expedient" })
@Getter
@Setter
public class RespostaRegistrarExpedientRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;
	
	@ApiModelProperty("Dades del registre de l'expedient")
	private RegistreRDTO registre;
	
	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;

}