package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.DadesGrupsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.TramitsRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="DadesOperacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tramit",
    "grups"
})
@Getter
@Setter
public class DadesOperacioConsultaRDTO {
	
	private TramitsRDTO tramit;
    private List<DadesGrupsRDTO> grups = Collections.emptyList();
    
}
