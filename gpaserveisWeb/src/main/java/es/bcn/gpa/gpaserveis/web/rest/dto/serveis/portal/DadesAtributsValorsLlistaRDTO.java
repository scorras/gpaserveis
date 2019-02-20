package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ValorsLlista")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "valor", "ordre" })
@Getter
@Setter
public class DadesAtributsValorsLlistaRDTO implements Comparable<DadesAtributsValorsLlistaRDTO> {

	@ApiModelProperty(value = "Codi del valor de la llista")
	private String codi;
	@ApiModelProperty(value = "Valor de la llista")
	private String valor;
	@ApiModelProperty(value = "Ordre del valor de la llista")
	private String ordre;

	@Override
	public int compareTo(DadesAtributsValorsLlistaRDTO dadesAtributsValorsLlistaRDTO) {
		return this.ordre.compareTo(dadesAtributsValorsLlistaRDTO.getOrdre());
	}

}
