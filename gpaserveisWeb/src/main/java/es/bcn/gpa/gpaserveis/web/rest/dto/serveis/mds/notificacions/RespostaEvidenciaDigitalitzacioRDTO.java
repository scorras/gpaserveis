package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.mds.notificacions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RespostaEvidenciaDigitalitzacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "idDocScan", "resultat", "dataDigitalitzacio", "idioma", "codiError", "descripcioError" })
@Getter
@Setter
public class RespostaEvidenciaDigitalitzacioRDTO {

	@ApiModelProperty(value = "Identificador d'opentext del document")
	private String idDocScan;
	@ApiModelProperty(value = "\"OK\" si l'escaneig s'ha realitzat correctament o \"KO\" en cas contrari.", allowableValues = "OK, KO")
	private String resultat;
	@ApiModelProperty(value = "Data i hora de digitalització del document si el resultat es OK")
	private String dataDigitalitzacio;
	@ApiModelProperty(value = "Idioma del document escanejat")
	private String idioma;
	@ApiModelProperty(value = "Codi de l'error si el resultat es KO")
	private String codiError;
	@ApiModelProperty(value = "Descripció de l'error si el resultat es KO")
	private String descripcioError;

}
