package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.sollicituds.actualitzar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.PersonesRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.expedients.actualitzar.AtributsActualitzarRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SollicitudActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sollicitant", "representant", "personesInteressades", "personesImplicades", "dadesOperacio" })
@Getter
@Setter
public class SollicitudActualitzarRDTO {

	// @ApiModelProperty(value = "Unitat Gestora que tramitarà inicialment la
	// sol·licitud", required = false)
	// private UnitatGestoraSolicitudsCrearRDTO unitatGestora;
	@ApiModelProperty(value = "Persona sol·licitant", required = false)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Persona representant", required = false)
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Persones interessades", required = false)
	private List<PersonesRDTO> personesInteressades;
	@ApiModelProperty(value = "Persones implicades", required = false)
	private List<PersonesRDTO> personesImplicades;
	@ApiModelProperty(value = "Atributs", required = false)
	private List<AtributsActualitzarRDTO> dadesOperacio;

}
