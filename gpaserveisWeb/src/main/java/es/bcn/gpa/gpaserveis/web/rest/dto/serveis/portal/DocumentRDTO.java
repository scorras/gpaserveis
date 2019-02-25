package es.bcn.gpa.gpaserveis.web.rest.dto.serveis.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.bcn.gpa.gpaserveis.web.rest.controller.utils.translator.impl.expedient.RevisioApiParamValueTranslator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Document")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codi", "nom", "configuracioDocumentacio", "dataPresentacio", "registre", "revisio" })
@Getter
@Setter
public class DocumentRDTO {

	@ApiModelProperty(value = "Codi del document")
	private String codi;
	@ApiModelProperty(value = "Nom del document")
	private String nom;
	@ApiModelProperty(value = "Categoria a la qual pertany el document")
	private ConfiguracioDocumentacioRDTO configuracioDocumentacio;
	@ApiModelProperty(value = "Data de presentació del document")
	private String dataPresentacio;
	@ApiModelProperty(value = "Registre del document")
	private RegistreRDTO registre;
	@ApiModelProperty(value = "Estat de revisió del document", allowableValues = RevisioApiParamValueTranslator.REQUEST_PARAM_ALLOWABLE_VALUES)
	private String revisio;

}
