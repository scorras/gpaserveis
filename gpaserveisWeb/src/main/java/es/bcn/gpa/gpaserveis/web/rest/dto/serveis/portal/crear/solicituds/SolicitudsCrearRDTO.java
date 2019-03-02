package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.crear.solicituds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.PersonesRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "SolicitudCrear")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "procediment", "unitatGestora", "sollicitant", "representant" })
@Getter
@Setter
public class SolicitudsCrearRDTO {

	@ApiModelProperty(value = "Procediment associat a la sol·licitud", required = true)
	private ProcedimentSolicitudsCrearRDTO procediment;
	@ApiModelProperty(value = "Unitat Gestora que tramitarà inicialment la sol·licitud", required = false)
	private UnitatGestoraSolicitudsCrearRDTO unitatGestora;
	@ApiModelProperty(value = "Persona sol·licitant", required = true)
	private PersonesRDTO sollicitant;
	@ApiModelProperty(value = "Persona representant", required = false)
	private PersonesRDTO representant;

}
