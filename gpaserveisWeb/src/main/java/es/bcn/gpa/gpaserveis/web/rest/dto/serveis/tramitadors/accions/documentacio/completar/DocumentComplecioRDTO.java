package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.completar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.TipusEstatsDocumentsApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.ConfiguracioDocumentacioRequeridaRDTO;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.tramitadors.accions.documentacio.preparar.requeriment.DadaOperacioRequeritRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentComplecio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document" })
@Getter
@Setter
public class DocumentComplecioRDTO {

	@ApiModelProperty(value = "Document", required = true)
	private DocumentCompletatRDTO document;

	@ApiModelProperty(value = "Dades d'operació requerits")
	private List<DadaOperacioRequeritRDTO> dadesOperacioRequerits;

	@ApiModelProperty(value = "Documentació requerida")
	private List<ConfiguracioDocumentacioRequeridaRDTO> documentacioRequerida;
	
	@ApiModelProperty(value = "Estat del document.", allowableValues = TipusEstatsDocumentsApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String estat;

}
