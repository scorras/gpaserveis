package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.validar;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentRevisio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "docsEntradaIds", "estatRevisioId", "expedientId" })
@Getter
@Setter
public class DocumentRevisioRDTO {

	@ApiModelProperty("Llista d'identificadors de document")
	public List<BigDecimal> docsEntradaIds;
	@ApiModelProperty("Identificador de l'estat de revisió")
	public Short estatRevisioId;
	@ApiModelProperty("Identificador de l'expedient")
	public BigDecimal expedientId;

}
