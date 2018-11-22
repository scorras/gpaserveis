package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="DadesContacte")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "telefon",
    "mobil",
    "fax",
    "tipusVia",
    "tipusVia",
    "numero",
    "escala",
    "bloc",
    "porta",
    "pis",
    "codiPostal",
    "municipi",
    "provincia",
    "comarca",
    "pais",
    "municipiEstranger",
    "provinciaEstranger"
})
@Getter
@Setter
public class DadesContacteRDTO {
	
	@ApiModelProperty(value="Email")
	private String email;
	@ApiModelProperty(value="Tel�fon fixe")
    private String telefon;
	@ApiModelProperty(value="Tel�fon mobil")
    private String mobil;
	@ApiModelProperty(value="Fax")
    private String fax;
    
	@ApiModelProperty(value="Tipus de via")
    private String tipusVia;
	@ApiModelProperty(value="Nom de la via")
    private String nomVia;
	@ApiModelProperty(value="N�mero")
    private String numero;
	@ApiModelProperty(value="Escala")
    private String escala;
	@ApiModelProperty(value="Bloc")
    private String bloc;
	@ApiModelProperty(value="Porta")
    private String porta;
	@ApiModelProperty(value="Pis")
    private String pis;
    
	@ApiModelProperty(value="Codi Postal")
    private String codiPostal;
	@ApiModelProperty(value="Municipi")
    private String municipi;
	@ApiModelProperty(value="Provincia")
    private String provincia;
	@ApiModelProperty(value="Comarca")
    private String comarca;
	@ApiModelProperty(value="Pais")
    private String pais;
    
	@ApiModelProperty(value="Municipi estranger")
    private String municipiEstranger;
	@ApiModelProperty(value="Provincia estrangera")
    private String provinciaEstranger;
    
}