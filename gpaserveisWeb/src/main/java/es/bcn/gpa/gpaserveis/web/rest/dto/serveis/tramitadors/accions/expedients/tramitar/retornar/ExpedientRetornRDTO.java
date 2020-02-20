package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.retornar;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientRetorn")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comentari" })
@Getter
@Setter
public class ExpedientRetornRDTO {

	@ApiModelProperty(value = "Comentari associat al retorn.")
	private String comentari;
	
	@ApiModelProperty(value = "llista de ug convidadas a eliminar")
	private List<BigDecimal> llistaUGConvidadas;

}
