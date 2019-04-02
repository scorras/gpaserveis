package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.SuportConfeccioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ConfiguracioDocumentacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ConfiguracionDocumentacioAportadaConsulta")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "descripcio", "descripcioCastella", "descripcioAmpliada", "obligatori", "repetible", "suportConfeccio",
        "suportEnllac" })
@Getter
@Setter
public class ConfiguracioDocumentacioAportadaConsultaRDTO extends ConfiguracioDocumentacioRDTO {

	@ApiModelProperty(value = "Descripció ampliada del document")
	private String descripcioAmpliada;
	@ApiModelProperty(value = "Obligatori")
	private Boolean obligatori;
	@ApiModelProperty(value = "Repetible")
	private Boolean repetible;
	@ApiModelProperty(value = "Suport per a la confecció del document", allowableValues = SuportConfeccioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String suportConfeccio;
	@ApiModelProperty(value = "Enllaç document de suport per a la confecció del document")
	private String suportEnllac;

}
