package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Atributs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codi",
    "descripcio",
    "ordre",
    "tipus",
    "validacions",
    "urlValidacio",
    "urlAjuda"
})
@Getter
@Setter
public class DadesAtributsRDTO {
	
	@ApiModelProperty(value="Codi de l'atribut")
    private String codi;
	@ApiModelProperty(value="Descripció de l'atribut")
    private String descripcio;
	@ApiModelProperty(value="Ordre del atribut dins del grup")
    private String ordre;
	@ApiModelProperty(value="Tipus de camp de l'atribut", 
			allowableValues = "INTEGER, DOUBLE, DATE, DATETIME, TIME, STRING, LARGE, CHECK, PAIS, COMARCA, PROVINCIA, MUNICIPI")
    private String tipus;
	@ApiModelProperty(value="Validacións de l'atribut")
    private String validacions;
	@ApiModelProperty(value="URL de validació a nivell d'atribut")
    private String urlValidacio;
	@ApiModelProperty(value="URL d'ajuda a nivell d'atribut")
    private String urlAjuda;
    
}
