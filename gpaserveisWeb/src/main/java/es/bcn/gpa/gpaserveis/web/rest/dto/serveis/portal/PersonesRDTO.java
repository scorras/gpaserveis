package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Persona")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "tipusPersona",
    "nomRaoSocial",
    "cognom1",
    "cognom2",
    "documentIndentitat",
    "dadesContacte"
})
@Getter
@Setter
public class PersonesRDTO {
	
	@ApiModelProperty(value="Identificador de la persona")
    private BigDecimal id;
	@ApiModelProperty(value="Tipus de persona",
			allowableValues = "FISICA, JURIDICA")
	private String tipusPersona;
    @ApiModelProperty(value="Nom o raó social de la persona")
    private String nomRaoSocial;
    @ApiModelProperty(value="Cognom 1 de la persona")
    private String cognom1;
    @ApiModelProperty(value="Cognom 2 de la persona")
    private String cognom2;
    private DocumentsIdentitatRDTO documentIndentitat;
    private DadesContacteRDTO dadesContacte;

}
