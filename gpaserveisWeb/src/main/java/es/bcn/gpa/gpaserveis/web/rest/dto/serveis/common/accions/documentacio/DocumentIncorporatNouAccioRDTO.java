package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.accions.documentacio;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.ConfiguracioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.OrigenApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.document.RevisioApiParamValueTranslator;
import es.bcn.gpa.gpaserveis.web.rest.dto.serveis.common.ConfiguracioDocumentacioRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "DocumentIncorporatNouAccio")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nom", "configuracio", "configuracioDocumentacio", "origen", "revisio", "dataPresentacio", "dataModificacio" })
@Getter
@Setter
public class DocumentIncorporatNouAccioRDTO {

	@ApiModelProperty(value = "Id del document")
	private BigDecimal id;
	@ApiModelProperty(value = "Nom del document")
	private String nom;
	@ApiModelProperty(value = "Configuració del document", required = true, allowableValues = ConfiguracioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String configuracio;
	@ApiModelProperty(value = "Categoria a la qual pertany el document")
	private ConfiguracioDocumentacioRDTO configuracioDocumentacio;
	@ApiModelProperty(value = "Origen del tipus de documentació", allowableValues = OrigenApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String origen;
	@ApiModelProperty(value = "Estat de revisió del document", allowableValues = RevisioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String revisio;
	@ApiModelProperty(value = "Data de creació del document")
	private String dataCreacio;

}
