package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.RegistreRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ResultatRespostaDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio.DocumentAportatAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.ExpedientAccioRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.sollicituds.SollicitudAccioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaAportarDocumentSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultat", "documentacioAportada", "registre", "expedient", "sollicitud", "comprovant" })
@Getter
@Setter

public class RespostaAportarDocumentSollicitudRDTO {

	@ApiModelProperty("Resultat de l'operació")
	private ResultatRespostaDTO resultat;

	@ApiModelProperty(value = "Documentacio aportada a l'expedient")
	private List<DocumentAportatAccioRDTO> documentacioAportada;

	@ApiModelProperty(value = "Registre de la documentació")
	private RegistreRDTO registre;

	@ApiModelProperty(value = "Expedient del document")
	private ExpedientAccioRDTO expedient;

	@ApiModelProperty(value = "Sol·licitud del document")
	private SollicitudAccioRDTO sollicitud;

}
