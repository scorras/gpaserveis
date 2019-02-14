package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ValorsValidacions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "valor", "ordre" })
@Getter
@Setter
public class DadesAtributsValorsValidacionsRDTO implements Comparable<DadesAtributsValorsValidacionsRDTO> {

	@ApiModelProperty(value = "Valor aplicable a la validació")
	private String valor;
	@ApiModelProperty(value = "Ordre del valor aplicable a la validació")
	private String ordre;

	@Override
	public int compareTo(DadesAtributsValorsValidacionsRDTO dadesAtributsValorsLlistaRDTO) {
		return this.ordre.compareTo(dadesAtributsValorsLlistaRDTO.getOrdre());
	}
}
