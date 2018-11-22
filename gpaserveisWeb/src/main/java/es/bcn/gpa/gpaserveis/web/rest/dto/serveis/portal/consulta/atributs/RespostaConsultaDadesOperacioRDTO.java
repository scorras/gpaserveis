package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.atributs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="RespostaDadesOperacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dadesOperacio"
})
@Getter
@Setter
public class RespostaConsultaDadesOperacioRDTO {
    
	private DadesOperacioConsultaRDTO dadesOperacio;
	
}


