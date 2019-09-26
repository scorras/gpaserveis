package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.recurs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.revisar.ProcedimentExpedientRevisarRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientRevisar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "procediment", "unitatGestora", "numeroRegistre", "sollicitant", "representant", "expedientObjecteDeRecurs" })
@Getter
@Setter
public class RecursExpedientRDTO {

	@ApiModelProperty(value = "Procediment associat a la sol·licitud", required = true)
	private ProcedimentExpedientRevisarRDTO procediment;
	@ApiModelProperty(value = "Unitat Gestora que tramitarà inicialment la sol·licitud", required = false)
	private UnitatGestoraExpedientRecursRDTO unitatGestora;
	@ApiModelProperty(value = "Número de registre.")
	private String numeroRegistre;
	@ApiModelProperty(value = "Persona sol·licitant", required = true)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Persona representant", required = false)
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Expedient objecte de recurs", required = false)
	private String expedientObjecteDeRecurs;

}
