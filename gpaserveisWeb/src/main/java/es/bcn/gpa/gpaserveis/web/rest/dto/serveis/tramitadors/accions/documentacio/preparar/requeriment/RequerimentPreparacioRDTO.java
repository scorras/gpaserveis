package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "RequerimentPreparacio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document", "dadesOperacioRequerits", "documentacioRequerida" })
@Getter
@Setter
public class RequerimentPreparacioRDTO {

	@ApiModelProperty(value = "Document", required = true)
	private RequerimentPreparatRDTO document;

	@ApiModelProperty(value = "Dades d'operació requerits")
	private List<DadaOperacioRequeritRDTO> dadesOperacioRequerits;

	@ApiModelProperty(value = "Documentació requerida")
	private List<ConfiguracioDocumentacioRequeridaRDTO> documentacioRequerida;

}
