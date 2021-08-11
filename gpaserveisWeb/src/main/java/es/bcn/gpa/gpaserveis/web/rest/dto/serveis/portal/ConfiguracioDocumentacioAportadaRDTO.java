package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ConfiguracioDocumentacioAportada")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "descripcio", "descripcioCastella", "descripcioAmpliada", "descripcioAmpliadaCastella", "obligatori", "repetible", "visibilitat",
        "criticitat", "codiNti" })
@Getter
@Setter
public class ConfiguracioDocumentacioAportadaRDTO {
	
	@ApiModelProperty(value = "Codi de la configuració de documentació aportada")
	private String codi;
	@ApiModelProperty(value = "Descripció de la configuració de documentació aportada")
	private String descripcio;
	@ApiModelProperty(value = "Descripció de la configuració de documentació aportada en castellà")
	private String descripcioCastella;
	@ApiModelProperty(value = "Descripció ampliada de la configuració de documentació aportada")
	private String descripcioAmpliada;
	@ApiModelProperty(value = "Descripció ampliada de la configuració de documentació aportada en castellà")
	private String descripcioAmpliadaCastella;
	@ApiModelProperty(value = "Indica si la configuració configuració de documentació aportada és obligatori")
	private Boolean obligatori;
	@ApiModelProperty(value = "Indica si la configuració configuració de documentació aportada és repetible")
	private Boolean repetible;
	@ApiModelProperty(value = "Indica la visibilitat de la configuració de documentació aportada")
	private Boolean visibilitat;
	@ApiModelProperty(value = "Indica la criticitat de la configuració de documentació aportada")
	private String criticitat;
	@ApiModelProperty(value = "Codi Nti de la configuració de documentació aportada")
	private String codiNti;

}
