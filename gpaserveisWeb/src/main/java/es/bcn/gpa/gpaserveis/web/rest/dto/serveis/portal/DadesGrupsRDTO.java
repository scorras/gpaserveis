package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Grups")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descripcio",
    "columnes",
    "ordre",
    "urlValidacio",
    "urlAjuda",
    "atributs"
})
@Getter
@Setter
public class DadesGrupsRDTO {
	
	@ApiModelProperty(value="Descripció del grup d'atributs")
    private String descripcio;
	@ApiModelProperty(value="Columnes del grup d'atributs")
    private String columnes;
	@ApiModelProperty(value="Ordre del grup d'atributs")
    private String ordre;
	@ApiModelProperty(value="URL de validació a nivell de grup d'atributs")
    private String urlValidacio;
    @ApiModelProperty(value="URL d'ajuda a nivell de grup d'atributs")
    private String urlAjuda;
    @ApiModelProperty(value="Atributs del grup")
    private List<DadesAtributsRDTO> atributs = Collections.emptyList();
    
}
