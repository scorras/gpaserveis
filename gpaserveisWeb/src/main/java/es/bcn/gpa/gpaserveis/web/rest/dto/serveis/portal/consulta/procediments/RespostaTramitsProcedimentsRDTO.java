package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.rest.client.api.model.gpaprocediments.PaginationAttributes;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsOvtRDTO;
import es.bcn.gpa.gpaserveis.rest.client.api.model.gpatramits.TramitsRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.cerca.PaginacioRDTO;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaCercaProcediments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tramits",
    "tramitsovt"
})

@Getter
@Setter
public class RespostaTramitsProcedimentsRDTO {
	
	List<TramitsRDTO> tramits=Collections.emptyList();
	List<TramitsOvtRDTO> tramitsovt=Collections.emptyList();
}
