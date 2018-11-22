package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.procediments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaConsultaProcediments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "procediment"
})
@Getter
@Setter
public class RespostaConsultaProcedimentsRDTO {
    
	private ProcedimentsConsultaRDTO procediment;

}


