package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.procediment.SuportConfeccioApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Documents")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "codi", "descripcio", "descripcioAmpliada", "obligatori", "repetible", "suportConfeccio", "suportEnllac" })
@Getter
@Setter
public class DocumentsRDTO {

	@ApiModelProperty(value = "Identificador del document")
	private BigDecimal id;
	@ApiModelProperty(value = "Codi del document")
	private String codi;
	@ApiModelProperty(value = "Descripció del document")
	private String descripcio;
	@ApiModelProperty(value = "Descripció ampliada del document")
	private String descripcioAmpliada;
	@ApiModelProperty(value = "Obligatori")
	private boolean obligatori;
	@ApiModelProperty(value = "Repetible")
	private boolean repetible;
	@ApiModelProperty(value = "Suport per a la confecció del document", allowableValues = SuportConfeccioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String suportConfeccio;
	@ApiModelProperty(value = "Enllaç document de suport per a la confecció del document")
	private String suportEnllac;

}
