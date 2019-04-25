package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.OrigenApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.RevisioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal.ConfiguracioDocumentacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentAportatAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nom", "configuracioDocumentacio", "origen", "revisio", "dataPresentacio", "dataModificacio" })
@Getter
@Setter
public class DocumentAportatAccioRDTO {

	@ApiModelProperty(value = "Id del document")
	private BigDecimal id;
	@ApiModelProperty(value = "Nom del document")
	private String nom;
	@ApiModelProperty(value = "Categoria a la qual pertany el document")
	private ConfiguracioDocumentacioRDTO configuracioDocumentacio;
	@ApiModelProperty(value = "Origen del tipus de documentació", allowableValues = OrigenApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String origen;
	@ApiModelProperty(value = "Estat de revisió del document", allowableValues = RevisioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String revisio;
	@ApiModelProperty(value = "Data de presentació del document")
	private String dataPresentacio;
	@ApiModelProperty(value = "Data de modificacio del document")
	private String dataModificacio;

}
