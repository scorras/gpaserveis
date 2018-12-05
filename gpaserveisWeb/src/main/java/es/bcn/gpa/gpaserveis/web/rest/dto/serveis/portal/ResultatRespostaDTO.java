package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="UnitatGestora")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codi",
    "descripcio"
})
@Getter
@Setter
public class ResultatRespostaDTO {
	
	@ApiModelProperty(value="Codi resultat de l'operació",
			allowableValues = "FISICA, JURIDICA")
	private String codi;
	@ApiModelProperty(value="Descripció del resultat de l'operació")
	private String descripcio;
	
}
