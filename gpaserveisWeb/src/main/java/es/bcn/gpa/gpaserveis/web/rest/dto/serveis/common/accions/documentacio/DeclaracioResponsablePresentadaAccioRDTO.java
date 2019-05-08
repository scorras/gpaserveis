package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.OrigenApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ConfiguracioDocumentacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DeclaracioResponsablePresentadaAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "configuracioDocumentacio", "origen", "dataCreacio" })
@Getter
@Setter
public class DeclaracioResponsablePresentadaAccioRDTO {

	@ApiModelProperty(value = "Id del document")
	private BigDecimal id;
	@ApiModelProperty(value = "Categoria a la qual pertany el document")
	private ConfiguracioDocumentacioRDTO configuracioDocumentacio;
	@ApiModelProperty(value = "Origen del tipus de documentació", allowableValues = OrigenApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String origen;
	@ApiModelProperty(value = "Data de creació del document")
	private String dataCreacio;

}
