package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DadesOperacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "grups" })
@Getter
@Setter
public class DadesOperacioConsultaRDTO {

	@ApiModelProperty("Llista de dades de grups")
	private List<DadesGrupsRDTO> grups = Collections.emptyList();

}
