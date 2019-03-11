package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(value="Fitxer")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nom",
    "format",
    "ruta"
})
@Getter
@Setter
public class FitxerRDTO {
    
	@ApiModelProperty(value = "Nom del fitxer", required = true)
	String nom;
	@ApiModelProperty(value = "format del fitxer", required = true, allowableValues = "PDF,DOC,DOCX,XLS,XLSX,ZIP,RAR,XML,TXT,PPT,PPTX,ODT,BMP,JPG,GIF,PNG,TIFF")
	String format;
	@ApiModelProperty(value = "Ruta relativa de la ubicació del fitxer", required = true)
	String ruta;
}


