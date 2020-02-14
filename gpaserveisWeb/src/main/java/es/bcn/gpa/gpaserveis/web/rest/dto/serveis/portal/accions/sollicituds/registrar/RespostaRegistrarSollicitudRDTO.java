package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.registrar;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds.SollicitudAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaRegistrarSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "expedient", "sollicitud", "registre", "comprovant" })
@Getter
@Setter
public class RespostaRegistrarSollicitudRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty("Expedient")
	private ExpedientAccioRDTO expedient;

	@ApiModelProperty("Sollicitud")
	private SollicitudAccioRDTO sollicitud;

	@ApiModelProperty("Dades del registre de l'expedient")
	private RegistreRDTO registre;

	@ApiModelProperty("Identificador del comprovant en PDF del registre del document incorporat")
	private BigDecimal comprovant;

}