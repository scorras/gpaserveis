package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.expedients.tramitar.convidar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ExpedientConvidarTramitar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codiUnitatGestoraList", "comentari" })
@Getter
@Setter
public class ExpedientConvidarTramitarRDTO {

	@ApiModelProperty(value = "Llista de codis de Unitat Gestora", required = true)
	private List<String> codiUnitatGestoraList;

	@ApiModelProperty(value = "Comentari associat a la invitació a tramitar.")
	private String comentari;

}
