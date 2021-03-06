package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.expedients.revisar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusIniciacioSollicitudApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientRevisar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "procediment", "unitatGestora", "numeroRegistre", "sollicitant", "representant", "personesInteressades",
		"personesImplicades" })
@Getter
@Setter
public class ExpedientRevisarRDTO {

	@ApiModelProperty(value = "Procediment associat a la sol·licitud", required = true)
	private ProcedimentExpedientRevisarRDTO procediment;
	@ApiModelProperty(value = "Unitat Gestora que tramitarà inicialment la sol·licitud", required = false)
	private UnitatGestoraExpedientRevisarRDTO unitatGestora;
	@ApiModelProperty(value = "Número de registre.")
	private String numeroRegistre;
	@ApiModelProperty(value = "Persona sol·licitant", required = true)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Persona representant", required = false)
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Persones interessades", required = false)
	private List<PersonesRDTO> personesInteressades;
	@ApiModelProperty(value = "Persones implicades", required = false)
	private List<PersonesRDTO> personesImplicades;
	@ApiModelProperty(value = "Iniciació de l'expedient", required = false, allowableValues = TipusIniciacioSollicitudApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String iniciacio;

}
