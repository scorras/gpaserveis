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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codi == null) ? 0 : codi.hashCode());
		result = prime * result + ((ordre == null) ? 0 : ordre.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadesAtributsValorsLlistaRDTO other = (DadesAtributsValorsLlistaRDTO) obj;
		if (codi == null) {
			if (other.codi != null)
				return false;
		} else if (!codi.equals(other.codi))
			return false;
		if (ordre == null) {
			if (other.ordre != null)
				return false;
		} else if (!ordre.equals(other.ordre))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
