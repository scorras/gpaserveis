package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="DadesIdentificacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "informacioCiutada",
    "nivellAutenticacio",
    "terminisDuracio"
})
@Getter
@Setter
public class DadesIdentificacioRDTO {
	
	@ApiModelProperty(value="Informació complementària per a mostrar al ciutadà")
    private String informacioCiutada;
	@ApiModelProperty(value="Nivell d'autenticació requerit")
    private String nivellAutenticacio;
    private TerminisDuracioRDTO terminisDuracio;
    
}