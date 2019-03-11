package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.actualitzar.solicituds;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SolicitudActualitzar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sollicitant", "representant", "dadesOperacio" })
@Getter
@Setter
public class SolicitudsActualitzarRDTO {

	// @ApiModelProperty(value = "Unitat Gestora que tramitarà inicialment la
	// sol·licitud", required = false)
	// private UnitatGestoraSolicitudsCrearRDTO unitatGestora;
	@ApiModelProperty(value = "Persona sol·licitant", required = false)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Persona representant", required = false)
	private PersonesRDTO representant;
	@ApiModelProperty(value = "Atributs", required = false)
	private List<AtributsActualitzarRDTO> dadesOperacio;

}
