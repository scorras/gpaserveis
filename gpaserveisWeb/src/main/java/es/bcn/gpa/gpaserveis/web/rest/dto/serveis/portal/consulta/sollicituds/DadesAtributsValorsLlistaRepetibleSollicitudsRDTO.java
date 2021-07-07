package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.sollicituds;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value = "ValorsLlistaRepetibleSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "valorsLlista" })
@Getter
@Setter
public class DadesAtributsValorsLlistaRepetibleSollicitudsRDTO {
	
	@ApiModelProperty(value = "Si el tipus de camp de l'atribut és llista, valors d'aquesta llista")
	private List<DadesAtributsValorsLlistaSollicitudsRDTO> valorsLlista;

}
