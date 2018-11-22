package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Historic")
@JsonPropertyOrder({
    "estat",
    "dataCreacio",
    "descripcio"
})
@Getter
@Setter
public class HistoricsRDTO {
	
	@ApiModelProperty(value="Estat de l'hist�ric")
    private String estat;
	@ApiModelProperty(value="Data de creaci� de l'hist�ric")
    private String dataCreacio;
	@ApiModelProperty(value="Descipci� de l'hist�ric")
    private String descripcio;
    
}
