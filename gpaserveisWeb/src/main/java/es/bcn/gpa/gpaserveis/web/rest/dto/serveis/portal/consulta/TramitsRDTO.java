package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.consulta;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="Tramits")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "codi",
    "descripcio"
})
@Getter
@Setter
public class TramitsRDTO {
	
	@ApiModelProperty(value="Identificador del tr�mit")
    private BigDecimal id;
	@ApiModelProperty(value="Codi del tr�mit")
    private String codi;
	@ApiModelProperty(value="Descripci� del tr�mit")
    private String descripcio;
	
}