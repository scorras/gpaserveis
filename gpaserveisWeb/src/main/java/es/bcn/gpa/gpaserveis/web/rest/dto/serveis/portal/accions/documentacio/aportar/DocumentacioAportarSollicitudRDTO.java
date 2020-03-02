package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.accions.documentacio.aportar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentacioAportarSollicitud")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentacio" })
@Getter
@Setter
public class DocumentacioAportarSollicitudRDTO {

	@ApiModelProperty(value = "Llista de documentació", required = true)
	private List<DocumentAportatCrearRDTO> documentacio;
}