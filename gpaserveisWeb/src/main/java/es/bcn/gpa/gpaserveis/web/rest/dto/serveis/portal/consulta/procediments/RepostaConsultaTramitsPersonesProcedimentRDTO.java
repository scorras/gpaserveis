package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.ProcedimentPersones;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ProcedimentPersonesRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ProcedimentTramitsPersones")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "terceresPersonesImplicades" })
@Getter
@Setter
public class RepostaConsultaTramitsPersonesProcedimentRDTO {
	@ApiModelProperty(value = "Liste de Persones de un Procediment")
	private List<ProcedimentPersonesRDTO>terceresPersonesImplicades;
}
