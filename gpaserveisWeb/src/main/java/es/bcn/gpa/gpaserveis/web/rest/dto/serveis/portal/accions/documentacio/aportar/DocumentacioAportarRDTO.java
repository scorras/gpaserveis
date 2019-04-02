package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentacioAportar")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentacio", "registrar" })
@Getter
@Setter
public class DocumentacioAportarRDTO {

	@ApiModelProperty(value = "Llista de documentació", required = true)
	private List<DocumentAportatCrearRDTO> documentacio;

	@ApiModelProperty(value = "Indicador per registrar els documents aportats.")
	private boolean registrar;
}