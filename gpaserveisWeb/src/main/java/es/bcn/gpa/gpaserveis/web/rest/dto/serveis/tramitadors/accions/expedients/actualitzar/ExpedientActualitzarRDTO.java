package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.actualitzar;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.TipusIniciacioSollicitudApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar.AtributsActualitzarRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sollicitant", "representant", "dadesOperacio", "personesInteressades", "personesImplicades", "tipusIniciacio",
        "respostaRequeriment", "respostaAllegacion", "expedientBackOffice" })
@Getter
@Setter
public class ExpedientActualitzarRDTO {

	@ApiModelProperty(value = "sol·licitant", required = true)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "representant", required = false)
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Atributs", required = false)
	private List<AtributsActualitzarRDTO> dadesOperacio;
	@ApiModelProperty(value = "Persones interessades", required = false)
	private List<PersonesRDTO> personesInteressades;
	@ApiModelProperty(value = "Persones implicades", required = false)
	private List<PersonesRDTO> personesImplicades;
	@ApiModelProperty(value = "Tipus de iniciació sollicitud", required = false, allowableValues = TipusIniciacioSollicitudApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String tipusIniciacio;
	@ApiModelProperty(value = "Termini d'esmenes", required = false)
	private BigDecimal respostaRequeriment;
	@ApiModelProperty(value = "Termini d'al·legacions.", required = false)
	private BigDecimal respostaAllegacion;
	@ApiModelProperty(value = "Expedient Back Office", required = false)
	private BigDecimal expedientBackOffice;

}
