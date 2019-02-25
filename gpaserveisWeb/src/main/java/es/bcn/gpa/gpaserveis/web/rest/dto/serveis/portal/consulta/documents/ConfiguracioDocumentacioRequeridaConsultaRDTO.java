package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ConfiguracioDocumentacioRequeridaConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({})
@Getter
@Setter
public class ConfiguracioDocumentacioRequeridaConsultaRDTO extends ConfiguracioDocumentacioAportadaConsultaRDTO {

}
